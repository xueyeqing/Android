package com.winorout.zyzhang.activity_mvp.model;

import com.winorout.zyzhang.activity_mvp.bean.UserBean;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/6/18 下午11:14
 */
public interface IuserModel {

    void setID (int id);
    void setFirstName (String firstName);
    void setLastName (String lastName);
    UserBean load (int id);//通过id读取user信息,返回一个UserBean
}
