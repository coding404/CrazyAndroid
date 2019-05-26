package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo020501Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020501;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("改变分隔条，基于数组的ListView");
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }

}
