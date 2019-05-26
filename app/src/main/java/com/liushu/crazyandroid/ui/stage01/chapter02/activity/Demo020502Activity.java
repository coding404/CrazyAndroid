package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo020502Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.lv_num01)
    ListView mLvNum01;
    @BindView(R.id.lv_num02)
    ListView mLvNum02;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020502;
    }


    @Override
    public void initView() {
        mTvTitleName.setText("使用ArrayAdapter创建ListView");
        String[] attrs = {"111", "222", "333", "444"};
        ArrayAdapter<String> adapter01 = new ArrayAdapter<String>(Demo020502Activity.this, R.layout.array_item, attrs);
        mLvNum01.setAdapter(adapter01);
        String[] attrs2 = {"122", "2212", "3313", "4414"};
        ArrayAdapter<String> adapter02 = new ArrayAdapter<String>(Demo020502Activity.this, R.layout.check_item, attrs2);
        mLvNum02.setAdapter(adapter02);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
