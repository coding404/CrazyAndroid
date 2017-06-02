package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo070300Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.play)
    Button mPlay;
    @Bind(R.id.stop)
    Button mStop;
    @Bind(R.id.anim)
    ImageView mAnim;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo070300;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("animationDrawable与逐帧动画");
    }

    @OnClick({R.id.iv_back, R.id.play, R.id.stop})
    public void onClick(View view) {
        final AnimationDrawable anim = (AnimationDrawable) mAnim.getBackground();
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.play:
                anim.start();
                break;
            case R.id.stop:
                anim.stop();
                break;
            default:
                break;
        }
    }
}
