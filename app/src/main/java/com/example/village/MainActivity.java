package com.example.village;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 아래 버튼
        Button button = (Button) findViewById(R.id.bt_first);
        Button button2 = (Button) findViewById(R.id.bt_second);
        Button button3 = (Button) findViewById(R.id.bt_third);
        Button button4 = (Button) findViewById(R.id.bt_fourth);

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), MainActivity.class));
                finish();
                overridePendingTransition(0, 0);
            }
        }) ;

        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), store.class));
                finish();
                overridePendingTransition(0, 0);
            }
        }) ;

        button3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), itembox.class));
                finish();
                overridePendingTransition(0, 0);
            }
        }) ;

        button4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), setting.class));
                finish();
                overridePendingTransition(0, 0);
            }
        }) ;

    }

}