package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo020505Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.lv_demo020505)
    ListView mLvDemo020505;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020505;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("扩建BasseAdapter实现不存储列表项的ListView");
        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return 20;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout layout=new LinearLayout(Demo020505Activity.this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView=new ImageView(Demo020505Activity.this);
                imageView.setImageResource(R.mipmap.ic_launcher);
                TextView textView=new TextView(Demo020505Activity.this);
                textView.setText("这是第"+position+"个条目。");
                layout.addView(imageView);
                layout.addView(textView);
                return layout;
            }
        };
        mLvDemo020505.setAdapter(adapter);
    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
