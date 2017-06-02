package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo020202Activity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.view01)
    TextView mView01;
    @Bind(R.id.view02)
    TextView mView02;
    @Bind(R.id.view03)
    TextView mView03;
    @Bind(R.id.view04)
    TextView mView04;
    @Bind(R.id.view05)
    TextView mView05;
    @Bind(R.id.view06)
    TextView mView06;
    private int currentColor = 0;
    private int[] colors = new int[]{
            R.color.color01,
            R.color.color02,
            R.color.color03,
            R.color.color04,
            R.color.color05,
            R.color.color06
    };
    private int[] ids = new int[]{
            R.id.view01,
            R.id.view02,
            R.id.view03,
            R.id.view04,
            R.id.view05,
            R.id.view06
    };
    private TextView[] mTextViews = new TextView[ids.length];
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                for (int i = 0; i < ids.length; i++) {
                    mTextViews[i].setBackgroundResource(colors[(i + currentColor) % colors.length]);
                }
                currentColor++;
            }
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020202;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("霓虹灯效果");
        for (int i = 0; i < ids.length; i++) {
            mTextViews[i] = (TextView) findViewById(ids[i]);
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(100);
            }
        }, 0, 400);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
