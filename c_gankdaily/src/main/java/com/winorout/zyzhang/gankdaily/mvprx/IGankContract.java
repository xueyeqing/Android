package com.winorout.zyzhang.gankdaily.mvprx;

import com.winorout.zyzhang.gankdaily.mvprx.entity.GankData;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/9/12 下午5:34
 */
public interface IGankContract {

    interface IModel {
        void getData(Date date, int year, int month, int day, ICallBackResult callBackResult);
    }

    interface IView {
        void onSuccess(List<GankData.Result.Gank> listgank);
    }

    interface IPresenter {
        // 请求获取数据
        void getData(Date date);
    }
}
