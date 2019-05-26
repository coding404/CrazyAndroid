package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo020307Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.chronometer_test)
    Chronometer mChronometerTest;
    @BindView(R.id.btn_test)
    Button mBtnTest;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020307;
    }


    @Override
    public void initView() {
        mTvTitleName.setText("手机里的“劳力士”");
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChronometerTest.setBase(SystemClock.elapsedRealtime());
                mChronometerTest.start();
                mBtnTest.setClickable(false);
            }
        });
        mChronometerTest.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - chronometer.getBase() > 20 * 1000) {
                    mChronometerTest.stop();
                    mBtnTest.setClickable(true);
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
