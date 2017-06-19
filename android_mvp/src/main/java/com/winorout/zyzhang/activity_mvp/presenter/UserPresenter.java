package com.winorout.zyzhang.activity_mvp.presenter;

import android.util.Log;

import com.winorout.zyzhang.activity_mvp.IuserView;
import com.winorout.zyzhang.activity_mvp.bean.UserBean;
import com.winorout.zyzhang.activity_mvp.model.IuserModel;
import com.winorout.zyzhang.activity_mvp.model.UserModel;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/6/18 下午10:50
 */
public class UserPresenter {

    private IuserView mUserView;
    private IuserModel iuserModel;

    public UserPresenter(IuserView iuserView) {
        mUserView = iuserView;
        iuserModel = new UserModel();
    }

    public void saveUser(int id, String firstName, String lastName) {
        iuserModel.setID(id);
        iuserModel.setFirstName(firstName);
        iuserModel.setLastName(lastName);
    }

    public void loadUser(int id) {
        UserBean user = iuserModel.load(id);
        mUserView.setFirstName(user.getmFirstName());//通过调用IUserView的方法来更新显示
        mUserView.setLastName(user.getmLastName());
    }

}
