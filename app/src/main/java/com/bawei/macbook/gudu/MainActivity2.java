package com.bawei.macbook.gudu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

/**
 * 类的用途 ：
 * zhangjiale
 * {DATE}
 */

public class MainActivity2 extends AppCompatActivity {

    private ImageView image1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity2_main);

        image1 = (ImageView) findViewById(R.id.image1);

        baqu();


    }

    private void baqu() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 1.2f, 1f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //3秒完成动画
        scaleAnimation.setDuration(4000);
        //将AlphaAnimation这个已经设置好的动画添加到 AnimationSet中


        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {


                Intent intent1 = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent1);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        image1.startAnimation(scaleAnimation);


    }
    }



