package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.liushu.crazyandroid.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo021100Activity extends AppCompatActivity {
    private int mGroupPosition;
    private int mChildPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo021100);
        mGroupPosition = getIntent().getIntExtra("groupPosition", -1);
        mChildPosition = getIntent().getIntExtra("childPosition", -1);
        initView(mChildPosition);
    }

    private void initView(int childPosition) {
        switch (childPosition) {
            case 0:
            initData0();
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
        }
    }

    private void initData0() {

        long deadLine=Long.parseLong("1488210720000");
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd HH:mm");
        Date date=new Date(deadLine);
        String endTime = dateFormat.format(date);

        Log.e("22222",deadLine+":"+endTime);

    }
}
