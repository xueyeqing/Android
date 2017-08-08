package com.winorout.zyzhang.practice.fragment.newspresenter;

import android.util.Log;

import com.winorout.zyzhang.practice.bean.LatestNews;
import com.winorout.zyzhang.practice.fragment.CallbackLatestNews;
import com.winorout.zyzhang.practice.fragment.INewsContract;
import com.winorout.zyzhang.practice.fragment.newsmodel.NewsModel;

import java.util.List;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/8/7 下午10:28
 */
public class NewsPresenter implements INewsContract.IPresenter {

    private static final String TAG = "NewsPresenter";

    private INewsContract.IView view;
    private INewsContract.IModel model;

    public NewsPresenter(INewsContract.IView view) {
        this.view = view;
        model = new NewsModel();
    }

    @Override
    public void getLatestNews() {
        Log.d("zyzhang", "--------------NewsPresenter---------------");
        model.getLatestNews(new CallbackLatestNews() {
            @Override
            public void result(List<LatestNews.StoriesBean> list) {
                view.refreshRecyclerVew(list);
            }
        });
    }
}
