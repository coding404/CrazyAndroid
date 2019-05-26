package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.liushu.crazyandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo020802Activity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.calend_view)
    CalendarView mCalendView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020802;
    }


    @Override
    public void initView() {
        mTvTitle.setText("选择您的生日");
        mCalendView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                ToastUitl.showShort("您的生日是：" + year + "年" + month + "月" + dayOfMonth + "日");
            }
        });
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
