package com.dg.user008.crazyandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.dg.user008.crazyandroid.R;

public class Demo020306Activity extends AppCompatActivity {

    private ToggleButton mToggleButton;
    private Switch mSwitch;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020306);
        mSwitch = (Switch) findViewById(R.id.switch_test);
        mLinearLayout = (LinearLayout) findViewById(R.id.ll_test);
        mToggleButton = (ToggleButton) findViewById(R.id.tb_test);
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mSwitch.setChecked(true);
                    mToggleButton.setChecked(true);
                    mLinearLayout.setOrientation(LinearLayout.VERTICAL);
                } else {
                    mSwitch.setChecked(false);
                    mToggleButton.setChecked(false);
                    mLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
                }
            }
        };
        mSwitch.setOnCheckedChangeListener(listener);
        mToggleButton.setOnCheckedChangeListener(listener);


    }
}
