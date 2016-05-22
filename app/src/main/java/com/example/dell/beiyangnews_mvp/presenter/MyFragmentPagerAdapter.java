package com.example.dell.beiyangnews_mvp.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dell.beiyangnews_mvp.view.PageFragment;

/**
 * Created by dell on 2016/5/22.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PageCount = 5;
    private String tabTitles[] = new String[]{"天大要闻","校园公告","社团风采","院系动态","视点观察"};
    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position+1);
    }

    @Override
    public int getCount() {
        return PageCount;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
