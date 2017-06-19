package com.winorout.zyzhang.activity_mvp;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/6/18 下午10:52
 */
public interface IuserView {

    int getID();

    String getFristName();

    String getLastName();

    void setFirstName(String firstName);

    void setLastName(String lastName);

}
