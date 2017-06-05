package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.OnClick;

import static com.liushu.crazyandroid.R.id.cos;
import static com.liushu.crazyandroid.R.id.sin;

public class Demo070601Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(sin)
    Button mSin;
    @Bind(cos)
    Button mCos;
    @Bind(R.id.show)
    SurfaceView mShow;
    private SurfaceHolder holder;
    private Paint paint;
    final int HEIGHT = 320;
    final int WIDTH = 768;
    final int X_OFFSET = 5;
    private int cx = X_OFFSET;
    // 实际的Y轴的位置
    int centerY = HEIGHT / 2;
    Timer timer = new Timer();
    TimerTask task = null;

    private void drawBack(SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas();
        // 绘制白色背景
        canvas.drawColor(Color.WHITE);
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setStrokeWidth(2);
        // 绘制坐标轴
        canvas.drawLine(X_OFFSET, centerY, WIDTH, centerY, p);
        canvas.drawLine(X_OFFSET, 40, X_OFFSET, HEIGHT, p);
        holder.unlockCanvasAndPost(canvas);
        holder.lockCanvas(new Rect(0, 0, 0, 0));
        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo070601;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("基于SurfaceView开发示波器");
        // 初始化SurfaceHolder对象
        holder = mShow.getHolder();
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        View.OnClickListener listener = (new View.OnClickListener() {
            @Override
            public void onClick(final View source) {
                drawBack(holder);
                cx = X_OFFSET;
                if (task != null) {
                    task.cancel();
                }
                task = new TimerTask() {
                    public void run() {
                        int cy = source.getId() == sin ? centerY
                                - (int) (100 * Math.sin((cx - 5) * 2
                                * Math.PI / 150))
                                : centerY - (int) (100 * Math.cos((cx - 5)
                                * 2 * Math.PI / 150));
                        Canvas canvas = holder.lockCanvas(new Rect(cx,
                                cy - 2, cx + 2, cy + 2));
                        canvas.drawPoint(cx, cy, paint);
                        cx++;
                        if (cx > WIDTH) {
                            task.cancel();
                            task = null;
                        }
                        holder.unlockCanvasAndPost(canvas);
                    }
                };
                timer.schedule(task, 0, 30);
            }
        });
        mSin.setOnClickListener(listener);
        mCos.setOnClickListener(listener);
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                drawBack(holder);
            }

            @Override
            public void surfaceCreated(final SurfaceHolder myHolder) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                timer.cancel();
            }
        });

    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
