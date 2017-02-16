package com.dg.user008.crazyandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dg.user008.crazyandroid.R;

public class Demo020600Activity extends AppCompatActivity {

    private int mGroupPosition;
    private int mChildPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        mGroupPosition = intent.getIntExtra("groupPosition", -1);
        mChildPosition = intent.getIntExtra("childPosition", -1);
        setContentView(R.layout.activity_demo020600);
        initView(mGroupPosition, mChildPosition);
        initData(mGroupPosition, mChildPosition);

    }

    private void initData(int groupPosition, int childPosition) {


    }

    private void initView(int groupPosition, int childPosition) {


    }
}
