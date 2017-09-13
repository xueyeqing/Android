package com.winorout.zyzhang.gankdaily;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.orhanobut.logger.Logger;
import com.winorout.zyzhang.gankdaily.activity.BaseSwipeRefreshActivity;
import com.winorout.zyzhang.gankdaily.adapter.MainListAdapter;
import com.winorout.zyzhang.gankdaily.mvprx.IGankContract;
import com.winorout.zyzhang.gankdaily.mvprx.entity.GankData;
import com.winorout.zyzhang.gankdaily.mvprx.presenter.GankPresenter;

import java.util.Date;
import java.util.List;

public class MainActivity extends BaseSwipeRefreshActivity implements IGankContract.IView {

    private IGankContract.IPresenter iPresenter;

    private RecyclerView recyclerView;
    private MainListAdapter mainListAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initRecycleView();
        setTitle(getString(R.string.app_name), false);

        getData();

    }

    private void initRecycleView() {

        recyclerView = (RecyclerView) findViewById(R.id.rv_gank);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mainListAdapter = new MainListAdapter(this);
//        mainListAdapter.setIClickItem(this);
        recyclerView.setAdapter(mainListAdapter);
        // TODO
    }

    private void getData() {
        iPresenter = new GankPresenter(this);
        iPresenter.getData(new Date(System.currentTimeMillis()));
    }

    @Override
    public void onSuccess(List<GankData.Result.Gank> listgank) {
        mainListAdapter.updateWithClear(listgank);
    }

}
