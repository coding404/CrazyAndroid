package com.liushu.crazyandroid.ui.stage01.chapter16.activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.jaydenxiao.common.commonutils.ToastUitl;
import com.liushu.crazyandroid.R;

public class Demo160200Activity extends AppCompatActivity {
    // 定义LocationManager对象
    LocationManager locManager;
    // 定义程序界面中的EditText组件
    EditText show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo160200);
        // 获取程序界面上的EditText组件
        show = (EditText) findViewById(R.id.show);
        // 创建LocationManager对象
        locManager = (LocationManager) getSystemService
                (Context.LOCATION_SERVICE);
        // 从GPS获取最近的最近的定位信息
        Location location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            ToastUitl.showShort("请检查权限");
            return;
        }
        // 使用location来更新EditText的显示
        updateView(location);
        // 设置每3秒获取一次GPS的定位信息
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER
                , 3000, 8, new LocationListener()  // ①
                {
                    @Override
                    public void onLocationChanged(Location location) {
                        // 当GPS定位信息发生改变时，更新位置
                        updateView(location);
                    }

                    @Override
                    public void onProviderDisabled(String provider) {
                        updateView(null);
                    }

                    @Override
                    public void onProviderEnabled(String provider) {
                        // TODO: 2017/5/16 动态检查权限
                        // 当GPS LocationProvider可用时，更新位置
                        //updateView(locManager.getLastKnownLocation(provider));
                    }

                    @Override
                    public void onStatusChanged(String provider, int status,
                                                Bundle extras) {
                    }
                });
    }

    // 更新EditText中显示的内容
    public void updateView(Location newLocation) {
        if (newLocation != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("实时的位置信息：\n");
            sb.append("经度：");
            sb.append(newLocation.getLongitude());
            sb.append("\n纬度：");
            sb.append(newLocation.getLatitude());
            sb.append("\n高度：");
            sb.append(newLocation.getAltitude());
            sb.append("\n速度：");
            sb.append(newLocation.getSpeed());
            sb.append("\n方向：");
            sb.append(newLocation.getBearing());
            show.setText(sb.toString());
        } else {
            // 如果传入的Location对象为空则清空EditText
            show.setText("");
        }
    }
}
