package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.ShaderView;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo070202Activity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.bn1)
    Button mBn1;
    @Bind(R.id.bn2)
    Button mBn2;
    @Bind(R.id.bn3)
    Button mBn3;
    @Bind(R.id.bn4)
    Button mBn4;
    @Bind(R.id.bn5)
    Button mBn5;
    @Bind(R.id.sv_test)
    ShaderView mSvTest;
    private Shader[] shaders = new Shader[5];
    // 声明颜色数组
    private int[] colors;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo070202;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("使用shader填充图形");
        Bitmap bm = BitmapFactory.decodeResource(getResources()
                , R.drawable.water);
        // 设置渐变的颜色组，也就是按红、绿、蓝的方式渐变
        colors = new int[]{Color.RED, Color.GREEN, Color.BLUE};
        // 实例化BitmapShader，x坐标方向重复图形，y坐标方向镜像图形
        shaders[0] = new BitmapShader(bm, Shader.TileMode.REPEAT,
                Shader.TileMode.MIRROR);
        // 实例化LinearGradient
        shaders[1] = new LinearGradient(0, 0, 100, 100
                , colors, null, Shader.TileMode.REPEAT);
        // 实例化RadialGradient
        shaders[2] = new RadialGradient(100, 100, 80, colors, null,
                Shader.TileMode.REPEAT);
        // 实例化SweepGradient
        shaders[3] = new SweepGradient(160, 160, colors, null);
        // 实例化ComposeShader
        shaders[4] = new ComposeShader(shaders[1], shaders[2],
                PorterDuff.Mode.DARKEN);
    }


    @OnClick({R.id.iv_back, R.id.bn1, R.id.bn2, R.id.bn3, R.id.bn4, R.id.bn5})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.bn1:
                mSvTest.paint.setShader(shaders[0]);
                mSvTest.invalidate();
                break;
            case R.id.bn2:
                mSvTest.paint.setShader(shaders[1]);
                mSvTest.invalidate();
                break;
            case R.id.bn3:
                mSvTest.paint.setShader(shaders[2]);
                mSvTest.invalidate();
                break;
            case R.id.bn4:
                mSvTest.paint.setShader(shaders[3]);
                mSvTest.invalidate();
                break;
            case R.id.bn5:
                mSvTest.paint.setShader(shaders[4]);
                mSvTest.invalidate();
                break;
            default:
                break;
        }
    }
}
