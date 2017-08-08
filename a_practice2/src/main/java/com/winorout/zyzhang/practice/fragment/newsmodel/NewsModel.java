package com.winorout.zyzhang.practice.fragment.newsmodel;

import android.util.Log;

import com.winorout.zyzhang.practice.api.NewsApi;
import com.winorout.zyzhang.practice.bean.LatestNews;
import com.winorout.zyzhang.practice.fragment.CallbackLatestNews;
import com.winorout.zyzhang.practice.fragment.INewsContract;

import java.util.List;

import rx.Subscriber;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/8/7 下午10:28
 */
public class NewsModel implements INewsContract.IModel {

    private static final String TAG = "NewsModel";

    @Override
    public void getLatestNews(final CallbackLatestNews callback) {
        Log.d("zyzhang", "--------------NewsModel---------------");
        Subscriber subscriber = new Subscriber<LatestNews>() {

            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "error: " + e);
            }

            @Override
            public void onNext(LatestNews latestNews) {
                Log.d(TAG, "onNext: ");
                callback.result(latestNews.getStories());
            }
        };
        NewsApi.getInstance().getLatestNews(subscriber);
    }
}
