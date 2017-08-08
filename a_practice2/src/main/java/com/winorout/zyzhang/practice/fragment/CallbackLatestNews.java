package com.winorout.zyzhang.practice.fragment;

import com.winorout.zyzhang.practice.bean.LatestNews;

import java.util.List;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/8/7 下午10:31
 */
public interface CallbackLatestNews {

    public void result(List<LatestNews.StoriesBean> list);
}
