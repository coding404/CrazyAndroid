package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo070101Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo070101;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("path类");
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
