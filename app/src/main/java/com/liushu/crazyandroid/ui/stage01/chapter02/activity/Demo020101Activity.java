package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.util.Date;

/**
 * Created by liushu on 2017/2/6.
 */

public class Demo020101Activity extends BaseActivity {

    private ImageView mIVBack;
    private TextView mTVTitle;

    @Override
    public int getLayoutId() {

        return -1;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTVTitle.setText("用编程的方式开发UI界面");
        mIVBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public View getLayoutView() {

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        View inflate = getLayoutInflater().inflate(R.layout.head_title_layout, null);
        mIVBack = (ImageView) inflate.findViewById(R.id.iv_back);
        mTVTitle= (TextView) inflate.findViewById(R.id.tv_title_name);
        final TextView textView = new TextView(this);
        Button button = new Button(this);
        button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setText("ok");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Hello Android!" + new Date());
            }
        });
        layout.addView(inflate);
        layout.addView(textView);
        layout.addView(button);
        //layout.setId(View.generateViewId());
        return layout;
    }
}
