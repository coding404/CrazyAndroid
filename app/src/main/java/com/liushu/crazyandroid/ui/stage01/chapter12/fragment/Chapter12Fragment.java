package com.liushu.crazyandroid.ui.stage01.chapter12.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.google.gson.Gson;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.adapter.MyExpandableListViewAdapter;
import com.liushu.crazyandroid.bean.CatalogBean;
import com.liushu.crazyandroid.ui.stage01.chapter12.activity.Demo120200Activity;
import com.liushu.crazyandroid.ui.stage01.chapter12.activity.Demo120201Activity;
import com.liushu.crazyandroid.ui.stage01.chapter12.activity.Demo120300Activity;
import com.liushu.crazyandroid.ui.stage01.chapter12.activity.Demo120301Activity;
import com.liushu.crazyandroid.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter12Fragment extends Fragment {
    private ExpandableListView mElv_chapter12;
    private MyExpandableListViewAdapter mViewAdapter;
    private List<CatalogBean.ChaptersBean> mBeen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chape12, null);
        mElv_chapter12 = (ExpandableListView) view.findViewById(R.id.expendlist_chapter12);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        mViewAdapter = new MyExpandableListViewAdapter(mBeen);
        mElv_chapter12.setAdapter(mViewAdapter);
        mElv_chapter12.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //界面跳转
                JumpActivity(groupPosition, childPosition);
                //Toast.makeText(getContext(),"groupPosition="+groupPosition+",childPosition="+childPosition,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void JumpActivity(int groupPosition, int childPosition) {

        switch (groupPosition) {
            case 0:
                if (childPosition == 0) {


                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                }
                break;
            case 1:
                if (childPosition == 0) {


                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                } else if (childPosition == 3) {


                } else if (childPosition == 4) {


                }
                break;
            case 2:
                if (childPosition == 0) {
                    //绘制平面上的多边形
                    Intent intent = new Intent(getContext(), Demo120200Activity.class);
                    startActivity(intent);

                } else if (childPosition == 1) {

                    //旋转
                    Intent intent = new Intent(getContext(), Demo120201Activity.class);
                    startActivity(intent);
                }
                break;
            case 3:
                if (childPosition == 0) {
                    //构建3D图形
                    Intent intent = new Intent(getContext(), Demo120300Activity.class);
                    startActivity(intent);

                } else if (childPosition == 1) {
                    //应用纹理贴图
                    Intent intent = new Intent(getContext(), Demo120301Activity.class);
                    startActivity(intent);

                } else if (childPosition == 2) {


                }
                break;
            default:
                break;
        }


    }

    private void initData() {
        mBeen = new ArrayList<>();
        String s = FileUtil.readFromAssets(getContext(), "chapter12.txt");
        Gson gson = new Gson();
        CatalogBean catalogBean = gson.fromJson(s, CatalogBean.class);
        mBeen.clear();
        mBeen.addAll(catalogBean.getChapters());
    }
}
