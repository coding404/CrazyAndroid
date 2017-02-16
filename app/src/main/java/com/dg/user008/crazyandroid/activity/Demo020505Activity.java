package com.dg.user008.crazyandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.dg.user008.crazyandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Demo020505Activity extends AppCompatActivity {

    @Bind(R.id.lv_demo020505)
    ListView mLvDemo020505;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020505);
        ButterKnife.bind(this);
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
}
