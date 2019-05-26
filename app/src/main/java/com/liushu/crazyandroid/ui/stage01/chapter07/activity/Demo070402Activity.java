package com.liushu.crazyandroid.ui.stage01.chapter07.activity;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.MyAnimation;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo070402Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.list)
    ListView mList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo070402;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("自定义补间动画");
        WindowManager windowManager = (WindowManager)
                getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrice = new DisplayMetrics();
        // 获取屏幕的宽和高
        display.getMetrics(metrice);
        // 设置对ListView组件应用动画
        mList.setAnimation(new MyAnimation(metrice.xdpi / 2, metrice.ydpi / 2, 3500));
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
