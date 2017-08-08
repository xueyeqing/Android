package com.winorout.zyzhang.practice.api;

import android.util.Log;

import com.winorout.zyzhang.practice.bean.LatestNews;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/8/8 下午9:22
 */
public class NewsApi {

    private static final int DEFAULT_TIMEOUT = 5;
    private NewsService newsService;
    private static NewsApi newsApi;
    private Retrofit retrofit;

    private NewsApi() {
        OkHttpClient.Builder httpcientBuilder = new OkHttpClient.Builder();

        retrofit = new Retrofit.Builder()
                .client(httpcientBuilder.build())
                .baseUrl(Config.NEWS_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        newsService = retrofit.create(NewsService.class);
    }

    public static NewsApi getInstance() {
        if (newsApi == null) {
            synchronized (NewsApi.class) {
                if (newsApi == null) {
                    newsApi = new NewsApi();
                }
            }
        }
        return newsApi;
    }

    public void getLatestNews(Subscriber<LatestNews> subscriber) {
        Log.d("zyzhang", "--------------NewsApi---------------");
        newsService.getLatestNews()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
