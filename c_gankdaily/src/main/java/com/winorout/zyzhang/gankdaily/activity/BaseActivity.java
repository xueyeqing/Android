package com.winorout.zyzhang.gankdaily.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.winorout.zyzhang.gankdaily.R;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/9/13 下午3:32
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar mToolbar;

    protected abstract int getLayout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        initToolBar();
    }

    final private void initToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar == null) {
            throw new NullPointerException("please add a Toolbar in your layout.");
        }
        setSupportActionBar(mToolbar);
    }

    public void setTitle(String strTitle, boolean showHome) {
        setTitle(strTitle);
        // 左上角图标是否显示
        getSupportActionBar().setDisplayShowHomeEnabled(showHome);
        // 给左上角图标的左边加上一个返回的图标,false表示无
        getSupportActionBar().setDisplayHomeAsUpEnabled(showHome);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
