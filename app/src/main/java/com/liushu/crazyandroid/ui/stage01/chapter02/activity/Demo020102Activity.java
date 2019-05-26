package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.base.BaseMvpActivity;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.ui.stage01.DemoModel;
import com.liushu.crazyandroid.ui.stage01.DemoPresenter;

import butterknife.BindView;

public class Demo020102Activity extends BaseMvpActivity<DemoPresenter, DemoModel> {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.iv_test)
    ImageView mIvTest;
    private int[] images = new int[]{R.drawable.back1,
            R.mipmap.ic_launcher,
            R.drawable.back1};
    private int currentImg = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020102;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("简单图片浏览器");
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mIvTest.setImageResource(images[0]);
        mIvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvTest.setImageResource(images[++currentImg % images.length]);
            }
        });
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initMvpView() {

    }
}
