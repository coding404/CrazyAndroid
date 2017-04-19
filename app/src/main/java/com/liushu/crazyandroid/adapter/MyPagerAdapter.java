package com.liushu.crazyandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by liushu on 2017/2/3.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList;

    private final String[] TITLES = {"第一章", "第二章", "第三章", "第四章", "第五章", "第六章",
            "第七章", "第八章","第九章","第十章","第十一章","第十二章","第十三章","第十四章","第十五章","第十六章"};



    public  MyPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        mList=fragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }
}
