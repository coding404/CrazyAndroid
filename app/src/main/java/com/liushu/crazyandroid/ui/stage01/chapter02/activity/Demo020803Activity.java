package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo020803Activity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.date_picker)
    DatePicker mDatePicker;
    @BindView(R.id.time_picker)
    TimePicker mTimePicker;
    @BindView(R.id.et_test03)
    EditText mEtTest03;

    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020803;
    }


    @Override
    public void initView() {
        mTvTitle.setText("用户选择日期、时间");
        Calendar instance = Calendar.getInstance();
        mYear = instance.get(Calendar.YEAR);
        mMonth = instance.get(Calendar.MONTH);
        mDay = instance.get(Calendar.DAY_OF_MONTH);
        mHour = instance.get(Calendar.AM_PM);
        mMinute = instance.get(Calendar.MINUTE);
        mDatePicker.init(mYear, mMonth, mDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                showDate(mYear, mMonth, mDay, mHour, mMinute);
            }
        });
        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                mHour = hourOfDay;
                mMinute = minute;
                showDate(mYear, mMonth, mDay, mHour, mMinute);
            }
        });
    }

    private void showDate(int year, int month, int day, int hour, int minute) {
        mEtTest03.setText("您的购买日期为：" + year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分");
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
