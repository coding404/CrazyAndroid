package com.dg.user008.crazyandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.dg.user008.crazyandroid.R;
import com.dg.user008.crazyandroid.bean.CatalogBean;

import java.util.List;

/**
 * Created by liushu on 2017/2/3.
 */

public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {

    private List<CatalogBean.ChaptersBean> mBeen;

    public MyExpandableListViewAdapter(List<CatalogBean.ChaptersBean> been) {
        mBeen = been;
    }

    @Override
    public int getGroupCount() {
        return mBeen.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mBeen.get(groupPosition).getParagraphs().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mBeen.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mBeen.get(groupPosition).getParagraphs().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition*100+childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder=null;
        if (convertView==null){
            groupHolder=new GroupHolder();
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.expendlist_group,null);
            groupHolder.mViewChapter= (TextView) convertView.findViewById(R.id.tv_expendgroup_chapter);
            groupHolder.mViewTotal= (TextView) convertView.findViewById(R.id.tv_expendgroup_total);
            convertView.setTag(groupHolder);
        }else {
            groupHolder= (GroupHolder) convertView.getTag();
        }
        CatalogBean.ChaptersBean chaptersBean = mBeen.get(groupPosition);
        groupHolder.mViewChapter.setText(chaptersBean.getChapterName());
        groupHolder.mViewTotal.setText(chaptersBean.getParagraphs().size()+"");
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ItemHolder itemHolder=null;
        if (convertView==null){
            itemHolder=new ItemHolder();
            convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.expendlist_item,null);
            itemHolder.mViewParagraph= (TextView) convertView.findViewById(R.id.tv_expandItem);
            convertView.setTag(itemHolder);
        }else {
            itemHolder= (ItemHolder) convertView.getTag();
        }
        CatalogBean.ChaptersBean.ParagraphsBean paragraphsBean = mBeen.get(groupPosition).getParagraphs().get(childPosition);
        itemHolder.mViewParagraph.setText(paragraphsBean.getParagraphName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    public static class GroupHolder {
        private TextView mViewChapter;
        private TextView mViewTotal;
    }

    public static class ItemHolder {
        private TextView mViewParagraph;
    }
}
