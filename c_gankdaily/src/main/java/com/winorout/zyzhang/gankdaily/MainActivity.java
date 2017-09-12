package com.winorout.zyzhang.gankdaily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orhanobut.logger.Logger;
import com.winorout.zyzhang.gankdaily.mvprx.IGankContract;
import com.winorout.zyzhang.gankdaily.mvprx.entity.GankData;
import com.winorout.zyzhang.gankdaily.mvprx.presenter.GankPresenter;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements IGankContract.IView {

    private IGankContract.IPresenter iPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();

    }

    private void getData() {
        iPresenter = new GankPresenter(this);
        iPresenter.getData(new Date(System.currentTimeMillis()));
    }

    @Override
    public void onSuccess(GankData gank) {
        Logger.d("onSuccess");
    }
}
