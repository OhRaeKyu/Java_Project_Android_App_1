package com.example.village;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
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

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {


    private static final String TAG = "MainActivity";
    private ArrayList<Item_main> arrayList;
    private Context context;
    byte[] byteArray;
    private Uri filePath;
    FirebaseStorage storage = FirebaseStorage.getInstance("gs://village-c49ce.appspot.com");

    public MainAdapter(ArrayList<Item_main> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override   //시작
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        MainViewHolder holder = new MainViewHolder(view);
        return holder;
    }


    //각 아이템 별 매칭
    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.iv_profile);
        holder.tv_username.setText(arrayList.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_id;
        TextView tv_pw;
        TextView tv_username;


        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.tv_id = itemView.findViewById(R.id.tv_id);
            this.tv_pw = itemView.findViewById(R.id.tv_pw);
            this.tv_username = itemView.findViewById(R.id.tv_username);
            super.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
