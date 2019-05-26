package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo020508Activity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.avf)
    AdapterViewFlipper mAvf;
    @BindView(R.id.btn_next)
    Button mBtnNext;
    @BindView(R.id.btn_before)
    Button mBtnBefore;
    @BindView(R.id.btn_auto)
    Button mBtnAuto;
    private int[] mInts = {R.drawable.chunv, R.drawable.shuangyu, R.drawable.shuangzi, R.drawable.baiyang, R.drawable.shizi, R.drawable.mojie,
            R.drawable.juxie, R.drawable.tianxie, R.drawable.tiancheng, R.drawable.sheshou, R.drawable.jinniu, R.drawable.shuiping};

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020508;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("自动播放的图片库");
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


    @OnClick({R.id.iv_back, R.id.btn_next, R.id.btn_before, R.id.btn_auto})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
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
