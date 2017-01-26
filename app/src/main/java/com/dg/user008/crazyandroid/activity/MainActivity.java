package com.dg.user008.crazyandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.dg.user008.crazyandroid.R;
import com.dg.user008.crazyandroid.fragment.FirstFragment;
import com.dg.user008.crazyandroid.fragment.FourFragment;
import com.dg.user008.crazyandroid.fragment.SecondFragment;
import com.dg.user008.crazyandroid.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{
    private List<Fragment> fragments;
    private int selected;
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager= (ViewPager) findViewById(R.id.main_viewpager);
        mRadioGroup= (RadioGroup) findViewById(R.id.main_rg);
        initFragment();
    }


    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFragment());
        fragments.add(new FourFragment());
        mViewPager.setAdapter(pagerAdapter);
        mRadioGroup.setOnCheckedChangeListener(this);
        mRadioGroup.check(R.id.main_new_Resource);
    }

    private PagerAdapter pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    };

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        int indexOfChild = group.indexOfChild(group.findViewById(checkedId));
        selected = indexOfChild;
        mViewPager.setCurrentItem(indexOfChild, false);
    }
    private long exitTime = 0;
    @Override
    public void onBackPressed() {
        if (selected == 0) {

            if (System.currentTimeMillis() - exitTime > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                Intent backHome = new Intent(Intent.ACTION_MAIN);
                backHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                backHome.addCategory(Intent.CATEGORY_HOME);
                startActivity(backHome);
            }


        } else {
            mRadioGroup.getChildAt(0).performClick();
        }

    }



}
