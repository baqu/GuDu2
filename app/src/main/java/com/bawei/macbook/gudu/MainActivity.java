package com.bawei.macbook.gudu;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private int count=3;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (count==0){

                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                finish();
            }

        }
    };
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        image = (ImageView) findViewById(R.id.image);


        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                if (count>0){
                    count--;
                    handler.sendEmptyMessage(0);
                }

            }
        },1000,1000);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer!=null){
            timer.cancel();
        }
    }
}
