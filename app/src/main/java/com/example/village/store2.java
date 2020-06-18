package com.example.village;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class store2 extends Activity implements View.OnClickListener{

    Button button;
    Button button2;
    Button button3;
    ImageView plant;
    ImageView plant2;
    ImageView plant3;
    ImageView plant4;
    ImageView plant5;
    ImageView plant6;
    ImageView plant7;
    ImageView plant8;
    ImageView plant9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store2);

        // 버튼 변수
        button = (Button)findViewById(R.id.tab_first);
        button2 = (Button)findViewById(R.id.tab_second);
        button3 = (Button)findViewById(R.id.tab_third);

        plant = (ImageView)findViewById(R.id.plant);
        plant2 = (ImageView)findViewById(R.id.plant2);
        plant3 = (ImageView)findViewById(R.id.plant3);
        plant4 = (ImageView)findViewById(R.id.plant4);
        plant5 = (ImageView)findViewById(R.id.plant5);
        plant6 = (ImageView)findViewById(R.id.plant6);
        plant7 = (ImageView)findViewById(R.id.plant7);
        plant8 = (ImageView)findViewById(R.id.plant8);
        plant9 = (ImageView)findViewById(R.id.plant9);
        // 버튼에 이벤트 지정
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        plant.setOnClickListener(this);
        plant2.setOnClickListener(this);
        plant3.setOnClickListener(this);
        plant4.setOnClickListener(this);
        plant5.setOnClickListener(this);
        plant6.setOnClickListener(this);
        plant7.setOnClickListener(this);
        plant8.setOnClickListener(this);
        plant9.setOnClickListener(this);

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
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.plant:
                final EditText etEdit = new EditText(this);
                AlertDialog.Builder dialog = new AlertDialog.Builder(store2.this);
                dialog.setTitle("입력");
                dialog.setView(etEdit);

                // OK 버튼 이벤트
                dialog.setPositiveButton ("시작", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent4 = new Intent(getApplicationContext(), timer_page.class);
                        String inputValue = etEdit.getText().toString();
                        intent4.putExtra("String",inputValue);
                        intent4.putExtra("Name","plant");
                        int hour = 0;
                        int minute = 30;
                        int second = 0;
                        intent4.putExtra("hour",hour);
                        intent4.putExtra("minute",minute);
                        intent4.putExtra("second",second);
                        startActivity(intent4);
                        finish();
                    }
                });
                // Cancel 버튼 이벤트
                dialog.setNegativeButton("취소",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
                break;
            case R.id.plant2:
                final EditText etEdit2 = new EditText(this);
                AlertDialog.Builder dialog2 = new AlertDialog.Builder(store2.this);
                dialog2.setTitle("입력");
                dialog2.setView(etEdit2);

                // OK 버튼 이벤트
                dialog2.setPositiveButton ("시작", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent4 = new Intent(getApplicationContext(), timer_page.class);
                        String inputValue = etEdit2.getText().toString();
                        intent4.putExtra("String",inputValue);
                        intent4.putExtra("Name","plant2");
                        int hour = 1;
                        int minute = 0;
                        int second = 0;
                        intent4.putExtra("hour",hour);
                        intent4.putExtra("minute",minute);
                        intent4.putExtra("second",second);
                        startActivity(intent4);
                        finish();
                    }
                });
                // Cancel 버튼 이벤트
                dialog2.setNegativeButton("취소",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog2.show();
                break;
            case R.id.plant3:
                final EditText etEdit3 = new EditText(this);
                AlertDialog.Builder dialog3 = new AlertDialog.Builder(store2.this);
                dialog3.setTitle("입력");
                dialog3.setView(etEdit3);

                // OK 버튼 이벤트
                dialog3.setPositiveButton ("시작", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent4 = new Intent(getApplicationContext(), timer_page.class);
                        String inputValue = etEdit3.getText().toString();
                        intent4.putExtra("String",inputValue);
                        intent4.putExtra("Name","plant3");
                        int hour = 1;
                        int minute = 0;
                        int second = 0;
                        intent4.putExtra("hour",hour);
                        intent4.putExtra("minute",minute);
                        intent4.putExtra("second",second);
                        startActivity(intent4);
                        finish();
                    }
                });
                // Cancel 버튼 이벤트
                dialog3.setNegativeButton("취소",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog3.show();
                break;
            case R.id.plant4:
                final EditText etEdit4 = new EditText(this);
                AlertDialog.Builder dialog4 = new AlertDialog.Builder(store2.this);
                dialog4.setTitle("입력");
                dialog4.setView(etEdit4);

                // OK 버튼 이벤트
                dialog4.setPositiveButton ("시작", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent4 = new Intent(getApplicationContext(), timer_page.class);
                        String inputValue = etEdit4.getText().toString();
                        intent4.putExtra("String",inputValue);
                        intent4.putExtra("Name","plant4");
                        int hour = 0;
                        int minute = 40;
                        int second = 0;
                        intent4.putExtra("hour",hour);
                        intent4.putExtra("minute",minute);
                        intent4.putExtra("second",second);
                        startActivity(intent4);
                        finish();
                    }
                });
                // Cancel 버튼 이벤트
                dialog4.setNegativeButton("취소",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog4.show();
                break;
            case R.id.plant5:
                final EditText etEdit5 = new EditText(this);
                AlertDialog.Builder dialog5 = new AlertDialog.Builder(store2.this);
                dialog5.setTitle("입력");
                dialog5.setView(etEdit5);

                // OK 버튼 이벤트
                dialog5.setPositiveButton ("시작", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent4 = new Intent(getApplicationContext(), timer_page.class);
                        String inputValue = etEdit5.getText().toString();
                        intent4.putExtra("String",inputValue);
                        intent4.putExtra("Name","plant5");
                        int hour = 0;
                        int minute = 30;
                        int second = 0;
                        intent4.putExtra("hour",hour);
                        intent4.putExtra("minute",minute);
                        intent4.putExtra("second",second);
                        startActivity(intent4);
                        finish();
                    }
                });
                // Cancel 버튼 이벤트
                dialog5.setNegativeButton("취소",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog5.show();
                break;
            case R.id.plant6:
                final EditText etEdit6 = new EditText(this);
                AlertDialog.Builder dialog6 = new AlertDialog.Builder(store2.this);
                dialog6.setTitle("입력");
                dialog6.setView(etEdit6);

                // OK 버튼 이벤트
                dialog6.setPositiveButton ("시작", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent4 = new Intent(getApplicationContext(), timer_page.class);
                        String inputValue = etEdit6.getText().toString();
                        intent4.putExtra("String",inputValue);
                        intent4.putExtra("Name","plant6");
                        int hour = 1;
                        int minute = 10;
                        int second = 0;
                        intent4.putExtra("hour",hour);
                        intent4.putExtra("minute",minute);
                        intent4.putExtra("second",second);
                        startActivity(intent4);
                        finish();
                    }
                });
                // Cancel 버튼 이벤트
                dialog6.setNegativeButton("취소",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog6.show();
                break;
            case R.id.plant7:
                final EditText etEdit7 = new EditText(this);
                AlertDialog.Builder dialog7 = new AlertDialog.Builder(store2.this);
                dialog7.setTitle("입력");
                dialog7.setView(etEdit7);

                // OK 버튼 이벤트
                dialog7.setPositiveButton ("시작", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent4 = new Intent(getApplicationContext(), timer_page.class);
                        String inputValue = etEdit7.getText().toString();
                        intent4.putExtra("String",inputValue);
                        intent4.putExtra("Name","plant7");
                        int hour = 0;
                        int minute = 35;
                        int second = 0;
                        intent4.putExtra("hour",hour);
                        intent4.putExtra("minute",minute);
                        intent4.putExtra("second",second);
                        startActivity(intent4);
                        finish();
                    }
                });
                // Cancel 버튼 이벤트
                dialog7.setNegativeButton("취소",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog7.show();
                break;
            case R.id.plant8:
                final EditText etEdit8 = new EditText(this);
                AlertDialog.Builder dialog8 = new AlertDialog.Builder(store2.this);
                dialog8.setTitle("입력");
                dialog8.setView(etEdit8);

                // OK 버튼 이벤트
                dialog8.setPositiveButton ("시작", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent4 = new Intent(getApplicationContext(), timer_page.class);
                        String inputValue = etEdit8.getText().toString();
                        intent4.putExtra("String",inputValue);
                        intent4.putExtra("Name","plant8");
                        int hour = 1;
                        int minute = 0;
                        int second = 0;
                        intent4.putExtra("hour",hour);
                        intent4.putExtra("minute",minute);
                        intent4.putExtra("second",second);
                        startActivity(intent4);
                        finish();
                    }
                });
                // Cancel 버튼 이벤트
                dialog8.setNegativeButton("취소",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog8.show();
                break;
            case R.id.plant9:


                final EditText etEdit9 = new EditText(this);
                AlertDialog.Builder dialog9 = new AlertDialog.Builder(store2.this);
                dialog9.setTitle("입력");
                dialog9.setView(etEdit9);

                // OK 버튼 이벤트
                dialog9.setPositiveButton ("시작", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent4 = new Intent(getApplicationContext(), timer_page.class);
                        String inputValue = etEdit9.getText().toString();
                        intent4.putExtra("String",inputValue);
                        intent4.putExtra("Name","plant9");
                        int hour = 1;
                        int minute = 20;
                        int second = 0;
                        intent4.putExtra("hour",hour);
                        intent4.putExtra("minute",minute);
                        intent4.putExtra("second",second);
                        startActivity(intent4);
                        finish();
                    }
                });
                // Cancel 버튼 이벤트
                dialog9.setNegativeButton("취소",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog9.show();
                break;

            case R.id.tab_first:
                Intent intent = new Intent(getApplicationContext(), store.class);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
                break;

            case R.id.tab_second:
                Intent intent2 = new Intent(getApplicationContext(), store2.class);
                startActivity(intent2);
                finish();
                overridePendingTransition(0, 0);
                break;

            case R.id.tab_third:
                Intent intent3 = new Intent(getApplicationContext(), store3.class);
                startActivity(intent3);
                finish();
                overridePendingTransition(0, 0);
                break;

        }
    }
}
