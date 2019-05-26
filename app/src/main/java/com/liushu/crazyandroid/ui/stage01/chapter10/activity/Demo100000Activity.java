package com.liushu.crazyandroid.ui.stage01.chapter10.activity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.BindService;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo100000Activity extends BaseActivity {
    Button bind, unbind, getServiceStatus;
    // 保持所启动的Service的IBinder对象
    BindService.MyBinder binder;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.bind)
    Button mBind;
    @BindView(R.id.unbind)
    Button mUnbind;
    @BindView(R.id.getServiceStatus)
    Button mGetServiceStatus;
    // 定义一个ServiceConnection对象
    private ServiceConnection conn = new ServiceConnection() {
        // 当该Activity与Service连接成功时回调该方法
        @Override
        public void onServiceConnected(ComponentName name
                , IBinder service) {
            System.out.println("--Service Connected--");
            // 获取Service的onBind方法所返回的MyBinder对象
            binder = (BindService.MyBinder) service;  // ①
        }

        // 当该Activity与Service断开连接时回调该方法
        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("--Service Disconnected--");
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo100000;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("绑定本地service并与之通信");
    }

    @OnClick({R.id.iv_back, R.id.bind, R.id.unbind, R.id.getServiceStatus})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.iv_back:
                finish();
                break;
            case R.id.bind:
                // 绑定指定Service
                Intent intent = new Intent(this, BindService.class);
                bindService(intent, conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                // 解除绑定Service
                unbindService(conn);
                break;
            case R.id.getServiceStatus:
                // 获取、并显示Service的count值
                Toast.makeText(Demo100000Activity.this,
                        "Service的count值为：" + binder.getCount(),
                        Toast.LENGTH_SHORT).show();  // ②
                break;
        }
    }
}