package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo020504Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.lv_test)
    ListView mLvTest;
    private String[] names = {"虎头", "弄玉", "李清照", "李白"};
    private String[] descs = {"一个可爱的女孩", "一个擅长音乐的女孩", "一个擅长文学的女性", "一个浪漫主义诗人"};
    private int[] mInts = {R.drawable.tiger, R.drawable.nongyu, R.drawable.qingzhao, R.drawable.libai};

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020504;
    }


    @Override
    public void initView() {
        mTvTitleName.setText("使用SimpleAdapter创建ListView");
        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("header", mInts[i]);
            map.put("personName", names[i]);
            map.put("descs", descs[i]);
            listItems.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.simple_item,
                new String[]{"header", "personName", "descs"}, new int[]{R.id.header, R.id.name, R.id.desc});
        mLvTest.setAdapter(simpleAdapter);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
