package com.winorout.zyzhang.androidpractice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.winorout.zyzhang.androidpractice.fragment.fragmentpage.HomeFragment;
import com.winorout.zyzhang.androidpractice.fragment.fragmentpage.LikeFragment;
import com.winorout.zyzhang.androidpractice.fragment.fragmentpage.LocationFragment;
import com.winorout.zyzhang.androidpractice.fragment.fragmentpage.PersonalFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar mBottomNavigationBar;
    private ArrayList<Fragment> fragments;
    private FragmentManager manager;

    private HomeFragment homeFragment;
    private LikeFragment likeFragment;
    private LocationFragment locationFragment;
    private PersonalFragment personalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);

        manager = getSupportFragmentManager();

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.v7, getString(R.string.item_home)).setInactiveIconResource(R.drawable.hom).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ve, getString(R.string.item_location)).setInactiveIconResource(R.drawable.vd).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.like_fill, getString(R.string.item_like)).setInactiveIconResource(R.drawable.like).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.pseson_fill, getString(R.string.item_person)).setInactiveIconResource(R.drawable.person).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.colorPrimary))
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);

        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        HomeFragment mhomeFragment = homeFragment.newInstance(getString(R.string.item_home));
        transaction.replace(R.id.sub_content, mhomeFragment).commit();
    }


    /**
     * Tab的切换
     *
     * @param position
     */
    @Override
    public void onTabSelected(int position) {

        //开启事务
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance(getString(R.string.item_home));
                }
                transaction.replace(R.id.sub_content, homeFragment);
                break;
            case 1:
                if (locationFragment == null) {
                    locationFragment = LocationFragment.newInstance(getString(R.string.item_location));
                }
                transaction.replace(R.id.sub_content, locationFragment);
                break;
            case 2:
                if (likeFragment == null) {
                    likeFragment = LikeFragment.newInstance(getString(R.string.item_like));
                }
                transaction.replace(R.id.sub_content, likeFragment);
                break;
            case 3:
                if (personalFragment == null) {
                    personalFragment = PersonalFragment.newInstance(getString(R.string.item_person));
                }
                transaction.replace(R.id.sub_content, personalFragment);
                break;
            default:
                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance(getString(R.string.item_home));
                }
                transaction.replace(R.id.sub_content, homeFragment);
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

}
