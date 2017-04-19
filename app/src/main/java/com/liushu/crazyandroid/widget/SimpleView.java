package com.liushu.crazyandroid.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by liushu on 2017/4/12.
 */

public class SimpleView extends View {
    public SimpleView(Context context) {
        super(context);
    }

    public SimpleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置画笔的颜色
        paint.setColor(Color.BLUE);
        //设置画笔的粗细
        paint.setStrokeWidth(3);
        //设置画笔的样式
        paint.setStyle(Paint.Style.STROKE);
        int viewWidth = this.getWidth();
        //画圆
        canvas.drawCircle(viewWidth / 10 + 10, viewWidth / 10 + 10, viewWidth / 10, paint);
        //画正方形
        canvas.drawRect(10, viewWidth / 5 + 20, viewWidth / 5 + 10, viewWidth * 2 / 5, paint);
        //画长方形
        canvas.drawRect(10, viewWidth * 2 / 5 + 10, viewWidth / 5 + 10, viewWidth * 1 / 2, paint);
        //画圆角矩形
        RectF rectF = new RectF(10, viewWidth * 1 / 2 + 10, viewWidth / 5 + 10, viewWidth * 3 / 5);
        canvas.drawRoundRect(rectF, 15, 15, paint);
        //画椭圆
        RectF rectF1 = new RectF(10, viewWidth * 3 / 5 + 10, viewWidth / 5 + 10, viewWidth * 7 / 10);
        canvas.drawOval(rectF1, paint);
        //画三角形
        Path path = new Path();
        path.moveTo(viewWidth / 10 + 10, viewWidth * 7 / 10 + 10);
        path.lineTo(viewWidth / 5 + 10, viewWidth * 9 / 10);
        path.lineTo(10, viewWidth * 9 / 10);
        path.close();
        canvas.drawPath(path, paint);
        //画五角形
        Path path1 = new Path();
        path1.moveTo(viewWidth / 10 + 10, viewWidth * 9 / 10 + 10);
        path1.lineTo( viewWidth / 5 + 10,viewWidth);
        path1.lineTo(viewWidth *2/13+10,viewWidth*12/11);
        path1.lineTo(viewWidth *1/15,viewWidth*12/11);
        path1.lineTo(10,viewWidth);
        path1.close();
        canvas.drawPath(path1,paint);
        //------------------------更换风格-------------------------------------------
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        //画圆
        canvas.drawCircle(viewWidth *3/ 10 + 10, viewWidth / 10 + 10, viewWidth / 10, paint);
        //画正方形
        canvas.drawRect(viewWidth / 5+10, viewWidth / 5 + 20, viewWidth *2/ 5 + 10, viewWidth * 2 / 5, paint);
        //画长方形
        canvas.drawRect(viewWidth / 5+10, viewWidth * 2 / 5 + 10, viewWidth*2 / 5 + 10, viewWidth * 1 / 2, paint);
        //画圆角矩形
        RectF rectF3 = new RectF(viewWidth / 5+10, viewWidth * 1 / 2 + 10, viewWidth *2/ 5 + 10, viewWidth * 3 / 5);
        canvas.drawRoundRect(rectF3, 15, 15, paint);
        //画椭圆
        RectF rectF4 = new RectF(viewWidth / 5+10, viewWidth * 3 / 5 + 10, viewWidth *2/ 5 + 10, viewWidth * 7 / 10);
        canvas.drawOval(rectF4, paint);
        //画三角形
        Path path3 = new Path();
        path3.moveTo(viewWidth *3/ 10 + 10, viewWidth * 7 / 10 + 10);
        path3.lineTo(viewWidth *2/ 5 + 10, viewWidth * 9 / 10);
        path3.lineTo(viewWidth / 5 + 10, viewWidth * 9 / 10);
        path3.close();
        canvas.drawPath(path3, paint);
        //画五角形
        Path path4 = new Path();
        path4.moveTo(viewWidth*3 / 10 + 10, viewWidth * 9 / 10 + 10);
        path4.lineTo( viewWidth *2/ 5 + 10,viewWidth);
        path4.lineTo(viewWidth *5/13+10,viewWidth*12/11);
        path4.lineTo(viewWidth *4/15,viewWidth*12/11);
        path4.lineTo(viewWidth / 5 + 10,viewWidth);
        path4.close();
        canvas.drawPath(path4,paint);
        //-----------------------------------------更换风格-----------------------------
        Shader shader=new LinearGradient(0,0,40,60,new int[]{Color.BLUE,Color.GREEN,Color.YELLOW,Color.RED},null, Shader.TileMode.REPEAT);
        paint.setShader(shader);
        paint.setShadowLayer(20,3,4,Color.GRAY);
        //画圆
        canvas.drawCircle(viewWidth *5/ 10 + 10, viewWidth / 10 + 10, viewWidth *1/ 10, paint);
        //画正方形
        canvas.drawRect(viewWidth *2/ 5+10, viewWidth / 5 + 20, viewWidth *3/ 5 + 10, viewWidth * 2 / 5, paint);
        //画长方形
        canvas.drawRect(viewWidth *2/ 5+10, viewWidth * 2 / 5 + 10, viewWidth*3 / 5 + 10, viewWidth * 1 / 2, paint);
        //画圆角矩形
        RectF rectF5 = new RectF(viewWidth *2/ 5+10, viewWidth * 1 / 2 + 10, viewWidth *3/ 5 + 10, viewWidth * 3 / 5);
        canvas.drawRoundRect(rectF5, 15, 15, paint);
        //画椭圆
        RectF rectF6 = new RectF(viewWidth *2/ 5+10, viewWidth * 3 / 5 + 10, viewWidth *3/ 5 + 10, viewWidth * 7 / 10);
        canvas.drawOval(rectF6, paint);
        //画三角形
        Path path5 = new Path();
        path5.moveTo(viewWidth *5/ 10 + 10, viewWidth * 7 / 10 + 10);
        path5.lineTo(viewWidth *3/ 5 + 10, viewWidth * 9 / 10);
        path5.lineTo(viewWidth *2/ 5 + 10, viewWidth * 9 / 10);
        path5.close();
        canvas.drawPath(path5, paint);
        //画五角形
        Path path6 = new Path();
        path6.moveTo(viewWidth*5/ 10 + 10, viewWidth * 9 / 10 + 10);
        path6.lineTo( viewWidth *3/ 5 + 10,viewWidth);
        path6.lineTo(viewWidth *7/13+10,viewWidth*12/11);
        path6.lineTo(viewWidth *7/15,viewWidth*12/11);
        path6.lineTo(viewWidth *2/ 5 + 10,viewWidth);
        path6.close();
        canvas.drawPath(path6,paint);
        //--------------------------------------添加文字-----------------------------
        paint.setTextSize(50);
        paint.setShader(null);
        canvas.drawText("圆形",viewWidth *3/ 5+10, viewWidth *1/ 10+10,paint);
        canvas.drawText("正方形",viewWidth *3/ 5+10, viewWidth *3/ 10+10,paint);
        canvas.drawText("矩形",viewWidth *3/ 5+10, viewWidth * 1 / 2,paint);
        canvas.drawText("圆角矩形",viewWidth *3/ 5+10, viewWidth * 3 / 5,paint);
        canvas.drawText("椭圆",viewWidth *3/ 5+10, viewWidth * 7 / 10,paint);
        canvas.drawText("三角形",viewWidth *3/ 5+10, viewWidth *8/ 10+10,paint);
        canvas.drawText("五角形",viewWidth *3/ 5+10, viewWidth+10,paint);

    }
}
