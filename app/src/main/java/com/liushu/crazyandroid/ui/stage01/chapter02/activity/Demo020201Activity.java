package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.Bind;

public class Demo020201Activity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020201;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("丰富的表格布局");
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
