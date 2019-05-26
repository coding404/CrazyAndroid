package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo020902Activity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020902;
    }


    @Override
    public void initView() {
        mTvTitle.setText("dialogfragment的使用方法");
        // TODO: 2018/2/24 dialogFragment未完成
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
