package com.dg.user008.crazyandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

import com.dg.user008.crazyandroid.R;

public class Demo020204Activity extends AppCompatActivity {

    private GridLayout mGridLayout;
    private String[] mStrings=new String[]{
            "7","8","9","÷",
            "4","5","6","*",
            "1","2","3","-",
            ".","0","=","+",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020204);
        mGridLayout= (GridLayout) findViewById(R.id.activity_demo020204);
        for (int i = 0; i < mStrings.length; i++) {
            Button button=new Button(this);
            button.setText(mStrings[i]);
            button.setTextSize(40);
            button.setPadding(5,35,5,35);
            GridLayout.Spec rawSpec=GridLayout.spec(i/4+2);
            GridLayout.Spec columnSpec=GridLayout.spec(i%4);
            GridLayout.LayoutParams params=new GridLayout.LayoutParams(rawSpec,columnSpec);
            params.setGravity(Gravity.FILL);
            mGridLayout.addView(button,params);

        }


    }
}
