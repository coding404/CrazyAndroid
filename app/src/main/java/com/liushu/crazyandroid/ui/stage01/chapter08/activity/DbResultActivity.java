package com.liushu.crazyandroid.ui.stage01.chapter08.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.liushu.crazyandroid.R;

import java.util.List;
import java.util.Map;

public class DbResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_result);
        ListView listView = (ListView) findViewById(R.id.show);
        Intent intent = getIntent();
        // 获取该intent所携带的数据
        Bundle data = intent.getExtras();
        // 从Bundle数据包中取出数据
        @SuppressWarnings("unchecked")
        List<Map<String, String>> list = (List<Map<String, String>>)
                data.getSerializable("data");
        // 将List封装成SimpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(DbResultActivity.this
                , list,
                R.layout.lines, new String[]{"word", "detail"}
                , new int[]{R.id.word, R.id.detail});
        // 填充ListView
        listView.setAdapter(adapter);
    }
}
