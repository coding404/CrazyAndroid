package com.liushu.crazyandroid.ui.stage01.chapter16.activity;

import android.content.Context;
import android.location.LocationManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static com.liushu.crazyandroid.R.id.providers;

public class Demo160100Activity extends BaseActivity {

    LocationManager lm;
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(providers)
    ListView mProviders;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo160100;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("获取所有可用的LocationProvider");
        // 获取系统的LocationManager对象
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // 获取系统所有的LocationProvider的名称
        List<String> providerNames = lm.getAllProviders();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                providerNames);
        // 使用ListView来显示所有可用的LocationProvider
        mProviders.setAdapter(adapter);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
