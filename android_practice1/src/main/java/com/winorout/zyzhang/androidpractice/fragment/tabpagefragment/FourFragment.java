package com.winorout.zyzhang.androidpractice.fragment.tabpagefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winorout.zyzhang.androidpractice.R;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/7/17 下午9:41
 */
public class FourFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fourfragment, container, false);
    }

}
