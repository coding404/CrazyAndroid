package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.liushu.crazyandroid.R;

public class Demo020307Activity extends AppCompatActivity {

    private Chronometer mChronometer;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020307);
        mChronometer = (Chronometer) findViewById(R.id.chronometer_test);
        mButton = (Button) findViewById(R.id.btn_test);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChronometer.setBase(SystemClock.elapsedRealtime());
                mChronometer.start();
                mButton.setClickable(false);
            }
        });
        mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - chronometer.getBase() > 20 * 1000) {
                    mChronometer.stop();
                    mButton.setClickable(true);

                }
            }
        });
    }
}
