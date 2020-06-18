package com.example.village;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class setting extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

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