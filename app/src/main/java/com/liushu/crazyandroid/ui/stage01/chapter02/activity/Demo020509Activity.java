package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.StackView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo020509Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.sv)
    StackView mSv;
    @Bind(R.id.btn_previous)
    Button mBtnPrevious;
    @Bind(R.id.btn_next)
    Button mBtnNext;
    private int[] mInts = {R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7,
            R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10, R.drawable.bomb11,
            R.drawable.bomb12, R.drawable.bomb13, R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16};

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020509;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("叠在一起的图片");
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < mInts.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", mInts[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.cell, new String[]{"image"}, new int[]{R.id.iv});
        mSv.setAdapter(adapter);
    }


    @OnClick({R.id.iv_back, R.id.btn_previous, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_previous:
                mSv.showPrevious();
                break;
            case R.id.btn_next:
                mSv.showNext();
                break;
        }
    }
}
