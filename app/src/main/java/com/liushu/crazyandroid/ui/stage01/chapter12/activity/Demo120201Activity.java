package com.liushu.crazyandroid.ui.stage01.chapter12.activity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.MyRendererRoate;

public class Demo120201Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo120201);
        GLSurfaceView surfaceView= (GLSurfaceView) findViewById(R.id.gl_view);
        MyRendererRoate myRender = new MyRendererRoate();
        // 为GLSurfaceView设置绘制器
        surfaceView.setRenderer(myRender);
    }
}
