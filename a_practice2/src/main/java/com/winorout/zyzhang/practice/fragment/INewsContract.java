package com.winorout.zyzhang.practice.fragment;

import com.winorout.zyzhang.practice.bean.LatestNews;

import java.util.List;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/8/7 下午10:25
 */
public interface INewsContract {

    interface IView {
        void refreshRecyclerVew(List<LatestNews.StoriesBean> lList);
    }

    interface IPresenter {

        void getLatestNews();
    }

    interface IModel {
        void getLatestNews(CallbackLatestNews callback);
    }
}
