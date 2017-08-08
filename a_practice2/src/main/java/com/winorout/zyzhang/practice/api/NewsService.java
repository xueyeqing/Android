package com.winorout.zyzhang.practice.api;

import com.winorout.zyzhang.practice.bean.LatestNews;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/8/8 下午9:34
 */
public interface NewsService {

    @GET("api/4/news/latest")
    Observable<LatestNews> getLatestNews();
}
