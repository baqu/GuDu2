package com.bawei.macbook.gudu;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * 类的用途 ：
 * zhangjiale
 * {DATE}
 */

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{

    private TextView ye;
    private TextView fx;
    private TextView lk;
    private TextView wo;

    private Fragment currentF;
    private ShouYe shouYe;
    private FaXian faXian;
    private LoveK loveK;
    private YsHan ysHan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity3_main);


        initStarter();

        ye = (TextView) findViewById(R.id.ye);
        fx = (TextView) findViewById(R.id.fx);
        lk = (TextView) findViewById(R.id.lk);
        wo = (TextView) findViewById(R.id.wo);


        ye.setOnClickListener(this);
        fx.setOnClickListener(this);
        lk.setOnClickListener(this);
        wo.setOnClickListener(this);




    }

    private void initStarter() {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                //透明状态栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //透明导航栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
        }


    private void addFragments(Fragment f) {

        FragmentManager ma = getSupportFragmentManager();

        FragmentTransaction transaction = ma.beginTransaction();

        if (currentF != null) {
            transaction.hide(currentF);
        }

        if (!f.isAdded()) {
            transaction.add(R.id.frag, f);

        }
        transaction.show(f);

        transaction.commit();

        currentF = f;
    }

        @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.ye:

                    if (shouYe==null){
                        shouYe = new ShouYe();
                    }

                    addFragments(shouYe);
                    break;
                case R.id.fx:

                    if (faXian==null){
                        faXian = new FaXian();
                    }

                    addFragments(faXian);
                    break;


                case R.id.lk:
                    if (loveK==null){
                        loveK = new LoveK();
                    }

                    addFragments(loveK);
                    break;

                case R.id.wo:
                    if (ysHan==null){
                        ysHan = new YsHan();
                    }

                    addFragments(ysHan);
                    break;

                default:
                    break;
            }
    }
}
