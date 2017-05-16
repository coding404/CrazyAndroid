package com.liushu.crazyandroid.ui.stage01.chapter16.activity;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.liushu.crazyandroid.R;

import java.util.List;

public class Demo160101Activity extends AppCompatActivity {
    ListView providers;
    LocationManager lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo160101);
        providers = (ListView) findViewById(R.id.providers);
        // 获取系统的LocationManager对象
        lm = (LocationManager)getSystemService(
                Context.LOCATION_SERVICE);
        // 创建一个LocationProvider的过滤条件
        Criteria cri = new Criteria();
        // 设置要求LocationProvider必须是免费的。
        cri.setCostAllowed(false);
        // 设置要求LocationProvider能提供高度信息
        cri.setAltitudeRequired(true);
        // 设置要求LocationProvider能提供方向信息
        cri.setBearingRequired(true);
        // 获取系统所有复合条件的LocationProvider的名称
        List<String> providerNames = lm.getProviders(cri , false);
        System.out.println(providerNames.size());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                providerNames);
        // 使用ListView来显示所有可用的LocationProvider
        providers.setAdapter(adapter);
    }
}
