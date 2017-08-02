package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.liushu.crazyandroid.R;

import java.util.List;

/**
 * Created by liushu on 2017/8/2.
 */

public class OneChioceAdapter extends BaseAdapter {
    private List<String> mList;
    private List<Boolean> mSelects;

    public OneChioceAdapter(List<String> list, List<Boolean> selects) {
        mList = list;
        mSelects = selects;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_one_chioce, null);
            holder = new ViewHolder();
            holder.mTvContact = (TextView) convertView.findViewById(R.id.tv_contact);
            holder.mRbOneChioce = (RadioButton) convertView.findViewById(R.id.rb_one_chioce);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mTvContact.setText(mList.get(position));
        holder.mRbOneChioce.setChecked(mSelects.get(position));
        return convertView;
    }

    public static class ViewHolder {
        private TextView mTvContact;
        private RadioButton mRbOneChioce;
    }
}
