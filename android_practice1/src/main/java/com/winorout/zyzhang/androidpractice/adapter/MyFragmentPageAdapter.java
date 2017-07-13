package com.winorout.zyzhang.androidpractice.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @Description: 自定义fragment适配器
 * @Author: zyzhang
 * @Date: 17/7/12 下午10:32
 */
public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    public MyFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
