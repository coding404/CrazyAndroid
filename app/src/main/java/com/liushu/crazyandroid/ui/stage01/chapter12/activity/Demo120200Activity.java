package com.liushu.crazyandroid.ui.stage01.chapter12.activity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.MyRenderer;

public class Demo120200Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo120200);
        GLSurfaceView surfaceView= (GLSurfaceView) findViewById(R.id.gl_view);
        MyRenderer myRender = new MyRenderer();
        // 为GLSurfaceView设置绘制器
        surfaceView.setRenderer(myRender);
    }
}
