package com.winorout.zyzhang.activity.view.model;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/6/20 上午12:18
 */
public class UserModel {
    private String username;
    private String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int checkUserValidity(String name, String pass) {
        if (name == null || pass == null || name.isEmpty() || pass.isEmpty()) {
            return -1;
        }
        return 0;
    }
}
