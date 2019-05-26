package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo020403Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.qcb_test)
    QuickContactBadge mQcbTest;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020403;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("使用QuickContactBadge关联联系人");
        mQcbTest.assignContactFromPhone("18117527783", true);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
