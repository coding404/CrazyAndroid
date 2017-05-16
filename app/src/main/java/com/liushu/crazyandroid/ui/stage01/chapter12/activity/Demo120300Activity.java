package com.liushu.crazyandroid.ui.stage01.chapter12.activity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.MyRenderer3D;

public class Demo120300Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo120300);
        GLSurfaceView surfaceView= (GLSurfaceView) findViewById(R.id.gl_view);
        MyRenderer3D myRender = new MyRenderer3D();
        // 为GLSurfaceView设置绘制器
        surfaceView.setRenderer(myRender);
    }
}
