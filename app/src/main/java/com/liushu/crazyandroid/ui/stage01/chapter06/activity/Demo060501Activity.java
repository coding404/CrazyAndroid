package com.liushu.crazyandroid.ui.stage01.chapter06.activity;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;
import butterknife.BindView;
import butterknife.OnClick;

public class Demo060501Activity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.ll_test)
    LinearLayout mLlTest;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo060501;
    }

    @Override
    public void initView() {
        mTvTitle.setText("不断渐变的背景色");
        mLlTest.addView(new MyAnimalView(getMContext()));
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    public class MyAnimalView extends View {

        public MyAnimalView(Context context) {
            super(context);
            ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.color_animal_demo060501);
            animator.setTarget(this);
            animator.start();
        }

        public MyAnimalView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }
    }
}
