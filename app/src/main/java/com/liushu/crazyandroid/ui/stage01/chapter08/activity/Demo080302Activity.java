package com.liushu.crazyandroid.ui.stage01.chapter08.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo080302Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.gesture)
    GestureOverlayView mGesture;
    @Bind(R.id.gesture_test)
    GestureOverlayView mGestureTest;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo080302;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("添加手势");

        // 设置手势的绘制颜色
        mGestureTest.setGestureColor(Color.RED);
        // 设置手势的绘制宽度
        mGestureTest.setGestureStrokeWidth(4);
        // 为gesture的手势完成事件绑定事件监听器
        mGestureTest.addOnGesturePerformedListener(
                new GestureOverlayView.OnGesturePerformedListener() {
                    @Override
                    public void onGesturePerformed(GestureOverlayView overlay,
                                                   final Gesture gesture) {
                        // 加载save.xml界面布局代表的视图
                        View saveDialog = getLayoutInflater().inflate(R.layout.save, null);
                        // 获取saveDialog里的show组件
                        ImageView imageView = (ImageView) saveDialog.findViewById(R.id.show);
                        // 获取saveDialog里的gesture_name组件
                        final EditText gestureName = (EditText) saveDialog.findViewById(R.id.gesture_name);
                        // 根据Gesture包含的手势创建一个位图
                        Bitmap bitmap = gesture.toBitmap(128, 128, 10, 0xffff0000);
                        imageView.setImageBitmap(bitmap);
                        // 使用对话框显示saveDialog组件
                        new AlertDialog.Builder(Demo080302Activity.this)
                                .setView(saveDialog)
                                .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // 获取指定文件对应的手势库
                                        GestureLibrary gestureLib = GestureLibraries.fromFile("/mnt/sdcard/mygestures");
                                        // 添加手势
                                        gestureLib.addGesture(gestureName.getText().toString(), gesture);
                                        // 保存手势库
                                        gestureLib.save();
                                    }
                                }).setNegativeButton("取消", null).show();
                    }
                });
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}

