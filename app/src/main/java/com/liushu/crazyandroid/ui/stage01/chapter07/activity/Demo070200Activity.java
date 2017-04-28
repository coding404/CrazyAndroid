package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.AircraftView;

public class Demo070200Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo070200);
        // 获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        // 获得屏幕的宽度
        float screenWidth = metrics.widthPixels;
        AircraftView view= (AircraftView) findViewById(R.id.av_test);
        view.setScreenWidth(screenWidth);
        view.start();
    }
}
