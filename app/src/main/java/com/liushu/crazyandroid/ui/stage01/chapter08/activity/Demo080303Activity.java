package com.liushu.crazyandroid.ui.stage01.chapter08.activity;

import android.app.AlertDialog;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.liushu.crazyandroid.R;

import java.util.ArrayList;

public class Demo080303Activity extends AppCompatActivity {
    // 定义手势编辑组件
    GestureOverlayView gestureView;
    // 记录手机上已有的手势库
    GestureLibrary gestureLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo080303);
        // 读取上一个程序所创建的手势库
        gestureLibrary = GestureLibraries
                .fromFile("/mnt/sdcard/mygestures");
        if (gestureLibrary.load()) {
            Toast.makeText(Demo080303Activity.this, "手势文件装载成功！",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Demo080303Activity.this, "手势文件装载失败！",
                    Toast.LENGTH_SHORT).show();
        }
        // 获取手势编辑组件
        gestureView = (GestureOverlayView) findViewById(R.id.gesture);
        // 为手势编辑组件绑定事件监听器
        gestureView.addOnGesturePerformedListener(
                new GestureOverlayView.OnGesturePerformedListener() {
                    @Override
                    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                        // 识别用户刚刚所绘制的手势
                        ArrayList<Prediction> predictions = gestureLibrary
                                .recognize(gesture);
                        ArrayList<String> result = new ArrayList<String>();
                        // 遍历所有找到的Prediction对象
                        for (Prediction pred : predictions) {
                            // 只有相似度大于2.0的手势才会被输出
                            if (pred.score > 2.0) {
                                result.add("与手势【" + pred.name + "】相似度为"+ pred.score);
                            }
                        }
                        if (result.size() > 0) {
                            ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(Demo080303Activity.this,android.R.layout.simple_dropdown_item_1line, result.toArray());
                            // 使用一个带List的对话框来显示所有匹配的手势
                            new AlertDialog.Builder(Demo080303Activity.this)
                                    .setAdapter(adapter, null)
                                    .setPositiveButton("确定", null).show();
                        } else {
                            Toast.makeText(Demo080303Activity.this, "无法找到能匹配的手势！",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

