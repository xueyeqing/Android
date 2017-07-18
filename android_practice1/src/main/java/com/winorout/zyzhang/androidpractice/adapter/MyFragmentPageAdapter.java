package com.winorout.zyzhang.androidpractice.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * @Description: 自定义fragment适配器
 * @Author: zyzhang
 * @Date: 17/7/12 下午10:32
 */
public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    private String[] titles;

    public MyFragmentPageAdapter(FragmentManager fm, String[] titles, List<Fragment> fragmentList) {
        super(fm);
        this.titles = titles;
        this.list = fragmentList;
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
        Log.d("zyzhang","position:"+position);
        return titles[position];
    }
}
