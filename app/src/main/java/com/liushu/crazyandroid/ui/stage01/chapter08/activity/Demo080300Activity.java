package com.liushu.crazyandroid.ui.stage01.chapter08.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;
import butterknife.BindView;
import butterknife.OnClick;

public class Demo080300Activity extends BaseActivity implements GestureDetector.OnGestureListener {

    // 定义手势检测器实例
    GestureDetector detector;
    // 初始的图片资源
    Bitmap bitmap;
    // 定义图片的宽、高
    int width, height;
    // 记录当前的缩放比
    float currentScale = 1;
    // 控制图片缩放的Matrix对象
    Matrix matrix;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.show)
    ImageView mShow;

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        // 将该Activity上的触碰事件交给GestureDetector处理
        return detector.onTouchEvent(me);
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY)  // ②
    {
        velocityX = velocityX > 4000 ? 4000 : velocityX;
        velocityX = velocityX < -4000 ? -4000 : velocityX;
        // 根据手势的速度来计算缩放比，如果velocityX>0，放大图像，否则缩小图像
        currentScale += currentScale * velocityX / 4000.0f;
        // 保证currentScale不会等于0
        currentScale = currentScale > 0.01 ? currentScale : 0.01f;
        // 重置Matrix
        matrix.reset();
        // 缩放Matrix
        matrix.setScale(currentScale, currentScale, 160, 200);
        BitmapDrawable tmp = (BitmapDrawable) mShow.getDrawable();
        // 如果图片还未回收，先强制回收该图片
        if (!tmp.getBitmap().isRecycled())  // ①
        {
            tmp.getBitmap().recycle();
        }
        // 根据原始位图和Matrix创建新图片
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0
                , width, height, matrix, true);
        // 显示新的位图
        mShow.setImageBitmap(bitmap2);
        return true;
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent event) {
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent event) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo080300;
    }

    @Override
    public void initView() {
        // 创建手势检测器
        detector = new GestureDetector(this, this);
        matrix = new Matrix();
        // 获取被缩放的源图片
        bitmap = BitmapFactory.decodeResource(
                this.getResources(), R.drawable.flower);
        // 获得位图宽
        width = bitmap.getWidth();
        // 获得位图高
        height = bitmap.getHeight();
        // 设置ImageView初始化时显示的图片。
        mShow.setImageBitmap(BitmapFactory.decodeResource(
                this.getResources(), R.drawable.flower));
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}