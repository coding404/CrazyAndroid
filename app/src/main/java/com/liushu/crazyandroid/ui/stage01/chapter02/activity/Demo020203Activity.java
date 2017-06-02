package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo020203Activity extends BaseActivity {


    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.image01)
    ImageView mImage01;
    @Bind(R.id.image02)
    ImageView mImage02;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020203;
    }

    @Override
    public void initPresenter() {

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
