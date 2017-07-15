package com.winorout.zyzhang.androidpractice.fragment.fragmentpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;

import com.winorout.zyzhang.androidpractice.R;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/7/13 下午9:32
 */
public class PersonalFragment extends Fragment {

    public static PersonalFragment newInstance(String name) {
        PersonalFragment personalFragment = new PersonalFragment();
        Bundle bundle = new Bundle();
        bundle.putString("args", name);
        personalFragment.setArguments(bundle);
        return personalFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ViewStub practiceStub = (ViewStub) view.findViewById(R.id.practiceStub);
        practiceStub.setLayoutResource(R.layout.fragment_personal);
        practiceStub.inflate();

        Bundle bundle = getArguments();
        String s = bundle.getString("args");
        TextView textView = (TextView) view.findViewById(R.id.personal_tv);
        textView.setText(s);
        return view;
    }
}
