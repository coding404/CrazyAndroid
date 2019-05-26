package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo070600Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo070600;
    }


    @Override
    public void initView() {
        mTvTitleName.setText("surfaceView的绘图机制");

    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
