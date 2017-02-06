package com.dg.user008.crazyandroid.fragment;

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

import com.dg.user008.crazyandroid.R;
import com.dg.user008.crazyandroid.adapter.MyPagerAdapter;
import com.dg.user008.crazyandroid.utils.MyUtils;
import com.dg.user008.crazyandroid.widget.PagerSlidingTabStrip;

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
