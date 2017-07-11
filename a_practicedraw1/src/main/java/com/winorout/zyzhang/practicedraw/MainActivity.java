package com.winorout.zyzhang.practicedraw;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.string.title_draw_color, R.layout.practice_color));
        pageModels.add(new PageModel(R.string.title_draw_circle, R.layout.practice_circle));
        pageModels.add(new PageModel(R.string.title_draw_rect, R.layout.practice_rect));
        pageModels.add(new PageModel(R.string.title_draw_point, R.layout.practice_point));
        pageModels.add(new PageModel(R.string.title_draw_oval, R.layout.practice_oval));
        pageModels.add(new PageModel(R.string.title_draw_line, R.layout.practice_line));
        pageModels.add(new PageModel(R.string.title_draw_round_rect, R.layout.practice_round_rect));
        pageModels.add(new PageModel(R.string.title_draw_arc, R.layout.practice_arc));
        pageModels.add(new PageModel(R.string.title_draw_path, R.layout.practice_path));
        pageModels.add(new PageModel(R.string.title_draw_histogram, R.layout.practice_histogram));
        pageModels.add(new PageModel(R.string.title_draw_pie_chart, R.layout.practice_pie_chart));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
    }

    private class PageModel {
        @StringRes
        int titleRes;
        @LayoutRes
        int practiceLayoutRes;

        public PageModel(@StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
