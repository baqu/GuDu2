package com.bawei.macbook.gudu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


/**
 * 类的用途 ：
 * zhangjiale
 * {DATE}
 */

public class FaXian extends Fragment {


    private JCVideoPlayer jCVideoPlayer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.fx_main,null);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        jCVideoPlayer = (JCVideoPlayer) getView().findViewById(R.id.videocontroller1);
//        jCVideoPlayer.setUp("h∂ttp://uc.cdn.kaiyanapp.com/ca127ff7a8bfa21d5e334f8512a96a2c.mp4?t=1498052418&k=85946c10dbf47220","jiuqu.mp4");
        jCVideoPlayer.setUp("http://uc.cdn.kaiyanapp.com/ca127ff7a8bfa21d5e334f8512a96a2c.mp4?t=1498130482&k=db7f0e47e95047de","jiuqu.mp4");
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
