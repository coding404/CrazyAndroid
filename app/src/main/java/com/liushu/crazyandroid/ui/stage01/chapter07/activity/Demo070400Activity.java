package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo070400Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.bn)
    Button mBn;
    @Bind(R.id.flower)
    ImageView mFlower;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                mFlower.startAnimation(reverse);
            }
        }
    };
    // 加载第一份动画资源
    private Animation anim;

    // 加载第二份动画资源
    private Animation reverse;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo070400;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("位置、大小、旋转度、透明度改变的补间动画");
        anim = AnimationUtils.loadAnimation(this, R.anim.anim);
        reverse = AnimationUtils.loadAnimation(this, R.anim.reverse);
        anim.setFillAfter(true);
        reverse.setFillAfter(true);

    }

    @OnClick({R.id.iv_back, R.id.bn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.bn:
                mFlower.startAnimation(anim);
                // 设置3.5秒后启动第二个动画
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0x123);
                    }
                }, 3500);
                break;
        }
    }
}
