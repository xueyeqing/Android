package com.winorout.zyzhang.androidpractice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Description: 用于创建Fragment对象，作为ViewPager的叶片
 * @Author: zyzhang
 * @Date: 17/7/12 下午10:36
 */
public class PageFragment extends Fragment {


    /**
     * 为Fragment加载布局时调用
     **/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
