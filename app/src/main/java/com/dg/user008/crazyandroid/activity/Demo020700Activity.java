package com.dg.user008.crazyandroid.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

import com.dg.user008.crazyandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Demo020700Activity extends AppCompatActivity {

    @Bind(R.id.vs_test01)
    ViewSwitcher mVsTest01;
    @Bind(R.id.btn_prev)
    Button mBtnPrev;
    @Bind(R.id.btn_next)
    Button mBtnNext;
    @Bind(R.id.rl_test01)
    RelativeLayout mRlTest01;
    @Bind(R.id.is_test)
    ImageSwitcher mIsTest;
    @Bind(R.id.ll_test02)
    LinearLayout mLlTest02;
    @Bind(R.id.gl_test)
    GridView mGlTest;
    @Bind(R.id.vf_test)
    ViewFlipper mVfTest;
    @Bind(R.id.btn_pre02)
    Button mBtnPre02;
    @Bind(R.id.btn_auto02)
    Button mBtnAuto02;
    @Bind(R.id.btn_next02)
    Button mBtnNext02;
    @Bind(R.id.rv_test03)
    RelativeLayout mRvTest03;
    private int mGroupPosition;
    private int mChildPosition;
    private static int NUMBER_PER_SCREEN = 12;

    @OnClick({R.id.btn_prev, R.id.btn_next,R.id.btn_pre02, R.id.btn_auto02, R.id.btn_next02})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_prev:
                prov();
                break;
            case R.id.btn_next:
                next();
                break;
            case R.id.btn_pre02:
                mVfTest.setInAnimation(this,R.anim.slide_in_right);
                mVfTest.setOutAnimation(this,R.anim.slide_out_left);
                mVfTest.showPrevious();
                mVfTest.stopFlipping();

                break;
            case R.id.btn_auto02:
                mVfTest.setInAnimation(this,R.anim.slide_in_left);
                mVfTest.setOutAnimation(this,R.anim.slide_out_right);
                mVfTest.startFlipping();
                break;
            case R.id.btn_next02:
                mVfTest.setInAnimation(this,R.anim.slide_in_left);
                mVfTest.setOutAnimation(this,R.anim.slide_out_right);
                mVfTest.showNext();
                mVfTest.stopFlipping();

                break;
        }
    }

    public static class DataItem {
        private String dataString;
        private Drawable dataDrawable;
    }

    private List<DataItem> mItems = new ArrayList<>();
    private int screenNo = -1;
    private int screenCount;
    private LayoutInflater mInflater;
    private int[] mInts = {R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7,
            R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10, R.drawable.bomb11,
            R.drawable.bomb12, R.drawable.bomb13, R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020700);
        ButterKnife.bind(this);
        mGroupPosition = getIntent().getIntExtra("groupPosition", -1);
        mChildPosition = getIntent().getIntExtra("childPosition", -1);
        initView(mChildPosition);
    }

    private void initView(int childPosition) {
        switch (childPosition) {
            case 0:
                mRlTest01.setVisibility(View.VISIBLE);
                initData0();
                break;
            case 1:
                mLlTest02.setVisibility(View.VISIBLE);
                Log.e("111111", "1111");
                initData1();
                break;
            case 2:
                mRvTest03.setVisibility(View.VISIBLE);
                initData2();
                break;
            default:
                break;
        }


    }

    private void initData0() {
        mInflater = LayoutInflater.from(Demo020700Activity.this);
        for (int i = 0; i < 40; i++) {
            String label = "" + i;
            Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
            DataItem dataItem = new DataItem();
            dataItem.dataString = label;
            dataItem.dataDrawable = drawable;
            mItems.add(dataItem);
        }
        screenCount = mItems.size() % NUMBER_PER_SCREEN == 0 ? mItems.size() / NUMBER_PER_SCREEN : mItems.size() / NUMBER_PER_SCREEN + 1;
        mVsTest01.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return mInflater.inflate(R.layout.slidelistview, null);
            }
        });
        next();
    }

    private void prov() {
        if (screenNo > 0) {
            screenNo--;
            mVsTest01.setInAnimation(this, R.anim.slide_in_right);
            mVsTest01.setOutAnimation(this, R.anim.slide_out_left);
            ((GridView) mVsTest01.getNextView()).setAdapter(mAdapter);
            mVsTest01.showPrevious();
        }
    }

    private void next() {
        Log.e("screenCount", screenCount + "");
        Log.e("screenNo", screenNo + "");
        if (screenNo < screenCount - 1) {
            screenNo++;
            mVsTest01.setInAnimation(this, R.anim.slide_in_left);
            mVsTest01.setOutAnimation(this, R.anim.slide_out_right);
            ((GridView) mVsTest01.getNextView()).setAdapter(mAdapter);
            mVsTest01.showNext();
        }
    }

    private void initData1() {
        List<Map<String, Object>> mapList = new ArrayList<>();

        for (int i = 0; i < mInts.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", mInts[i]);
            mapList.add(map);
        }
        mIsTest.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(Demo020700Activity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, mapList, R.layout.cell, new String[]{"image"}, new int[]{R.id.iv});
        mGlTest.setAdapter(simpleAdapter);
        mGlTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mIsTest.setImageResource(mInts[position]);
            }
        });
    }

    private void initData2() {




    }

    private BaseAdapter mAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            if (screenNo == screenCount - 1 && mItems.size() % NUMBER_PER_SCREEN != 0) {
                return mItems.size() % NUMBER_PER_SCREEN;
            }
            return NUMBER_PER_SCREEN;
        }

        @Override
        public Object getItem(int position) {
            return mItems.get(screenNo * NUMBER_PER_SCREEN + position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;
            if (convertView == null) {
                view = mInflater.inflate(R.layout.labelicon, null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_item);
            imageView.setImageDrawable(mItems.get(position).dataDrawable);
            TextView textView = (TextView) view.findViewById(R.id.tv_item);
            textView.setText(mItems.get(position).dataString);
            return view;
        }
    };

}
