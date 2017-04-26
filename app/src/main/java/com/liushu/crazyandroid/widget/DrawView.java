package com.liushu.crazyandroid.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by liushu on 2017/2/6.
 */

public class DrawView extends View {

    private float currentX=40;
    private float currentY=50;

    Paint mPaint=new Paint();

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(currentX,currentY,15,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        currentX=event.getX();
        currentY=event.getY();
        invalidate();
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        Log.e("22222222","2222222222");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
