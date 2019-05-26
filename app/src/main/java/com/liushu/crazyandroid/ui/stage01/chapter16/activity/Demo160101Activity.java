package com.liushu.crazyandroid.ui.stage01.chapter16.activity;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

import static com.liushu.crazyandroid.R.id.providers;

public class Demo160101Activity extends BaseActivity {
    LocationManager lm;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(providers)
    ListView mProviders;
    @Override
    public int getLayoutId() {
        return R.layout.activity_demo160101;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("根据Criteria获得LocationProvider");
        // 获取系统的LocationManager对象
        lm = (LocationManager) getSystemService(
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
        List<String> providerNames = lm.getProviders(cri, false);
        System.out.println(providerNames.size());
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
