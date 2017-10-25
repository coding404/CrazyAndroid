package com.liushu.crazyandroid.ui.stage01.chapter02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaydenxiao.common.commonutils.NotifyUtil;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.bean.NotifyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liushu on 2017/9/29.
 */

public class NotifyAdapter extends BaseAdapter {

    private List<NotifyBean> objects = new ArrayList<NotifyBean>();

    private Context mContext;
    private LayoutInflater layoutInflater;
    private NotifyUtil currentNotify;

    public NotifyAdapter(Context context, List<NotifyBean> datas) {
        this.mContext = context;
        this.objects = datas;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public NotifyBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_notify, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.button1 = (RelativeLayout) convertView.findViewById(R.id.button1);
            viewHolder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
            viewHolder.titleTextview = (TextView) convertView.findViewById(R.id.title_textview);
            viewHolder.typeTextview = (TextView) convertView.findViewById(R.id.type_textview);
            convertView.setTag(viewHolder);
        }
        initializeViews((NotifyBean) getItem(position), (ViewHolder) convertView.getTag(), position);
        return convertView;
    }

    private void initializeViews(NotifyBean object, ViewHolder holder, final int position) {
        //TODO implement
        holder.imageview.setImageResource(object.getImageId());
        holder.titleTextview.setText(mContext.getResources().getText(object.getTitleId()));
        holder.typeTextview.setText(mContext.getResources().getText(object.getTypeId()));

    }

    protected class ViewHolder {
        private RelativeLayout button1;
        private ImageView imageview;
        private TextView titleTextview;
        private TextView typeTextview;
    }


}