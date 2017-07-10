package com.winorout.zyzhang.activity.android_stickydecoration;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.winorout.zyzhang.activity.android_stickydecoration.adapter.SimpleAdapter;
import com.winorout.zyzhang.activity.android_stickydecoration.module.City;
import com.winorout.zyzhang.activity.android_stickydecoration.util.CityUtil;
import com.winorout.zyzhang.activity.android_stickydecoration.util.DensityUtil;
import com.winorout.zyzhang.stickydecoration.library.PowerfulDecoration;
import com.winorout.zyzhang.stickydecoration.library.listener.PowerGroupListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description: 自定义悬浮框
 * @Author: zyzhang
 * @Date: 17/7/9 上午9:21
 */
public class PowerfulStickyRecycleViewActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView mRecycleView;

    ArrayList<City> dataList = new ArrayList<>();
    SimpleAdapter mAdapter;
    LinearLayoutManager manager;
    PowerfulDecoration decoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sticky_recycler_view);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //模拟数据
        dataList.addAll(CityUtil.getCityList());

        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new SimpleAdapter(dataList);
        mRecycleView.setLayoutManager(manager);

        decoration = PowerfulDecoration.Builder.init(new PowerGroupListener() {
            @Override
            public String getGroupName(int position) {
                //获取组名，用于判断是否是同一组
                if (dataList.size() > position) {
                    return dataList.get(position).getProvince();
                }
                return null;
            }

            @Override
            public View getGroupView(int position) {
                //获取自定定义的组View
                if (dataList.size() > position) {
                    View view = getLayoutInflater().inflate(R.layout.item_group, null, false);
                    ((TextView) view.findViewById(R.id.tv)).setText(dataList.get(position).getProvince());
                    return view;
                } else {
                    return null;
                }
            }
        }).setGroupHeight(DensityUtil.dip2px(this, 40))       //设置高度
                .isAlignLeft(false)                                 //靠右边显示   默认左边
                .setGroupBackground(Color.parseColor("#48BDFF"))    //设置背景   默认透明
                .setDivideColor(Color.parseColor("#CCCCCC"))        //分割线颜色
                .setDivideHeight(DensityUtil.dip2px(this, 1))       //分割线高度
                .build();

        mRecycleView.addItemDecoration(decoration);
        mRecycleView.setAdapter(mAdapter);
    }
}
