package com.liushu.crazyandroid.ui.stage01.chapter06.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo060401Activity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo060401;
    }

    @Override
    public void initView() {
        mTvTitle.setText("高亮显示正在输入的文本框");
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
