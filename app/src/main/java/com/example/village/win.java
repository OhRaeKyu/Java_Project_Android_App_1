package com.example.village;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class win extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win);

        Bundle extras=getIntent().getExtras();
        String s=extras.getString("String");
        byte[] data =getIntent().getByteArrayExtra("image");
        StorageReference mountainImagesRef = storageRef.child("images/"+s+".png");
        String userName = "user" + new Random().nextInt(10000);
        String profile = "https://firebasestorage.googleapis.com/v0/b/village-c49ce.appspot.com/o/images%2F"+s+".png?alt=media&token=9fd9622b-e261-4aeb-aded-0344bf274ab3";
        Item chatData = new Item(userName, profile);  // 유저 이름과 메세지로 chatData 만들기
        databaseReference.child("User").push().setValue(chatData);  // 기본 database 하위 message라는 child에 chatData를 list로 만들기
       // editText.setText("");


        UploadTask uploadTask = mountainImagesRef.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(getApplicationContext(), "실패!", Toast.LENGTH_LONG).show();

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Toast.makeText(getApplicationContext(), "성공!", Toast.LENGTH_LONG).show();
            }
        });

    }


//
//    public class ChatData extends Item {
//        private String userName;
//        private String profile;
//
//        public ChatData() { }
//
//        public ChatData(String userName, String profile) {
//            this.userName = userName;
//            this.profile = profile;
//        }
//
//        public String getUserName() {
//            return userName;
//        }
//
//        public void setUserName(String userName) {
//            this.userName = userName;
//        }
//
//        public String getMessage() {
//            return profile;
//        }
//
//        public void setMessage(String profile) {
//            this.profile = profile;
//        }
//    }


    public void onBackPressed() {
//뒤로가기 금지
    }
    public void storage(View view) {
        startActivity(new Intent(getApplication(), itembox.class));
        finish();
    }
}

