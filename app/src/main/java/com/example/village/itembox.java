package com.example.village;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class itembox extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Item> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itembox);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
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
        databaseReference = database.getReference("User");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear();//기존 배열리스트 존재하지않게 초기화(방지차원)
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {//데이터리스트 추출
                    Item item = snapshot.getValue(Item.class);//user객체 데이터 받는다
                    arrayList.add(item);//담은 데이터 배열리스트에 넣고 리사이클러뷰로 보낼 준비

                }
                adapter.notifyDataSetChanged(); //리스트저장및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //디비를 가져오던 중 에러 발생시
                Log.e("Itembox", String.valueOf(databaseError.toException()));//에러문출력
            }
        });



        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new CustomAdapter(arrayList, this);
        recyclerView.setAdapter(adapter);//리사이크러뷰에 어댑터 연결

        // 아래 버튼
        Button button5 = (Button) findViewById(R.id.bt_first);
        Button button6 = (Button) findViewById(R.id.bt_second);
        Button button7 = (Button) findViewById(R.id.bt_third);
        Button button8 = (Button) findViewById(R.id.bt_fourth);

        button5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), MainActivity.class));
                finish();
                overridePendingTransition(0, 0);
            }
        });

        button6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), store.class));
                finish();
                overridePendingTransition(0, 0);
            }
        });

        button7.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), itembox.class));
                finish();
                overridePendingTransition(0, 0);
            }
        });

        button8.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), setting.class));
                finish();
                overridePendingTransition(0, 0);
            }
        });
    }
}