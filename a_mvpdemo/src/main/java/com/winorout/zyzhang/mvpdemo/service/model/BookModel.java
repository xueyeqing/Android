package com.winorout.zyzhang.mvpdemo.service.model;

import android.util.Log;

import com.winorout.zyzhang.mvpdemo.service.IBookContract;
import com.winorout.zyzhang.mvpdemo.service.ICallBackResult;
import com.winorout.zyzhang.mvpdemo.service.RetrofitHelper;
import com.winorout.zyzhang.mvpdemo.service.entity.Book;

import rx.Subscriber;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/8/15 下午3:03
 */
public class BookModel implements IBookContract.IModel {

    @Override
    public void getBookList(String name, String tag, int start, int count, final ICallBackResult callback) {
        Subscriber subscriber = new Subscriber<Book>() {
            @Override
            public void onCompleted() {
                Log.d("zyzhang", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("zyzhang", "error:" + e);
            }

            @Override
            public void onNext(Book book) {
                callback.result(book);
            }
        };
        RetrofitHelper.getInstance().getBook(name, tag, start, count, subscriber);
    }
}
