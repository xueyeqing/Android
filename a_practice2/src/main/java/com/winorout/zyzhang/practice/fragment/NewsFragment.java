package com.winorout.zyzhang.practice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winorout.zyzhang.practice.R;
import com.winorout.zyzhang.practice.bean.LatestNews;
import com.winorout.zyzhang.practice.fragment.newsmodel.NewsModel;
import com.winorout.zyzhang.practice.fragment.newspresenter.NewsPresenter;

import java.util.List;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/7/27 下午9:08
 */
public class NewsFragment extends Fragment implements INewsContract.IView {

    private INewsContract.IPresenter presenter;

    public NewsFragment() {
        presenter = new NewsPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, container, false);

        //
        presenter.getLatestNews();

        return view;
    }

    @Override
    public void refreshRecyclerVew(List<LatestNews.StoriesBean> lList) {
        for (int i = 0; i < lList.size(); i++) {
            Log.d("zyzhang", "title:" + lList.get(i).getTitle());
        }
    }
}
