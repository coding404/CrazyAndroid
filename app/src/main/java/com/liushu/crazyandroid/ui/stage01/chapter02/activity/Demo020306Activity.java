package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo020306Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.tb_test)
    ToggleButton mTbTest;
    @BindView(R.id.switch_test)
    Switch mSwitchTest;
    @BindView(R.id.ll_test)
    LinearLayout mLlTest;
    @BindView(R.id.activity_demo020306)
    LinearLayout mActivityDemo020306;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020306;
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
