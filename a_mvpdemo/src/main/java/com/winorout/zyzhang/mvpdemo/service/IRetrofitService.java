package com.winorout.zyzhang.mvpdemo.service;

import com.winorout.zyzhang.mvpdemo.service.entity.Book;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @Description: 配合Rxjava实现（Observable）
 * @Author: zyzhang
 * @Date: 17/8/15 下午2:22
 */
public interface IRetrofitService {

    @GET("book/search")
    Observable<Book> getSearchBooks(@Query("q") String name,
                                    @Query("tag") String tag, @Query("start") int start,
                                    @Query("count") int count);
}
