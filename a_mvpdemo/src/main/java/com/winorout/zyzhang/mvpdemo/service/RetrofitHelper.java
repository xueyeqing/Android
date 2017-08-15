package com.winorout.zyzhang.mvpdemo.service;

import android.content.Context;

import com.winorout.zyzhang.mvpdemo.service.entity.Book;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @Description: Retrofit的初始
 * @Author: zyzhang
 * @Date: 17/8/15 下午2:17
 */
public class RetrofitHelper {

    private static RetrofitHelper instance = null;
    private Context mCntext;

    private Retrofit mRetrofit = null;
    private OkHttpClient client = new OkHttpClient();

    public static RetrofitHelper getInstance() {
        if (instance == null) {
            instance = new RetrofitHelper();
        }
        return instance;
    }

    private RetrofitHelper() {
        init();
    }

    private void init() {
        resetApp();
    }

    /**
     * 1.RxJava和retrofit的结合使用需要在Retrofit对象建立的时候添加一句代码addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
     * 2.添加转换器Converter(将json 转为JavaBean):addConverterFactory(GsonConverterFactory.create()).
     */
    private void resetApp() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 获取IRetrofitService接口类的实例化
     *
     * @return
     */
    public IRetrofitService getServer() {
        return mRetrofit.create(IRetrofitService.class);
    }

    public void getBook(String name, String tag, int start, int count, Subscriber<Book> subscriber) {
        getServer().getSearchBooks(name, tag, start, count)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}

