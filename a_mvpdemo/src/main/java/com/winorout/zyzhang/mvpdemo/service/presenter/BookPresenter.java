package com.winorout.zyzhang.mvpdemo.service.presenter;

import com.winorout.zyzhang.mvpdemo.service.IBookContract;
import com.winorout.zyzhang.mvpdemo.service.ICallBackResult;
import com.winorout.zyzhang.mvpdemo.service.entity.Book;
import com.winorout.zyzhang.mvpdemo.service.model.BookModel;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/8/15 下午3:06
 */
public class BookPresenter implements IBookContract.IPresenter {

    private IBookContract.IView view;
    private IBookContract.IModel model;

    public BookPresenter(IBookContract.IView iView) {
        this.view = iView;
        model = new BookModel();
    }

    @Override
    public void getBookList(String name, String tag, int start, int count) {
        model.getBookList(name, tag, start, count, new ICallBackResult() {
            @Override
            public void result(Book book) {
                view.onSuccess(book);
            }
        });
    }
}
