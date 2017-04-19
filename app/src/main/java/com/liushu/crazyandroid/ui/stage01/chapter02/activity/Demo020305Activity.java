package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.liushu.crazyandroid.R;

public class Demo020305Activity extends AppCompatActivity {

    private RadioGroup mRadioGroup;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020305);
        mRadioGroup= (RadioGroup) findViewById(R.id.rg);
        mTextView= (TextView) findViewById(R.id.tv_content);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String string=checkedId==R.id.rb_female?"你是女生":"你是男生";
                mTextView.setText(string);
            }
        });
    }
}
