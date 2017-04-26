package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.PinBallView;

public class Demo070103Activity extends AppCompatActivity {

private PinBallView mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo070103);
        mView= (PinBallView) findViewById(R.id.pbv_test);
        // 获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        // 获得屏幕宽和高
        mView.setTableWidth(metrics.widthPixels);
        mView.setTableHeight(metrics.heightPixels);
        mView.start();
    }
}
