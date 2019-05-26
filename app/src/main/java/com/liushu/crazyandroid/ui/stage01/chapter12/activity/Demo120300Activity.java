package com.liushu.crazyandroid.ui.stage01.chapter12.activity;

import android.opengl.GLSurfaceView;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.MyRenderer3D;
import butterknife.BindView;
import butterknife.OnClick;

public class Demo120300Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.gl_view)
    GLSurfaceView mGlView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo120300;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("构建3D图形");
        MyRenderer3D myRender = new MyRenderer3D();
        // 为GLSurfaceView设置绘制器
        mGlView.setRenderer(myRender);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
