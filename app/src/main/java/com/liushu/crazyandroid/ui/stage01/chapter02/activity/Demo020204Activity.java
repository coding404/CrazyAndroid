package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo020204Activity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.gl_test)
    GridLayout mGlTest;
    private String[] mStrings = new String[]{
            "7", "8", "9", "÷",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            ".", "0", "=", "+",
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020204;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("计算器界面");
        for (int i = 0; i < mStrings.length; i++) {
            Button button=new Button(this);
            button.setText(mStrings[i]);
            button.setTextSize(40);
            button.setPadding(5,35,5,35);
            GridLayout.Spec rawSpec=GridLayout.spec(i/4+2);
            GridLayout.Spec columnSpec=GridLayout.spec(i%4);
            GridLayout.LayoutParams params=new GridLayout.LayoutParams(rawSpec,columnSpec);
            params.setGravity(Gravity.FILL);
            mGlTest.addView(button,params);

        }
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
