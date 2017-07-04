package com.bawei.macbook.gudu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.maxwin.view.XListView;

/**
 * 类的用途 ：
 * zhangjiale
 * {DATE}
 */

public class ShouYe extends Fragment implements XListView.IXListViewListener {
    private XListView listview;
    private List<News.ItemListBean> list;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String result = msg.obj.toString();
            Gson gson = new Gson();
            News news = gson.fromJson(result, News.class);
            list.addAll(news.getItemList());
            adapter.notifyDataSetChanged();
        }
    };
    private Myadapter adapter;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.ye_main, null);

        initview();

        baqu();

        listview = (XListView) view.findViewById(R.id.listview);
        listview.setPullLoadEnable(true);
        listview.setPullRefreshEnable(true);
        listview.setXListViewListener(this);
         listview.addHeaderView(inflate);



listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(getActivity(),Ye_web.class);

        intent.putExtra("baqu",list.get(position).getData().getPlayInfo().get(position).getUrl());
        startActivity(intent);
    }
});

        list = new ArrayList<>();

        adapter = new Myadapter(getActivity(), list);


        listview.setAdapter(adapter);


        return view;
    }

    private void initview() {

        inflate = View.inflate(getActivity(), R.layout.ye_item1, null);

        ImageView image5 = (ImageView) inflate.findViewById(R.id.image5);
    }

    private void baqu() {

        new Thread() {
            @Override
            public void run() {
                super.run();

                String result = Utils.getUrlConnect("http://baobab.kaiyanapp.com/api/v4/tabs/selected");

                if (result != null) {

                    Message msg = Message.obtain();

                    msg.obj = result;
                    mHandler.sendMessage(msg);



                }
            }
        }.start();
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                baqu();
//                list.add(0,"XListView刷新==");
                // 如果适配器的内容改变时需要强制调用getView来刷新每个Item
                adapter.notifyDataSetInvalidated();
                onLoad();// 必须调用此方法，结束加载状态
            }
        }, 2000);


    }

    @Override
    public void onLoadMore() {

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                baqu();
                // 如果适配器的内容改变时需要强制调用getView来刷新每个Item
                adapter.notifyDataSetChanged();
                onLoad();// 必须调用此方法，结束加载状态
            }
        }, 2000);


    }

    private void onLoad() {
        listview.stopRefresh();//停止刷新
        listview.stopLoadMore();//停止加载更多
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-HH:mm:ss");//设置日期显示格式
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);// 将时间装换为设置好的格式
        listview.setRefreshTime(str);//设置时间111aaaa
    }

    class Myadapter extends BaseAdapter {

        Context context;
        List<News.ItemListBean> list;
        private ImageLoader imageLoader;


        public Myadapter(Context context, List<News.ItemListBean> list) {
            this.context = context;
            this.list = list;


            ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(context);
            imageLoader = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
            imageLoader.init(configuration);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            int type = getItemViewType(position);
            if (convertView == null) {


                holder = new ViewHolder();


                convertView = View.inflate(getActivity(), R.layout.ye_item, null);
                holder.image2 = (ImageView) convertView.findViewById(R.id.image2);
                holder.name = (TextView) convertView.findViewById(R.id.name);
                holder.lei = (TextView) convertView.findViewById(R.id.lei);
                holder.time = (TextView) convertView.findViewById(R.id.time);


                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }


            holder.name.setText(list.get(position).getData().getTitle());
            holder.lei.setText(list.get(position).getData().getCategory());
            holder.time.setText(list.get(position).getData().getCategory());


            Glide.with(getActivity()).load(list.get(position).getData().getCover().getFeed()).into(holder.image2);

            // imageLoader.displayImage(list.get(position).getData().getCover().getFeed(),holder.image2);

            return convertView;
        }

    }

    class ViewHolder {
        ImageView image2, image3;
        TextView name, lei, time, name1, lei1, time1, texttiao;
    }


}
