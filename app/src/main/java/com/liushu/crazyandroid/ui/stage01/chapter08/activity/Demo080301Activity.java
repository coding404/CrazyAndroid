package com.liushu.crazyandroid.ui.stage01.chapter08.activity;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo080301Activity extends BaseActivity implements GestureDetector.OnGestureListener {

    // 定义手势检测器实例
    GestureDetector detector;
    // 定义一个动画数组，用于为ViewFlipper指定切换动画效果
    Animation[] animations = new Animation[4];
    // 定义手势动作两点之间的最小距离
    final int FLIP_DISTANCE = 50;
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.flipper)
    ViewFlipper mFlipper;

    // 定义添加ImageView的工具方法
    private View addImageView(int resId) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(resId);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        return imageView;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
        // 如果第一个触点事件的X坐标大于第二个触点事件的X坐标超过FLIP_DISTANCE
        // 也就是手势从右向左滑
        if (event1.getX() - event2.getX() > FLIP_DISTANCE) {
            // 为flipper设置切换的的动画效果
            mFlipper.setInAnimation(animations[0]);
            mFlipper.setOutAnimation(animations[1]);
            mFlipper.showPrevious();
            return true;
        }
        // 如果第二个触点事件的X坐标大于第一个触点事件的X坐标超过FLIP_DISTANCE
        // 也就是手势从右向左滑
        else if (event2.getX() - event1.getX() > FLIP_DISTANCE) {
            // 为flipper设置切换的动画效果
            mFlipper.setInAnimation(animations[2]);
            mFlipper.setOutAnimation(animations[3]);
            mFlipper.showNext();
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 将该Activity上的触碰事件交给GestureDetector处理
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent event) {
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float arg2, float arg3) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent event) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo080301;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("");
        // 创建手势检测器
        detector = new GestureDetector(this, this);
        // 获得ViewFlipper实例
        // 为ViewFlipper添加5个ImageView组件
        mFlipper.addView(addImageView(R.drawable.java));
        mFlipper.addView(addImageView(R.drawable.javaee));
        mFlipper.addView(addImageView(R.drawable.ajax));
        mFlipper.addView(addImageView(R.drawable.android));
        mFlipper.addView(addImageView(R.drawable.html));
        mFlipper.addView(addImageView(R.drawable.swift));
        // 初始化Animation数组
        animations[0] = AnimationUtils.loadAnimation(
                this, R.anim.left_in);
        animations[1] = AnimationUtils.loadAnimation(
                this, R.anim.left_out);
        animations[2] = AnimationUtils.loadAnimation(
                this, R.anim.right_in);
        animations[3] = AnimationUtils.loadAnimation(
                this, R.anim.right_out);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}