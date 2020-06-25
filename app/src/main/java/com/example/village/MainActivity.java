package com.example.village;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Random;

import static android.graphics.Color.*;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Item_main> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView useImageView = (ImageView)findViewById(R.id.item_home);
        useImageView.setOnTouchListener(this);

        ImageView useItemView = (ImageView) findViewById(R.id.iv_profile);

        //어답터 연결
        recyclerView = findViewById(R.id.recyclerView_main);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setBackgroundColor(TRANSPARENT);
        RecyclerDecoration spaceDecoration = new RecyclerDecoration(24, 12);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();

        GridLayoutManager mLayoutManager;
        mLayoutManager = new GridLayoutManager(getApplicationContext(), 6);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int gridPosition = position % 6;
                switch (gridPosition) {
                    case 0:
                    case 1:
                    case 2:
                        return 2;
                    case 3:
                    case 4:
                    case 5:
                        return 2;
                }
                return 0;
            }
        });

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Main");
        //StorageReference st_ref = FirebaseStorage.getInstance().getReference("main/road.png");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear();//기존 배열리스트 존재하지않게 초기화(방지차원)
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {//데이터리스트 추출
                    Item_main item_main = snapshot.getValue(Item_main.class);//user객체 데이터 받는
                    arrayList.add(item_main);//담은 데이터 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
                adapter.notifyDataSetChanged(); //리스트저장및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //디비를 가져오던 중 에러 발생시
                Log.e("MainActivity", String.valueOf(databaseError.toException()));//에러문출력
            }
        });

        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new MainAdapter(arrayList, this);
        recyclerView.setAdapter(adapter);//리사이크러뷰에 어댑터 연결

/*        Intent intent = getIntent();
        String filename = intent.getStringExtra("filename");

       FirebaseStorage firebaseStorage = FirebaseStorage.getInstance("gs://village-c49ce.appspot.com");
       StorageReference storageRef = firebaseStorage.getReference();
       final StorageReference storageReference = storageRef.child("main/"+filename);

        storageReference.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()){
                        Glide.with(MainActivity.this)
                                .load(storageReference)
                                .into(useiew);
                        useItemView.bringToFront();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "불러오기 실패용", Toast.LENGTH_SHORT).show();
                    }
            }
        });*/

        // 아래 버튼
        ImageButton button = (ImageButton) findViewById(R.id.bt_first);
        ImageButton button2 = (ImageButton) findViewById(R.id.bt_second);
        ImageButton button3 = (ImageButton) findViewById(R.id.bt_third);
        ImageButton button4 = (ImageButton) findViewById(R.id.bt_fourth);

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), MainActivity.class));
                //finish();
                overridePendingTransition(0, 0);
            }
        });

        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), store.class));
                //finish();
                overridePendingTransition(0, 0);
            }
        });

        button3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), itembox.class));
                //finish();
                overridePendingTransition(0, 0);
            }
        });

        button4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), setting.class));
                overridePendingTransition(0, 0);
            }
        });

    }

    float oldXvalue;
    float oldYvalue;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int width = ((ViewGroup) v.getParent()).getWidth() - v.getWidth();
        int height = ((ViewGroup) v.getParent()).getHeight() - v.getHeight();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            oldXvalue = event.getX();
            oldYvalue = event.getY();
            Log.i("Tag1", "Action Down rX " + event.getRawX() + "," + event.getRawY());
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            v.setX(event.getRawX() - oldXvalue);
            v.setY(event.getRawY() - (oldYvalue + v.getHeight()));
        } else if (event.getAction() == MotionEvent.ACTION_UP) {

            if (v.getX() > width && v.getY() > height) {
                v.setX(width);
                v.setY(height);
            } else if (v.getX() < 0 && v.getY() > height) {
                v.setX(0);
                v.setY(height);
            } else if (v.getX() > width && v.getY() < 0) {
                v.setX(width);
                v.setY(0);
            } else if (v.getX() < 0 && v.getY() < 0) {
                v.setX(0);
                v.setY(0);
            } else if (v.getX() < 0 || v.getX() > width) {
                if (v.getX() < 0) {
                    v.setX(0);
                    v.setY(event.getRawY() - oldYvalue - v.getHeight());
                } else {
                    v.setX(width);
                    v.setY(event.getRawY() - oldYvalue - v.getHeight());
                }
            } else if (v.getY() < 0 || v.getY() > height) {
                if (v.getY() < 0) {
                    v.setX(event.getRawX() - oldXvalue);
                    v.setY(0);
                } else {
                    v.setX(event.getRawX() - oldXvalue);
                    v.setY(height);
                }
            }
        }
        return true;
    }
}