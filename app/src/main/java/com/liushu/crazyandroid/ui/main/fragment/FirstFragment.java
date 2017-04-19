package com.liushu.crazyandroid.ui.main.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.adapter.MyPagerAdapter;
import com.liushu.crazyandroid.ui.stage01.chapter01.fragment.Chapter01Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter02.fragment.Chapter02Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter03.fragment.Chapter03Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter04.fragment.Chapter04Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter05.fragment.Chapter05Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter06.fragment.Chapter06Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter07.fragment.Chapter07Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter08.fragment.Chapter08Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter09.fragment.Chapter09Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter10.fragment.Chapter10Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter11.fragment.Chapter11Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter12.fragment.Chapter12Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter13.fragment.Chapter13Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter14.fragment.Chapter14Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter15.fragment.Chapter15Fragment;
import com.liushu.crazyandroid.ui.stage01.chapter16.fragment.Chapter16Fragment;
import com.liushu.crazyandroid.utils.MyUtils;
import com.liushu.crazyandroid.widget.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by liushu on 2017/1/26.
 */

public class FirstFragment extends Fragment {

    private PagerSlidingTabStrip ta111bs;
    private ViewPager mPager;
    private MyPagerAdapter mPagerAdapter;
    private Drawable oldBackground = null;
    private int currentColor;
    private List<Fragment> mFragments;
    private TabLayout mTabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, null);

        mPager = (ViewPager) view.findViewById(R.id.vp_first);
        mTabLayout= (TabLayout) view.findViewById(R.id.tab_layout);
        mFragments = new ArrayList<>();
        mPagerAdapter = new MyPagerAdapter(getChildFragmentManager(), mFragments);
        mPager.setAdapter(mPagerAdapter);
        mPager.setOffscreenPageLimit(8);
        mTabLayout.setupWithViewPager(mPager);
        MyUtils.dynamicSetTabLayoutMode(mTabLayout);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        mPager.setPageMargin(pageMargin);
        mPager.setCurrentItem(0);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initFragments();
        mPagerAdapter.notifyDataSetChanged();

    }

    private void initFragments() {

        Chapter01Fragment chapter01Fragment = new Chapter01Fragment();
        mFragments.add(chapter01Fragment);
        Chapter02Fragment chapter02Fragment = new Chapter02Fragment();
        mFragments.add(chapter02Fragment);
        Chapter03Fragment chapter03Fragment = new Chapter03Fragment();
        mFragments.add(chapter03Fragment);
        Chapter04Fragment chapter04Fragment = new Chapter04Fragment();
        mFragments.add(chapter04Fragment);
        Chapter05Fragment chapter05Fragment = new Chapter05Fragment();
        mFragments.add(chapter05Fragment);
        Chapter06Fragment chapter06Fragment = new Chapter06Fragment();
        mFragments.add(chapter06Fragment);
        Chapter07Fragment chapter07Fragment = new Chapter07Fragment();
        mFragments.add(chapter07Fragment);
        Chapter08Fragment chapter08Fragment = new Chapter08Fragment();
        mFragments.add(chapter08Fragment);
        Chapter09Fragment chapter09Fragment = new Chapter09Fragment();
        mFragments.add(chapter09Fragment);
        Chapter10Fragment chapter10Fragment = new Chapter10Fragment();
        mFragments.add(chapter10Fragment);
        Chapter11Fragment chapter11Fragment = new Chapter11Fragment();
        mFragments.add(chapter11Fragment);
        Chapter12Fragment chapter12Fragment = new Chapter12Fragment();
        mFragments.add(chapter12Fragment);
        Chapter13Fragment chapter13Fragment = new Chapter13Fragment();
        mFragments.add(chapter13Fragment);
        Chapter14Fragment chapter14Fragment = new Chapter14Fragment();
        mFragments.add(chapter14Fragment);
        Chapter15Fragment chapter15Fragment = new Chapter15Fragment();
        mFragments.add(chapter15Fragment);
        Chapter16Fragment chapter16Fragment = new Chapter16Fragment();
        mFragments.add(chapter16Fragment);
    }


}
