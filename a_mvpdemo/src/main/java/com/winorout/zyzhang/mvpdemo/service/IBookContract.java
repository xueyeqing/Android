package com.winorout.zyzhang.mvpdemo.service;

import com.winorout.zyzhang.mvpdemo.service.entity.Book;

import java.util.List;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/8/15 下午2:53
 */
public interface IBookContract {

    interface IModel {
        void getBookList(String name, String tag, int start, int count,ICallBackResult callback);
    }

    interface IView {
        void onSuccess(Book mBook);
    }

    interface IPresenter {
        void getBookList(String name, String tag, int start, int count);
    }
}
