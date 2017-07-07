package com.winorout.zyzhang.activity.android_stickydecoration.util;

import com.winorout.zyzhang.activity.android_stickydecoration.module.City;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/7/5 下午10:32
 */
public class CityUtil {

    /**
     * 获取城市名
     *
     * @return
     */
    public static List<City> getCityList() {
        List<City> dataList = new ArrayList<>();
        final String FU_JIAN = "福建省";
        dataList.add(new City("福州", FU_JIAN));
        dataList.add(new City("厦门", FU_JIAN));
        dataList.add(new City("泉州", FU_JIAN));
        dataList.add(new City("宁德", FU_JIAN));
        dataList.add(new City("漳州", FU_JIAN));
        final String AN_HUI = "安徽省";
        dataList.add(new City("合肥", AN_HUI));
        dataList.add(new City("芜湖", AN_HUI));
        dataList.add(new City("蚌埠", AN_HUI));
        dataList.add(new City("安庆", AN_HUI));
        dataList.add(new City("巢湖", AN_HUI));
        dataList.add(new City("阜阳", AN_HUI));
        dataList.add(new City("六安", AN_HUI));
        dataList.add(new City("亳州", AN_HUI));
        dataList.add(new City("池州", AN_HUI));
        final String ZHE_JIANG = "浙江省";
        dataList.add(new City("杭州", ZHE_JIANG));
        dataList.add(new City("宁波", ZHE_JIANG));
        dataList.add(new City("温州", ZHE_JIANG));
        dataList.add(new City("嘉兴", ZHE_JIANG));
        dataList.add(new City("绍兴", ZHE_JIANG));
        dataList.add(new City("金华", ZHE_JIANG));
        dataList.add(new City("湖州", ZHE_JIANG));
        dataList.add(new City("舟山", ZHE_JIANG));
        final String JIANG_SU = "江苏省";
        dataList.add(new City("南京", JIANG_SU));
        dataList.add(new City("苏州", JIANG_SU));
        dataList.add(new City("徐州", JIANG_SU));
        dataList.add(new City("南通", JIANG_SU));
        dataList.add(new City("无锡", JIANG_SU));
        dataList.add(new City("盐城", JIANG_SU));
        dataList.add(new City("淮安", JIANG_SU));
        dataList.add(new City("泰州", JIANG_SU));
        dataList.add(new City("常州", JIANG_SU));
        dataList.add(new City("连云港", JIANG_SU));
        return dataList;
    }
}
