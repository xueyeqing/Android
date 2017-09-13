package com.winorout.zyzhang.gankdaily.rx;

import android.content.Context;

import com.winorout.zyzhang.gankdaily.mvprx.entity.GankData;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/9/12 下午7:40
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
                .baseUrl("http://gank.io/api/")
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

    public void getGankData(int year, int month, int day, Func1<GankData, GankData.Result> func1, Func1<GankData.Result, List<GankData.Result.Gank>> func2, Subscriber<List<GankData.Result.Gank>> subscriber) {
        getServer().getGankData(year, month, day)
                .map(func1)
                .map(func2)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
