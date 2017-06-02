package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.Bind;

public class Demo020102Activity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.iv_test)
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
    public void initPresenter() {

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

}
