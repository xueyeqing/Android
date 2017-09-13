package com.winorout.zyzhang.gankdaily.mvprx;

import com.winorout.zyzhang.gankdaily.mvprx.entity.GankData;

import java.util.List;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/9/12 下午8:08
 */
public interface ICallBackResult {

    void result(List<GankData.Result.Gank> listgank);
}
