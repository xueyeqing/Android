package com.winorout.zyzhang.activity.android_stickydecoration.module;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/7/5 下午10:31
 */
public class City {

    private String name;    //城市名
    private String province;    //所属省份

    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}
