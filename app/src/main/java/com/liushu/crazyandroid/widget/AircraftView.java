package com.liushu.crazyandroid.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.liushu.crazyandroid.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by liushu on 2017/4/27.
 */

public class AircraftView extends View {
    // 记录背景位图的实际高度
    final int BACK_HEIGHT = 1700;
    // 背景图片
    private Bitmap back;
    private Bitmap plane;
    // 定义图片的宽度
    final int WIDTH = 640;
    final int HEIGHT = 880;
    private Matrix matrix = new Matrix();
    // 背景图片的开始位置
    private int startY = BACK_HEIGHT - HEIGHT;
    float screenWidth;

    public void setScreenWidth(float screenWidth) {
        this.screenWidth = screenWidth;
    }

    public AircraftView(Context context) {
        super(context);

    }

    public AircraftView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AircraftView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void start() {
        back = BitmapFactory.decodeResource(getResources(),
                R.drawable.back_img);
        // 获取图片的缩放比例
        float scale = screenWidth / WIDTH;
        matrix.setScale(scale, scale);
        plane = BitmapFactory.decodeResource(getResources(),
                R.drawable.plane);
        final Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 0x123) {
                    // 重新开始移动
                    if (startY <= 3) {
                        startY = BACK_HEIGHT - HEIGHT;
                    } else {
                        startY -= 3;
                    }
                }
                invalidate();
            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        }, 0, 100);
    }

    @Override
    public void onDraw(Canvas canvas) {

        // 根据原始位图和缩放Matrix创建新图片
        Bitmap bitmap2 = Bitmap
                .createBitmap(back, 0, startY, WIDTH, HEIGHT, matrix, false); // ①
        // 绘制新位图
        canvas.drawBitmap(bitmap2, 0, 0, null);
        // 绘制飞机
        canvas.drawBitmap(plane, 320, 700, null);
    }

}