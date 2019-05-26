package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo020507Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.spinner)
    Spinner mSpinner;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020507;
    }


    @Override
    public void initView() {
        mTvTitleName.setText("让用户选择");
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
    }*/
}
