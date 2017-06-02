package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo020302Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020302;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("圆角边框、渐变背景的textview");
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
