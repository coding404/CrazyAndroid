package com.liushu.crazyandroid.ui.stage01.chapter08.activity;

import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo080000Activity extends BaseActivity {

    SharedPreferences preferences;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.textView)
    TextView mTextView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo080000;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("记录应用程序的使用次数");
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

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
