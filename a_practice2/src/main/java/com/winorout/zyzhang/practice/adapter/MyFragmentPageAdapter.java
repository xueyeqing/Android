package com.winorout.zyzhang.practice.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/7/27 下午9:04
 */
public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> list;
    private String[] titles;

    public MyFragmentPageAdapter(FragmentManager fm, String[] titles, ArrayList<Fragment> list) {
        super(fm);
        this.titles = titles;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    //重写这个方法，将设置每个Tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        Log.d("zyzhang", "position:" + position);
        return titles[position];
    }
}
