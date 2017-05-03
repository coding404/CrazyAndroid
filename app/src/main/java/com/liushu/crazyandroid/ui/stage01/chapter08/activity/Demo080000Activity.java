package com.liushu.crazyandroid.ui.stage01.chapter08.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.liushu.crazyandroid.R;

public class Demo080000Activity extends AppCompatActivity {

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo080000);
        preferences = getSharedPreferences("count", MODE_PRIVATE);
        // 读取SharedPreferences里的count数据
        int count = preferences.getInt("count", 0);
        // 显示程序以前使用的次数
        Toast.makeText(this, "程序以前被使用了" + count + "次。", Toast.LENGTH_LONG).show();
        SharedPreferences.Editor editor = preferences.edit();
        // 存入数据
        editor.putInt("count", ++count);
        // 提交修改
        editor.commit();
    }
}
