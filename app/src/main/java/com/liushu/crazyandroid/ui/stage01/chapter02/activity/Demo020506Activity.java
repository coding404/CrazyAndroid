package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo020506Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.gv_test)
    GridView mGvTest;
    @Bind(R.id.iv_test)
    ImageView mIvTest;
    private int[] mInts = {R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7,
            R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10, R.drawable.bomb11,
            R.drawable.bomb12, R.drawable.bomb13, R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16};

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020506;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("带预览的图片浏览器");
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < mInts.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", mInts[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.cell, new String[]{"image"}, new int[]{R.id.iv});
        mGvTest.setAdapter(adapter);
        mGvTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mIvTest.setImageResource(mInts[position]);
            }
        });
        mGvTest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mIvTest.setImageResource(mInts[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
