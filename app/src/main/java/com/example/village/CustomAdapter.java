package com.example.village;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicMarkableReference;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.loader.content.CursorLoader;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {


    private static final String TAG = "Itembox";
    private ArrayList<Item> arrayList;
    private Context context;
    byte[] byteArray;
    private Uri filePath;
    FirebaseStorage storage = FirebaseStorage.getInstance("gs://village-c49ce.appspot.com");

    public CustomAdapter(ArrayList<Item> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override   //시작
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }


    //각 아이템 별 매칭
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.iv_profile);
        holder.tv_username.setText(arrayList.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder
            implements View.OnCreateContextMenuListener {
        ImageView iv_profile;
        TextView tv_id;
        TextView tv_pw;
        TextView tv_username;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.tv_id = itemView.findViewById(R.id.tv_id);
            this.tv_pw = itemView.findViewById(R.id.tv_pw);
            this.tv_username = itemView.findViewById(R.id.tv_username);

            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            // 컨텍스트 메뉴를 생성하고 메뉴 항목 선택시 호출되는 리스너를 등록
            // ID 1001로 어떤 메뉴를 선택했는지 리스너에서 구분

            MenuItem Edit = menu.add(Menu.NONE, 1001, 1, "사용하기");
            Edit.setOnMenuItemClickListener(onEditMenu);
        }

        //컨텍스트 메뉴에서 항목 클릭시 동작을 설정
        private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
            private DatabaseReference mDatabase;
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case 1001:  //사용하기
                        //////////////////////////사용한아이템 DB저장

                       Intent intent = new Intent(itemView.getContext(),MainActivity.class);
                   //     intent.putExtra("image", String.valueOf(iv_profile));
                   //     intent.putExtra("String", String.valueOf(tv_username));
                       // intent.putExtra("profile", String.valueOf(iv_profile.getContext()));
                        itemView.getContext().startActivity(intent);
/////////////////////****************DBDB***********////////////////

                        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMHH_mmss");
                        Date now = new Date();
                        String filename = formatter.format(now);

                        StorageReference storageRef = storage.getReference();
                        StorageReference mountainImagesRef = storageRef.child("main/"+filename);


                        iv_profile.setDrawingCacheEnabled(true);
                        iv_profile.buildDrawingCache();
                        Bitmap bitmap = ((BitmapDrawable) iv_profile.getDrawable()).getBitmap();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                        byte[] data = baos.toByteArray();

                        UploadTask uploadTask = mountainImagesRef.putBytes(data);
                        uploadTask.addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {
                                // Handle unsuccessful uploads
                            }
                        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                                // ...
                            }
                        });

                        
                        ///////아이템사용처리/////////////////////////////////
                        GradientDrawable drawable =
                                (GradientDrawable) itemView.getContext().getDrawable(R.drawable.background_rounding);
                        itemView.setBackground(drawable);
                        itemView.setClipToOutline(true);
                }
                return true;
            }
        };
    }
}
