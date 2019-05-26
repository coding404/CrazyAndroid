package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Demo020305Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.rb_male)
    RadioButton mRbMale;
    @BindView(R.id.rb_female)
    RadioButton mRbFemale;
    @BindView(R.id.rg)
    RadioGroup mRg;
    @BindView(R.id.tv_content)
    TextView mTvContent;


    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020305;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("利用单选框，复选框获取用户信息");
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                String string = checkedId == R.id.rb_female ? "你是女生" : "你是男生";
                mTvContent.setText(string);
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }

}
