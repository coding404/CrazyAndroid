package com.dg.user008.crazyandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.dg.user008.crazyandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Demo020504Activity extends AppCompatActivity {

    @Bind(R.id.activity_demo020504)
    ListView mActivityDemo020504;
    private String[] names = {"虎头", "弄玉", "李清照", "李白"};
    private String[] descs = {"一个可爱的女孩", "一个擅长音乐的女孩", "一个擅长文学的女性", "一个浪漫主义诗人"};
    private int[] mInts = {R.drawable.tiger, R.drawable.nongyu, R.drawable.qingzhao, R.drawable.libai};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020504);
        ButterKnife.bind(this);
        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("header", mInts[i]);
            map.put("personName", names[i]);
            map.put("descs", descs[i]);
            listItems.add(map);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.simple_item,
                new String[]{"header","personName","descs"},new int[]{R.id.header,R.id.name,R.id.desc});
        mActivityDemo020504.setAdapter(simpleAdapter);
    }
}
