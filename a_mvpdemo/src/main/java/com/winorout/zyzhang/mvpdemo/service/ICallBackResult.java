package com.winorout.zyzhang.mvpdemo.service;

import com.winorout.zyzhang.mvpdemo.service.entity.Book;

import java.util.List;

/**
 * @Description: 请求数据的结果回调
 * @Author: zyzhang
 * @Date: 17/8/15 下午3:24
 */
public interface ICallBackResult {

    void result(Book book);
}
