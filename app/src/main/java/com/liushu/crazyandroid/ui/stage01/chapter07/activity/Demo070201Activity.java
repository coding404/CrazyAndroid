package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.MeshView;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo070201Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.mv_test)
    MeshView mMvTest;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo070201;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("可揉动的图片");
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
