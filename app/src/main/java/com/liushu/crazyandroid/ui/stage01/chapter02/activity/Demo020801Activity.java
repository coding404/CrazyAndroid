package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo020801Activity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.btn_simple)
    Button mBtnSimple;
    @Bind(R.id.btn_image)
    Button mBtnImage;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020801;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitle.setText("Toast工具类");
     //   ToastUitl.showShort("");
    }


    @OnClick({R.id.iv_back, R.id.btn_simple, R.id.btn_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_simple:
                Toast.makeText(mContext, "简单的提示", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_image:
                Toast toast = new Toast(this);
                LinearLayout layout = new LinearLayout(this);
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.mipmap.ic_launcher);
                layout.addView(imageView);
                TextView textView = new TextView(this);
                textView.setText("带图片的提示");
                textView.setTextColor(Color.BLUE);
                textView.setTextSize(24);
                layout.addView(textView);
                toast.setView(layout);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }
}
