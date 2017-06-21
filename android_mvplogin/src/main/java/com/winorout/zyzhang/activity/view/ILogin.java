package com.winorout.zyzhang.activity.view;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/6/21 下午12:32
 */
public interface ILogin {

    void showProgress();

    void hideProgress();

    void setPasswordError();

    String getUsername();

    String getPassword();

    void loginSuccess();
}
