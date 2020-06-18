package com.example.village;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.NumberFormat;

import androidx.appcompat.app.AppCompatActivity;

public class timer_page extends AppCompatActivity {
    TextView textView2;
    private boolean state;
    ImageButton start;
    ImageView no;

    int h=0;
    int m=0;
    int s=0;
    private String TAG;
    ImageView image;
    byte[] byteArray;
    String Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_page);

        Intent intent4 = getIntent(); //이전 액티비티에서 수신할 데이터를 받기위해 선언
        String Receive = intent4.getStringExtra("String");       //호출한 액티비티에서 String 이라는 키 값을 가진 데이터 로드
        TextView textView = (TextView)findViewById(R.id.textView);
        image = (ImageView)findViewById(R.id.imageView2);

        textView.setText(Receive);
        Name = intent4.getStringExtra("Name");
        switch (Name) {
            case "animal":
                image.setImageResource(R.drawable.elephant);
                break;
            case "animal2":
                image.setImageResource(R.drawable.cat);
                break;
            case "animal3":
                image.setImageResource(R.drawable.whale);
                break;
            case "animal4":
                image.setImageResource(R.drawable.sheep);
                break;
            case "animal5":
                image.setImageResource(R.drawable.octopus);
                break;
            case "animal6":
                image.setImageResource(R.drawable.flamingo);
                break;
            case "animal7":
                image.setImageResource(R.drawable.giraffe);
                break;
            case "animal8":
                image.setImageResource(R.drawable.squirrel);
                break;
            case "animal9":
                image.setImageResource(R.drawable.hen);
                break;
            case "plant":
                image.setImageResource(R.drawable.flower);
                break;
            case "plant2":
                image.setImageResource(R.drawable.bush);
                break;
            case "plant3":
                image.setImageResource(R.drawable.flower1);
                break;
            case "plant4":
                image.setImageResource(R.drawable.flower2);
                break;
            case "plant5":
                image.setImageResource(R.drawable.flower3);
                break;
            case "plant6":
                image.setImageResource(R.drawable.forest);
                break;
            case "plant7":
                image.setImageResource(R.drawable.flower4);
                break;
            case "plant8":
                image.setImageResource(R.drawable.tree);
                break;
            case "plant9":
                image.setImageResource(R.drawable.forest1);
                break;
            case "extra":
                image.setImageResource(R.drawable.architecture);
                break;
            case "extra2":
                image.setImageResource(R.drawable.camping);
                break;
            case "extra3":
                image.setImageResource(R.drawable.landscape);
                break;
            case "extra4":
                image.setImageResource(R.drawable.fountain);
                break;
            case "extra5":
                image.setImageResource(R.drawable.mushroom);
                break;
            case "extra6":
                image.setImageResource(R.drawable.property);
                break;
            case "extra7":
                image.setImageResource(R.drawable.fence);
                break;
            case "extra8":
                image.setImageResource(R.drawable.house);
                break;
        }

        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byteArray = stream.toByteArray();

        h = intent4.getIntExtra("hour",0);
        m = intent4.getIntExtra("minute",0);
        s = intent4.getIntExtra("second",0);

        NumberFormat numfotmat= NumberFormat.getIntegerInstance();
        numfotmat.setMinimumIntegerDigits(2);

        textView2 = findViewById(R.id.time_number);
        start = findViewById(R.id.timerstart);
        no = findViewById(R.id.no);
        no.setVisibility(View.INVISIBLE); // 화면에보임

        String time=numfotmat.format(h)+":"+numfotmat.format(m)+":"+numfotmat.format(s);
        textView2.setText(time);
    }

//홈키제어
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        state=false;
//여기서 감지
        Log.d(TAG, "Home Button Touch");

        AlertDialog.Builder alert_confirm = new AlertDialog.Builder(timer_page.this);
        alert_confirm.setMessage("아이템 획득을 실패하셨습니다.\n확인을 눌러주세요.").setCancelable(false).setPositiveButton("확인",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { // 'YES'
                        Intent intent = new Intent(getApplicationContext(), failed.class);
                        startActivity(intent);
                    }
                });
        AlertDialog alert = alert_confirm.create();
        alert.show();
    }


    protected void onPause() {//메뉴버튼 금지//상태바도
        super.onPause();
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(ACTIVITY_SERVICE);
        activityManager.moveTaskToFront(getTaskId(), 0);
          }

//시작
    public void timer_start(View view) {
        new timer();
        state=true;
        start.setEnabled(false);
        no.setVisibility(View.VISIBLE); // 화면에 d안보임
    }

    public void onBackPressed() {

//뒤로가기 금지
    }

    //포기
    public void timer_giveup(View view) {
        state=false;
        AlertDialog.Builder alert_confirm = new AlertDialog.Builder(timer_page.this);
        alert_confirm.setMessage("지금 포기하시면 아이템 획득에 실패합니다.\n그래도 포기하시겠습니까?").setCancelable(false).setPositiveButton("확인",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), failed.class);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 'No'
                        new timer();
                        state=true;
                    }
                });
        AlertDialog alert = alert_confirm.create();
        alert.show();
    }


    //타이머
    class timer implements Runnable {
        Thread t1;
        public timer() {
            t1 = new Thread(this);
            t1.start();
        }
        @Override
        public void run() {
            // TODO Auto-generated method stub
            while(state) {
                try {
                    String time=iftime();
                    Thread.sleep(1000);
                    textView2.setText(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        private String iftime() {
            NumberFormat numfotmat= NumberFormat.getIntegerInstance();
            numfotmat.setMinimumIntegerDigits(2);

            // TODO Auto-generated method stub
            if(s==0&&m==0) {
                if(h>=1) {
                    h--;
                    s=59;
                    m=59;
                }
                else {
                    state=false;
//
//                    Intent intent = new Intent(getApplicationContext(), win.class);
//                    startActivity(intent);
                    Intent intent = new Intent(getApplicationContext(), win.class);
                    intent.putExtra("String",Name);
                    intent.putExtra("image",byteArray);
                    startActivity(intent);
                    finish();
                }
            }
            else if(s>0&&m==0) {
                s--;
            }
            else if(s==0&&m>0) {
                m--;
                s=59;
            }
            else if(s>0&&m>0)
                s--;

            String time =numfotmat.format(h)+":"+numfotmat.format(m)+":"+numfotmat.format(s);
            return time;
        }
    }


}

