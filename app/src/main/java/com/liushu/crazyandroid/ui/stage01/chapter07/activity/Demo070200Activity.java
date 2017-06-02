package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.AircraftView;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo070200Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.av_test)
    AircraftView mAvTest;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo070200;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("移动游戏背景");
        // 获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        // 获得屏幕的宽度
        float screenWidth = metrics.widthPixels;
        mAvTest.setScreenWidth(screenWidth);
        mAvTest.start();
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
