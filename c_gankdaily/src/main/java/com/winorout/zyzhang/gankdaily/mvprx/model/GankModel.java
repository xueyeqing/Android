package com.winorout.zyzhang.gankdaily.mvprx.model;

import com.orhanobut.logger.Logger;
import com.winorout.zyzhang.gankdaily.mvprx.ICallBackResult;
import com.winorout.zyzhang.gankdaily.mvprx.IGankContract;
import com.winorout.zyzhang.gankdaily.mvprx.entity.GankData;
import com.winorout.zyzhang.gankdaily.rx.RetrofitHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rx.Subscriber;
import rx.functions.Func1;


/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/9/12 下午7:23Ø
 */
public class GankModel implements IGankContract.IModel {

    private static final int DAY_OF_MILLISECOND = 24 * 60 * 60 * 1000;

    private List<GankData.Result.Gank> mGankList = new ArrayList<>();

    @Override
    public void getData(final Date date, final int year, final int month, final int day, final ICallBackResult callBackResult) {
        Logger.d("Model:网络请求开始");

        final Func1<GankData, GankData.Result> func1 = new Func1<GankData, GankData.Result>() {
            @Override
            public GankData.Result call(GankData gankData) {
                return gankData.results;
            }
        };

        final Func1<GankData.Result, List<GankData.Result.Gank>> func2 = new Func1<GankData.Result, List<GankData.Result.Gank>>() {
            @Override
            public List<GankData.Result.Gank> call(GankData.Result gank) {
                return addAllResults(gank);
            }
        };

        final Subscriber subscriber = new Subscriber<List<GankData.Result.Gank>>() {
            @Override
            public void onCompleted() {
                Logger.d("Model:onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("Model:onError");
            }

            @Override
            public void onNext(List<GankData.Result.Gank> listgank) {
                Logger.d("Model:onNext");
                callBackResult.result(listgank);
            }
        };
        RetrofitHelper.getInstance().getGankData(year, month, day, func1, func2, subscriber);
    }

    private List<GankData.Result.Gank> addAllResults(GankData.Result results) {
        mGankList.clear();
        if (results.androidList != null) mGankList.addAll(results.androidList);
        if (results.iOSList != null) mGankList.addAll(results.iOSList);
        if (results.拓展资源List != null) mGankList.addAll(results.拓展资源List);
        if (results.前端List != null) mGankList.addAll(results.前端List);
        if (results.休息视频List != null) mGankList.addAll(results.休息视频List);
        // make meizi data is in first position
        if (results.妹纸List != null) mGankList.addAll(0, results.妹纸List);
        Logger.d(mGankList + "");
        return mGankList;
    }
}
