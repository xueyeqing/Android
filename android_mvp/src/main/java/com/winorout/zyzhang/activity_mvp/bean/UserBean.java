package com.winorout.zyzhang.activity_mvp.bean;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/6/18 下午10:29
 */
public class UserBean {

    private String mFirstName;
    private String mLastName;

    public UserBean(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

}
