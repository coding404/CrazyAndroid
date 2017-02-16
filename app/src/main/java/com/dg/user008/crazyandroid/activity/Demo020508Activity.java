package com.dg.user008.crazyandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dg.user008.crazyandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Demo020508Activity extends AppCompatActivity {

    @Bind(R.id.avf)
    AdapterViewFlipper mAvf;
    @Bind(R.id.btn_next)
    Button mBtnNext;
    @Bind(R.id.btn_before)
    Button mBtnBefore;
    @Bind(R.id.btn_auto)
    Button mBtnAuto;
    @Bind(R.id.activity_demo020508)
    RelativeLayout mActivityDemo020508;
    private int[] mInts = {R.drawable.chunv, R.drawable.shuangyu, R.drawable.shuangzi, R.drawable.baiyang, R.drawable.shizi, R.drawable.mojie,
            R.drawable.juxie, R.drawable.tianxie, R.drawable.tiancheng, R.drawable.sheshou, R.drawable.jinniu, R.drawable.shuiping};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020508);
        ButterKnife.bind(this);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mInts.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(Demo020508Activity.this);
                imageView.setImageResource(mInts[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        mAvf.setAdapter(adapter);


    }

    @OnClick({R.id.btn_next, R.id.btn_before, R.id.btn_auto})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                mAvf.showNext();
                mAvf.stopFlipping();
                break;
            case R.id.btn_before:
                mAvf.showPrevious();
                mAvf.stopFlipping();
                break;
            case R.id.btn_auto:
                mAvf.startFlipping();
                break;
        }
    }
}
