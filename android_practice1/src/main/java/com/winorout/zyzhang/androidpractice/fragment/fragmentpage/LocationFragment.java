package com.winorout.zyzhang.androidpractice.fragment.fragmentpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.winorout.zyzhang.androidpractice.R;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/7/13 下午9:30
 */
public class LocationFragment extends Fragment {

    public static LocationFragment newInstance(String name) {
        LocationFragment locationFragment = new LocationFragment();
        Bundle bundle = new Bundle();
        bundle.putString("args", name);
        locationFragment.setArguments(bundle);
        return locationFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        Bundle bundle = getArguments();
        String s = bundle.getString("args");
        TextView textView = (TextView) view.findViewById(R.id.activity_text_view);
        textView.setText(s);
        return view;
    }
}
