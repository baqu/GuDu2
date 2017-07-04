package com.bawei.macbook.gudu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * 类的用途 ：
 * zhangjiale
 * {DATE}
 */

public class Ye_web extends AppCompatActivity {

    private WebView web;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ye_web);


        web = (WebView) findViewById(R.id.web);


        Intent intent = getIntent();

        String baqu = intent.getStringExtra("baqu");

        web.loadUrl(baqu);

    }
}
