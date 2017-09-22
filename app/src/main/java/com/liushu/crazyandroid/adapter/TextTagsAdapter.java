package com.liushu.crazyandroid.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moxun.tagcloudlib.view.TagsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moxun on 16/1/19.
 */
public class TextTagsAdapter extends TagsAdapter {

    private List<String> dataSet = new ArrayList<>();
    private View.OnClickListener mListener;

    public TextTagsAdapter(List<String> dataSet) {
        this.dataSet = dataSet;
    }

    public void setListener(View.OnClickListener listener) {
        mListener = listener;
    }
    /* public TextTagsAdapter(@NonNull String... data) {
        dataSet.clear();
        Collections.addAll(dataSet, data);
    }*/

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public View getView(final Context context, int position, ViewGroup parent) {
        TextView tv = new TextView(context);
        tv.setText(dataSet.get(position));
        tv.setGravity(Gravity.CENTER);
        if (mListener != null) {
            tv.setTag(position);
            tv.setOnClickListener(mListener);
        }
        /*tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Click", "Tag " + position + " clicked.");
                Toast.makeText(context, "Tag " + position + " clicked", Toast.LENGTH_SHORT).show();
            }
        });*/
        tv.setTextColor(Color.WHITE);
        return tv;
    }

    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public int getPopularity(int position) {
        return position % 7;
    }

    @Override
    public void onThemeColorChanged(View view, int themeColor) {
        if (themeColor != 0)
            view.setBackgroundColor(themeColor);
    }
}