package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo020804Activity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.number_pick_low)
    NumberPicker mNumberPickLow;
    @Bind(R.id.number_pick_high)
    NumberPicker mNumberPickHigh;
    @Bind(R.id.ll_demo020800_test3)
    LinearLayout mLlDemo020800Test3;
    private int minPrice = 25;
    private int maxPrice = 75;
    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020804;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitle.setText("选择您意向的价格范围");

        mNumberPickLow.setMinValue(10);
        mNumberPickLow.setMaxValue(50);
        mNumberPickLow.setValue(minPrice);
        mNumberPickHigh.setMinValue(60);
        mNumberPickHigh.setMaxValue(100);
        mNumberPickHigh.setValue(maxPrice);
        mNumberPickLow.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                minPrice = newVal;
                showSelectPrice();
            }
        });
        mNumberPickHigh.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                maxPrice = newVal;
                showSelectPrice();
            }
        });
    }

    private void showSelectPrice() {
        ToastUitl.showShort("您选择的最低价格为：" + minPrice + '\n' + "最高价格为：" + maxPrice);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
