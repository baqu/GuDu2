package com.bawei.macbook.gudu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类的用途 ：
 * zhangjiale
 * {DATE}
 */

public class LoveK extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.lk_main,null);
        return view;
    }
}
