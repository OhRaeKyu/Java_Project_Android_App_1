package com.example.village;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class setting extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // 아래 버튼
        ImageButton button5 = (ImageButton) findViewById(R.id.bt_first);
        ImageButton button6 = (ImageButton) findViewById(R.id.bt_second);
        ImageButton button7 = (ImageButton) findViewById(R.id.bt_third);
        ImageButton button8 = (ImageButton) findViewById(R.id.bt_fourth);

        button5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), MainActivity.class));
                finish();
                overridePendingTransition(0, 0);
            }
        }) ;

        button6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), store.class));
                finish();
                overridePendingTransition(0, 0);
            }
        }) ;

        button7.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), itembox.class));
                finish();
                overridePendingTransition(0, 0);
            }
        }) ;

        button8.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), setting.class));
                finish();
                overridePendingTransition(0, 0);
            }
        }) ;

    }
}