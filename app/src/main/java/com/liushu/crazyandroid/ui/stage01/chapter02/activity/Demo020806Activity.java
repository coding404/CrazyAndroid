package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo020806Activity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title)
    TextView mTvTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020806;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitle.setText("可垂直和水平滚动的视图");
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
