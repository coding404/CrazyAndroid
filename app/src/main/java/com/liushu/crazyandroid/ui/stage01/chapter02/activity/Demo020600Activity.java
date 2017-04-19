package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;

import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Demo020600Activity extends AppCompatActivity {

    @Bind(R.id.pb_01)
    ProgressBar mPb01;
    @Bind(R.id.pb_02)
    ProgressBar mPb02;
    @Bind(R.id.ll_progressbardemo01)
    LinearLayout mLlProgressbardemo01;
    @Bind(R.id.iv_lijiang)
    ImageView mIvLijiang;
    @Bind(R.id.seekb_test)
    SeekBar mSeekbTest;
    @Bind(R.id.ll_progressbardemo02)
    LinearLayout mLlProgressbardemo02;
    @Bind(R.id.iv_lijiang02)
    ImageView mIvLijiang02;
    @Bind(R.id.rb_test)
    RatingBar mRbTest;
    @Bind(R.id.ll_progressbardemo03)
    LinearLayout mLlProgressbardemo03;
    private int mGroupPosition;
    private int mChildPosition;
    private int[] mData = new int[100];
    private int status = 0;
    private int hasData = 0;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                mPb01.setProgress(status);
                mPb02.setProgress(status);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        mGroupPosition = intent.getIntExtra("groupPosition", -1);
        mChildPosition = intent.getIntExtra("childPosition", -1);
        setContentView(R.layout.activity_demo020600);
        ButterKnife.bind(this);
        initData(mGroupPosition, mChildPosition);

    }

    private void initData(int groupPosition, int childPosition) {
        switch (childPosition) {
            case 0:
                mLlProgressbardemo01.setVisibility(View.VISIBLE);
                initData0();
                break;
            case 1:
                mLlProgressbardemo02.setVisibility(View.VISIBLE);
                initData1();
                break;
            case 2:
                mLlProgressbardemo03.setVisibility(View.VISIBLE);
                initData2();
                break;
        }
    }

    private void initData2() {
        mRbTest.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mIvLijiang02.setImageAlpha((int) (rating*255/5));
            }
        });

    }

    private void initData1() {
        mSeekbTest.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mIvLijiang.setImageAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private void initData0() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (status < 100) {

                    status = dowork();
                    mHandler.sendEmptyMessage(1);
                }

            }
        }.start();

    }

    private int dowork() {
        mData[hasData++] = (int) (Math.random() * 100);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }

}
