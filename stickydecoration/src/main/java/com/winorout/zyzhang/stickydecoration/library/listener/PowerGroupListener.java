package com.winorout.zyzhang.stickydecoration.library.listener;

import android.view.View;

/**
 * @Description: 显示自定义View的Group监听
 * @Author: zyzhang
 * @Date: 17/7/9 上午10:52
 */
public interface PowerGroupListener {
    String getGroupName(int position);

    View getGroupView(int position);
}
