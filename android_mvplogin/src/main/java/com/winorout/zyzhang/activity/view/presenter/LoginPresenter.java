package com.winorout.zyzhang.activity.view.presenter;

import android.os.Handler;

import com.winorout.zyzhang.activity.view.ILogin;
import com.winorout.zyzhang.activity.view.model.UserModel;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/6/20 上午12:20
 */
public class LoginPresenter implements ILoginPresenter {

    private ILogin iLogin;
    private UserModel mUser;

    public LoginPresenter(ILogin iLogin) {
        this.iLogin = iLogin;
        //获取用户名和密码
        initUser();
    }

    private void initUser() {
        mUser = new UserModel(iLogin.getUsername(), iLogin.getPassword());
    }

    /**
     * 模拟登录
     *
     * @param name
     * @param pass
     */
    @Override
    public void Login(String name, String pass) {
        //弹出登录框
        iLogin.showProgress();
        //执行
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //登录成功，关闭登录框
                iLogin.hideProgress();
                int code = mUser.checkUserValidity(iLogin.getUsername(), iLogin.getPassword());

                if (code == -1) {
                    iLogin.setPasswordError();
                } else if (code == 0) {
                    iLogin.loginSuccess();
                }
            }
        }, 2000);
    }
}
