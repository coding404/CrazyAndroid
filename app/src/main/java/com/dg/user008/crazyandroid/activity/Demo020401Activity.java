package com.dg.user008.crazyandroid.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dg.user008.crazyandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Demo020401Activity extends AppCompatActivity {

    @Bind(R.id.btn_01)
    Button mBtn01;
    @Bind(R.id.btn_02)
    Button mBtn02;
    @Bind(R.id.btn_03)
    Button mBtn03;
    @Bind(R.id.iv_big)
    ImageView mIvBig;
    @Bind(R.id.iv_small)
    ImageView mIvSmall;

    private int[] mInts = new int[]{
            R.drawable.shuangta,
            R.drawable.lijiang,
            R.drawable.shui,
            R.drawable.qiao
    };
    private int currentInt = 2;
    private int alpha = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020401);
        ButterKnife.bind(this);
        mIvBig.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                BitmapDrawable drawable = (BitmapDrawable) mIvBig.getDrawable();
                Bitmap bitmap = drawable.getBitmap();

                double scale = 1.0 * bitmap.getHeight() / mIvBig.getHeight();
                int x = (int) (event.getX() * scale);
                int y = (int) (event.getY() * scale);
                Log.e("x", x + "");
                Log.e("y", y + "");
                if (x <= 0) {
                    x = 0;
                }
                if (y <= 0) {
                    y = 0;
                }

                if (x + 160 > bitmap.getWidth()) {
                    x = bitmap.getWidth() - 160;
                }
                if (y + 160 > bitmap.getHeight()) {
                    y = bitmap.getHeight() - 160;
                }
                mIvSmall.setImageBitmap(Bitmap.createBitmap(bitmap, x, y, 160, 160));
                mIvSmall.setImageAlpha(alpha);
                return true;
            }
        });


    }

    @OnClick({R.id.btn_01, R.id.btn_02, R.id.btn_03})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_01:
                alpha += 20;
                if (alpha >= 255) {
                    alpha = 255;
                }
                mIvBig.setImageAlpha(alpha);
                break;
            case R.id.btn_02:
                alpha -= 20;
                if (alpha <= 0) {
                    alpha = 0;
                }
                mIvBig.setImageAlpha(alpha);
                break;
            case R.id.btn_03:
                currentInt += 1;
                mIvBig.setImageResource(mInts[currentInt % mInts.length]);
                break;
        }
    }
}
