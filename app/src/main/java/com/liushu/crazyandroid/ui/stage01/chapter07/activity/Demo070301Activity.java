package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.lang.reflect.Field;

public class Demo070301Activity extends BaseActivity {

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo070301);
    }*/


    private MyView myView;
    private AnimationDrawable anim;
    private MediaPlayer bomb;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayoutId() {
        return -1;
    }

    @Override
    public View getLayoutView() {

        // 使用FrameLayout布局管理器，它允许组件自己控制位置
        FrameLayout frame = new FrameLayout(this);
        setContentView(frame);
        // 设置使用背景
        frame.setBackgroundResource(R.drawable.back);
        // 加载音效
        bomb = MediaPlayer.create(this, R.raw.bomb);
        myView = new MyView(this);
        // 设置myView用于显示blast动画
        myView.setBackgroundResource(R.drawable.blast);
        // 设置myView默认为隐藏
        myView.setVisibility(View.INVISIBLE);
        // 获取动画对象
        anim = (AnimationDrawable) myView.getBackground();
        frame.addView(myView);
        frame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View source, MotionEvent event) {
                // 只处理按下事件（避免每次产生两个动画效果）
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // 先停止动画播放
                    anim.stop();
                    float x = event.getX();
                    float y = event.getY();
                    // 控制myView的显示位置
                    myView.setLocation((int) y - 40, (int) x - 20);
                    myView.setVisibility(View.VISIBLE);
                    // 启动动画
                    anim.start();
                    // 播放音效
                    bomb.start();
                }
                return false;
            }
        });
        return frame;
    }

    @Override
    public void initView() {

    }

    // 定义一个自定义View，该自定义View用于播放“爆炸”效果
    class MyView extends android.support.v7.widget.AppCompatImageView {
        public MyView(Context context) {
            super(context);
        }

        // 定义一个方法，该方法用于控制MyView的显示位置
        public void setLocation(int top, int left) {
            this.setFrame(left, top, left + 40, top + 40);
        }

        // 重写该方法，控制如果动画播放到最后一帧时，隐藏该View
        @Override
        protected void onDraw(Canvas canvas) // ①
        {
            try {
                Field field = AnimationDrawable.class
                        .getDeclaredField("mCurFrame");
                field.setAccessible(true);
                // 获取anim动画的当前帧
                int curFrame = field.getInt(anim);
                // 如果已经到了最后一帧
                if (curFrame == anim.getNumberOfFrames() - 1) {
                    // 让该View隐藏
                    setVisibility(View.INVISIBLE);
                }
            } catch (Exception e) {
            }
            super.onDraw(canvas);
        }
    }
}
