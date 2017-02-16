package com.dg.user008.crazyandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.dg.user008.crazyandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Demo020506Activity extends AppCompatActivity {

    @Bind(R.id.gv_test)
    GridView mGvTest;
    @Bind(R.id.iv_test)
    ImageView mIvTest;
    private int[] mInts={R.drawable.bomb5,R.drawable.bomb6,R.drawable.bomb7,
            R.drawable.bomb8,R.drawable.bomb9,R.drawable.bomb10,R.drawable.bomb11,
            R.drawable.bomb12,R.drawable.bomb13,R.drawable.bomb14,R.drawable.bomb15,R.drawable.bomb16};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020506);
        ButterKnife.bind(this);
        List<Map<String,Object>> list=new ArrayList<>();
        for (int i = 0; i < mInts.length; i++) {
            Map<String,Object> map=new HashMap<>();
            map.put("image",mInts[i]);
            list.add(map);
        }
        SimpleAdapter adapter=new SimpleAdapter(this,list,R.layout.cell,new String[]{"image"},new int[]{R.id.iv});
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
}
