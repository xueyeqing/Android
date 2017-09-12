package com.winorout.zyzhang.gankdaily.mvprx.presenter;

import com.orhanobut.logger.Logger;
import com.winorout.zyzhang.gankdaily.mvprx.ICallBackResult;
import com.winorout.zyzhang.gankdaily.mvprx.IGankContract;
import com.winorout.zyzhang.gankdaily.mvprx.entity.GankData;
import com.winorout.zyzhang.gankdaily.mvprx.model.GankModel;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 通知model请求数据返回数据，返回给view
 * @Author: zyzhang
 * @Date: 17/9/12 下午7:21
 */
public class GankPresenter implements IGankContract.IPresenter {

    private IGankContract.IModel iModel;
    private IGankContract.IView iView;
    private Date mCurrentDate;

    public GankPresenter(IGankContract.IView iView) {
        this.iView = iView;
        this.iModel = new GankModel();
    }


    @Override
    public void getData(Date date) {
        Logger.d("GankPresenter--------->getData");
        mCurrentDate = date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        iModel.getData(year, month, day, new ICallBackResult() {
            @Override
            public void result(GankData gank) {
                //
                Logger.d("GankPresenter--------->result");
                iView.onSuccess(gank);
            }
        });
    }

}
