package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.QuickContactBadge;

import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Demo020403Activity extends AppCompatActivity {

    @Bind(R.id.qcb_test)
    QuickContactBadge mQcbTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020403);
        ButterKnife.bind(this);
        mQcbTest.assignContactFromPhone("18117527783", true);
    }
}
