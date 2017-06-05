package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo070401Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.butterfly)
    ImageView mButterfly;
    // 记录蝴蝶ImageView当前的位置
    private float curX = 0;
    private float curY = 30;
    // 记录蝴蝶ImageView下一个位置的坐标
    float nextX = 0;
    float nextY = 0;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                // 横向上一直向右飞
                if (nextX > 320) {
                    curX = nextX = 0;
                } else {
                    nextX += 8;
                }
                // 纵向上可以随机上下
                nextY = curY + (float) (Math.random() * 10 - 5);
                // 设置显示蝴蝶的ImageView发生位移改变
                TranslateAnimation anim = new TranslateAnimation(curX, nextX, curY, nextY);
                curX = nextX;
                curY = nextY;
                anim.setDuration(200);
                // 开始位移动画
                mButterfly.startAnimation(anim); // ①
            }
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo070401;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("蝴蝶飞舞");
    }

    @OnClick({R.id.iv_back, R.id.butterfly})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.butterfly:
                AnimationDrawable butterfly = (AnimationDrawable) mButterfly.getBackground();
                // 开始播放蝴蝶振翅的逐帧动画
                butterfly.start();  // ②
                // 通过定制器控制每0.2秒运行一次TranslateAnimation动画
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0x123);
                    }
                }, 0, 200);
                break;
        }
    }
}
