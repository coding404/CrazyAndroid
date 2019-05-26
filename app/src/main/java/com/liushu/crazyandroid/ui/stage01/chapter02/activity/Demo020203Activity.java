package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;


import butterknife.BindView;
import butterknife.OnClick;

public class Demo020203Activity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.image01)
    ImageView mImage01;
    @BindView(R.id.image02)
    ImageView mImage02;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020203;
    }


    @Override
    public void initView() {
        mTvTitleName.setText("梅花布局效果");
    }


    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
