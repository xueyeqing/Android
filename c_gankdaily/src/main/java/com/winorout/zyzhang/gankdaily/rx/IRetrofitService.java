package com.winorout.zyzhang.gankdaily.rx;

import com.winorout.zyzhang.gankdaily.mvprx.entity.GankData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/9/12 下午10:15
 */
public interface IRetrofitService {

    @GET("day/{year}/{month}/{day}")
    Observable<GankData> getGankData(@Path("year") int year, @Path("month") int month, @Path("day") int day);
}
