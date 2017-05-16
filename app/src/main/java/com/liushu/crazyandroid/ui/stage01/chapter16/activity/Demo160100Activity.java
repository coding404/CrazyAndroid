package com.liushu.crazyandroid.ui.stage01.chapter16.activity;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.liushu.crazyandroid.R;

import java.util.List;

public class Demo160100Activity extends AppCompatActivity {

    ListView providers;
    LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo160100);
        providers = (ListView) findViewById(R.id.providers);
        // 获取系统的LocationManager对象
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // 获取系统所有的LocationProvider的名称
        List<String> providerNames = lm.getAllProviders();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                providerNames);
        // 使用ListView来显示所有可用的LocationProvider
        providers.setAdapter(adapter);
    }
}
