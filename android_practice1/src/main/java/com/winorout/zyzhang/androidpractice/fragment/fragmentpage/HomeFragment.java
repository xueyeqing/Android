package com.winorout.zyzhang.androidpractice.fragment.fragmentpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.winorout.zyzhang.androidpractice.R;
import com.winorout.zyzhang.androidpractice.adapter.MyFragmentPageAdapter;
import com.winorout.zyzhang.androidpractice.fragment.tabpagefragment.FiveFragment;
import com.winorout.zyzhang.androidpractice.fragment.tabpagefragment.FourFragment;
import com.winorout.zyzhang.androidpractice.fragment.tabpagefragment.OneFragment;
import com.winorout.zyzhang.androidpractice.fragment.tabpagefragment.SevenFragment;
import com.winorout.zyzhang.androidpractice.fragment.tabpagefragment.SexFragment;
import com.winorout.zyzhang.androidpractice.fragment.tabpagefragment.ThreeFragment;
import com.winorout.zyzhang.androidpractice.fragment.tabpagefragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/7/13 下午9:29
 */
public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager pager;
    private List<Fragment> list;
    private String[] titles = {"页面1", "页面2", "页面3", "页面4", "页面5", "页面6", "页面7"};

    public static HomeFragment newInstance(String name) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("args", name);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //页面，数据源
        list = new ArrayList<>();
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new ThreeFragment());
        list.add(new FourFragment());
        list.add(new FiveFragment());
        list.add(new SexFragment());
        list.add(new SevenFragment());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        ViewStub practiceStub = (ViewStub) view.findViewById(R.id.practiceStub);
        practiceStub.setLayoutResource(R.layout.fragment_home);
        practiceStub.inflate();

        pager = (ViewPager) view.findViewById(R.id.pager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        Log.d("zyzhang", "size" + list.size());

        MyFragmentPageAdapter adapter = new MyFragmentPageAdapter(getActivity().getSupportFragmentManager(), titles, list);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);

        return view;
    }

}
