package com.dg.user008.crazyandroid.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by liushu on 2017/4/12.
 */

public class SimplePathView extends View {

    private float phase;
    private PathEffect[] mPathEffects=new PathEffect[7];
    private int[] colors;
    private Paint mPaint;
    private Path mPath;

    public SimplePathView(Context context) {
        super(context);
        initData();
    }

    private void initData() {
        mPaint= new Paint();
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath=new Path();
        mPath.moveTo(0,0);
        for (int i = 0; i < 40; i++) {
            mPath.lineTo(i*20, (float) (Math.random()*60));
        }
        colors=new int[]{Color.BLUE,Color.RED,Color.YELLOW,Color.GREEN,Color.GRAY,Color.BLACK,Color.DKGRAY};


    }

    public SimplePathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        mPathEffects[0]=null;

        mPathEffects[1]=new CornerPathEffect(10);
        mPathEffects[2]=new DiscretePathEffect(3.0f,5.0f);
        mPathEffects[3]=new DashPathEffect(new float[]{20,10,5,10},phase);
        Path path=new Path();
        path.addRect(0,0,8,8, Path.Direction.CCW);
        mPathEffects[4]=new PathDashPathEffect(path,12,phase, PathDashPathEffect.Style.ROTATE);
        mPathEffects[5]= new ComposePathEffect(mPathEffects[2],mPathEffects[4]);
        mPathEffects[6]=new SumPathEffect(mPathEffects[4],mPathEffects[3]);
        canvas.translate(8,8);
        for (int i = 0; i < mPathEffects.length; i++) {

            mPaint.setPathEffect(mPathEffects[i]);
            mPaint.setColor(colors[i]);
            canvas.drawPath(mPath,mPaint);
            canvas.translate(0,60);
        }
        phase++;
        invalidate();
    }
}
