package com.winorout.zyzhang.gankdaily.mvprx.model;

import com.orhanobut.logger.Logger;
import com.winorout.zyzhang.gankdaily.mvprx.ICallBackResult;
import com.winorout.zyzhang.gankdaily.mvprx.IGankContract;
import com.winorout.zyzhang.gankdaily.mvprx.entity.GankData;
import com.winorout.zyzhang.gankdaily.rx.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.functions.Func1;


/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/9/12 下午7:23Ø
 */
public class GankModel implements IGankContract.IModel {

    List<GankData.Gank> mGankList = new ArrayList<>();

    @Override
    public void getData(int year, int month, int day, final ICallBackResult callBackResult) {
        Logger.d("Model:网络请求开始");
        
        Subscriber subscriber = new Subscriber<GankData>() {
            @Override
            public void onCompleted() {
                Logger.d("Model:onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("Model:onError");
            }

            @Override
            public void onNext(GankData gankData) {
                Logger.d("Model:onNext");
                callBackResult.result(gankData);
            }
        };
        RetrofitHelper.getInstance().getGankData(year, month, day, subscriber);
    }
}
