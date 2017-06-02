package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo020306Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.tb_test)
    ToggleButton mTbTest;
    @Bind(R.id.switch_test)
    Switch mSwitchTest;
    @Bind(R.id.ll_test)
    LinearLayout mLlTest;
    @Bind(R.id.activity_demo020306)
    LinearLayout mActivityDemo020306;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020306;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("动态控制布局");
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mSwitchTest.setChecked(true);
                    mTbTest.setChecked(true);
                    mLlTest.setOrientation(LinearLayout.VERTICAL);
                } else {
                    mSwitchTest.setChecked(false);
                    mTbTest.setChecked(false);
                    mLlTest.setOrientation(LinearLayout.HORIZONTAL);
                }
            }
        };
        mSwitchTest.setOnCheckedChangeListener(listener);
        mTbTest.setOnCheckedChangeListener(listener);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
