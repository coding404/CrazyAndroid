package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.liushu.crazyandroid.R;

import java.util.Timer;
import java.util.TimerTask;

public class Demo070400Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo070400);

        final ImageView flower = (ImageView)
                findViewById(R.id.flower);
        // 加载第一份动画资源
        final Animation anim = AnimationUtils
                .loadAnimation(this, R.anim.anim);
        // 设置动画结束后保留结束状态
        anim.setFillAfter(true);
        // 加载第二份动画资源
        final Animation reverse = AnimationUtils.loadAnimation(this
                , R.anim.reverse);
        // 设置动画结束后保留结束状态
        reverse.setFillAfter(true);
        Button bn = (Button) findViewById(R.id.bn);
        final Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                if (msg.what == 0x123)
                {
                    flower.startAnimation(reverse);
                }
            }
        };
        bn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                flower.startAnimation(anim);
                // 设置3.5秒后启动第二个动画
                new Timer().schedule(new TimerTask()
                {
                    @Override
                    public void run()
                    {
                        handler.sendEmptyMessage(0x123);
                    }
                }, 3500);
            }
        });

    }
}
