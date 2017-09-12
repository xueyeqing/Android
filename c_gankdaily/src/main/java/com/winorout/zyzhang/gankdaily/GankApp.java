package com.winorout.zyzhang.gankdaily;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/9/12 下午1:36
 */
public class GankApp extends Application {

    public static Context mContxt;

    @Override
    public void onCreate() {
        super.onCreate();
        mContxt = this;

        //只有调试模式下 才启用日志输出
        if (BuildConfig.DEBUG) {
            Logger.init("Gank").hideThreadInfo().setMethodCount(0);
        } else {
            Logger.init("Gank").setLogLevel(LogLevel.NONE);
        }
    }
}
