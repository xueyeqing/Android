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
 * @Description:Ø
 * @Author: zyzhang
 * @Date: 17/7/13 下午9:31
 */
public class LikeFragment extends Fragment {

    public static LikeFragment newInstance(String name) {
        LikeFragment likeFragment = new LikeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("args", name);
        likeFragment.setArguments(bundle);
        return likeFragment;
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
