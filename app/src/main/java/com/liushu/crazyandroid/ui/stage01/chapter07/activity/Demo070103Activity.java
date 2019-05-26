package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.PinBallView;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo070103Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.pbv_test)
    PinBallView mPbvTest;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo070103;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("弹球游戏");
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        // 获得屏幕宽和高
        mPbvTest.setTableWidth(metrics.widthPixels);
        mPbvTest.setTableHeight(metrics.heightPixels);
        mPbvTest.start();
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
