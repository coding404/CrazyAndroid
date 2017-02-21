package com.dg.user008.crazyandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dg.user008.crazyandroid.R;

public class Demo020700Activity extends AppCompatActivity {

    private int mGroupPosition;
    private int mChildPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020700);
        mGroupPosition = getIntent().getIntExtra("", -1);
        mChildPosition = getIntent().getIntExtra("", -1);
        initView(mChildPosition);
    }

    private void initView(int childPosition) {
        switch (childPosition) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }


    }
}
