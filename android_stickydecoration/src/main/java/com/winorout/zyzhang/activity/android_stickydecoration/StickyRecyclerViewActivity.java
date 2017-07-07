package com.winorout.zyzhang.activity.android_stickydecoration;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.winorout.zyzhang.activity.android_stickydecoration.adapter.SimpleAdapter;
import com.winorout.zyzhang.activity.android_stickydecoration.module.City;
import com.winorout.zyzhang.activity.android_stickydecoration.util.CityUtil;
import com.winorout.zyzhang.activity.android_stickydecoration.util.DensityUtil;
import com.winorout.zyzhang.stickydecoration.library.StickyDecoration;
import com.winorout.zyzhang.stickydecoration.library.listener.GroupListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description: 文字悬浮
 * @Author: zyzhang
 * @Date: 17/7/2 下午2:13
 */
public class StickyRecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView mRecycleView;

    ArrayList<City> dataList = new ArrayList<>();
    SimpleAdapter mAdapter;
    LinearLayoutManager manager;
    StickyDecoration decoration;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_recycler_view);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {

        //模拟数据
        dataList.addAll(CityUtil.getCityList());

        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new SimpleAdapter(dataList);

        //使用StickyDecoration
        decoration = StickyDecoration.Builder.init(new GroupListener() {
            @Override
            public String getGroupName(int position) {
                //组名回调
                if (dataList.size() > position) {
                    //获取城市对应的省份
                    return dataList.get(position).getProvince();
                }
                return null;
            }
        })
                .setGroupBackground(Color.parseColor("#48BDFF")) //背景色
                .setGroupHeight(DensityUtil.dip2px(this, 35)) //高度
                .setDivideColor(Color.parseColor("#CCCCCC"))  //分割线颜色
                .setDivideHeight(DensityUtil.dip2px(this, 1))  //分割线高度 (默认没有分割线)
                .setGroupTextColor(Color.WHITE)                //字体颜色
                .setGroupTextSize(DensityUtil.sp2px(this, 15)) //字体大小
                .setTextSideMargin(DensityUtil.dip2px(this, 10)) // 边距   靠左时为左边距  靠右时为右边距
                .isAlignLeft(false)   //靠右显示  （默认靠左）
                .build();
    }

    private void initView() {
        // 设置布局管理器
        mRecycleView.setLayoutManager(manager);
        // 设置adapter
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.addItemDecoration(decoration);
    }
}
