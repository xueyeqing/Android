package com.winorout.zyzhang.androidpractice.fragment.fragmentpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.winorout.zyzhang.androidpractice.R;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/7/13 下午9:29
 */
public class HomeFragment extends Fragment {

    public static HomeFragment newInstance(String name) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("args", name);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        ViewStub practiceStub = (ViewStub) view.findViewById(R.id.practiceStub);
        practiceStub.setLayoutResource(R.layout.fragment_home);
        practiceStub.inflate();

        Bundle bundle = getArguments();
        String s = bundle.getString("args");
        TextView textView = (TextView) view.findViewById(R.id.home_tv);
        textView.setText(s);
        return view;
    }
}
