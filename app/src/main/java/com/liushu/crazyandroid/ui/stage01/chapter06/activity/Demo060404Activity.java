package com.liushu.crazyandroid.ui.stage01.chapter06.activity;

import android.graphics.drawable.ClipDrawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo060404Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.iv_test)
    ImageView mIvTest;

    private ClipDrawable mDrawable;
    private Handler mHandler;
    private Timer mTimer;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo060404;
    }

    @Override
    public void initView() {
        mTvTitle.setText("徐徐展开的风景");
        mDrawable = (ClipDrawable) mIvTest.getDrawable();
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0) {
                    mDrawable.setLevel(mDrawable.getLevel() + 200);
                }
            }
        };
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 0;
                mHandler.sendMessage(message);
                if (mDrawable.getLevel() > 10000) {
                    mTimer.cancel();
                }
            }
        }, 0, 300);

    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
