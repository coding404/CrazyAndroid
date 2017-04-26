package com.liushu.crazyandroid.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by liushu on 2017/4/26.
 */

public class PinBallView extends View {
    // 桌面的宽度
    private int tableWidth=1080;
    // 桌面的高度
    private int tableHeight=1800;
    // 球拍的垂直位置
    private int racketY;
    // 下面定义球拍的高度和宽度
    private final int RACKET_HEIGHT = 30;
    private final int RACKET_WIDTH = 90;
    // 小球的大小
    private final int BALL_SIZE = 16;
    // 小球纵向的运行速度
    private int ySpeed = 15;
    Random rand = new Random();
    // 返回一个-0.5~0.5的比率，用于控制小球的运行方向
    private double xyRate = rand.nextDouble() - 0.5;
    // 小球横向的运行速度
    private int xSpeed = (int) (ySpeed * xyRate * 2);
    // ballX和ballY代表小球的坐标
    private int ballX = rand.nextInt(200) + 20;
    private int ballY = rand.nextInt(10) + 20;
    // racketX代表球拍的水平位置
    private int racketX = rand.nextInt(200);
    // 游戏是否结束的旗标
    private boolean isLose = false;
    private boolean isStart=false;
    Timer timer = new Timer();
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                invalidate();
            }
        }
    };
    Paint paint = new Paint();

    public PinBallView(Context context) {
        super(context);
        setFocusable(true);
    }
    public PinBallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
    }

    public PinBallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFocusable(true);
    }

    public void setTableWidth(int tableWidth) {
        this.tableWidth = tableWidth;
    }

    public void setTableHeight(int tableHeight) {
        this.tableHeight = tableHeight;
    }

    public void start(){
        racketY = tableHeight - 80;
        isStart=true;
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                // 如果小球碰到左边边框
                if (ballX <= 0 || ballX >= tableWidth - BALL_SIZE) {
                    xSpeed = -xSpeed;
                }
                // 如果小球高度超出了球拍位置，且横向不在球拍范围之内，游戏结束
                if (ballY >= racketY - BALL_SIZE
                        && (ballX < racketX || ballX > racketX
                        + RACKET_WIDTH)) {
                    timer.cancel();
                    // 设置游戏是否结束的旗标为true
                    isLose = true;
                }
                // 如果小球位于球拍之内，且到达球拍位置，小球反弹
                else if (ballY <= 0
                        || (ballY >= racketY - BALL_SIZE
                        && ballX > racketX && ballX <= racketX
                        + RACKET_WIDTH)) {
                    ySpeed = -ySpeed;
                }
                // 小球坐标增加
                ballY += ySpeed;
                ballX += xSpeed;
                // 发送消息，通知系统重绘组件
                handler.sendEmptyMessage(0x123);
            }
        }, 0, 100);
    }

    // 重写View的onDraw方法，实现绘画
    public void onDraw(Canvas canvas) {
        if (isStart){
            paint.setStyle(Paint.Style.FILL);
            // 设置去锯齿
            paint.setAntiAlias(true);
            // 如果游戏已经结束
            if (isLose) {
                paint.setColor(Color.RED);
                paint.setTextSize(40);
                canvas.drawText("游戏已结束", tableWidth / 2 - 100, 200, paint);
            }
            // 如果游戏还未结束
            else {
                // 设置颜色，并绘制小球
                paint.setColor(Color.rgb(255, 0, 0));
                canvas.drawCircle(ballX, ballY, BALL_SIZE, paint);
                // 设置颜色，并绘制球拍
                paint.setColor(Color.rgb(80, 80, 200));
                canvas.drawRect(racketX, racketY, racketX + RACKET_WIDTH,
                        racketY + RACKET_HEIGHT, paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        racketX = (int) event.getX();
        return true;
    }

}
