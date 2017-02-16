package com.dg.user008.crazyandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dg.user008.crazyandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Demo020502Activity extends AppCompatActivity {

    @Bind(R.id.lv_num01)
    ListView mLvNum01;
    @Bind(R.id.lv_num02)
    ListView mLvNum02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020502);
        ButterKnife.bind(this);
        String[] attrs={"111","222","333","444"};
        ArrayAdapter<String > adapter01=new ArrayAdapter<String>(Demo020502Activity.this, R.layout.array_item,attrs);
        mLvNum01.setAdapter(adapter01);
        String[] attrs2={"122","2212","3313","4414"};
        ArrayAdapter<String > adapter02=new ArrayAdapter<String>(Demo020502Activity.this, R.layout.check_item,attrs2);
        mLvNum02.setAdapter(adapter02);


    }
}
