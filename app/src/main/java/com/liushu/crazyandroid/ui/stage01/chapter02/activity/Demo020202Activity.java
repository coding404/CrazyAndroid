package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.liushu.crazyandroid.R;

import java.util.Timer;
import java.util.TimerTask;

public class Demo020202Activity extends AppCompatActivity {

    private int currentColor=0;
    private int[] colors=new int[]{
            R.color.color01,
            R.color.color02,
            R.color.color03,
            R.color.color04,
            R.color.color05,
            R.color.color06
    };
    private int[] ids=new int[]{
            R.id.view01,
            R.id.view02,
            R.id.view03,
            R.id.view04,
            R.id.view05,
            R.id.view06
    };
    private TextView[] mTextViews=new TextView[ids.length];
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==100){
                for (int i = 0; i < ids.length; i++) {
                    mTextViews[i].setBackgroundResource(colors[(i+currentColor)%colors.length]);
                }
                currentColor++;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020202);
        for (int i = 0; i < ids.length; i++) {
            mTextViews[i]= (TextView) findViewById(ids[i]);
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
               mHandler.sendEmptyMessage(100);
            }
        },0,400);



    }
}
