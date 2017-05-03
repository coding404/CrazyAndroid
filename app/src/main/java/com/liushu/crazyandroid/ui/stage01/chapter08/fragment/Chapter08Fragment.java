package com.liushu.crazyandroid.ui.stage01.chapter08.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.google.gson.Gson;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.adapter.MyExpandableListViewAdapter;
import com.liushu.crazyandroid.bean.CatalogBean;
import com.liushu.crazyandroid.ui.stage01.chapter08.activity.Demo080000Activity;
import com.liushu.crazyandroid.ui.stage01.chapter08.activity.Demo080100Activity;
import com.liushu.crazyandroid.ui.stage01.chapter08.activity.Demo080101Activity;
import com.liushu.crazyandroid.ui.stage01.chapter08.activity.Demo080200Activity;
import com.liushu.crazyandroid.ui.stage01.chapter08.activity.Demo080300Activity;
import com.liushu.crazyandroid.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter08Fragment extends Fragment {
    private ExpandableListView mElv_chapter08;
    private MyExpandableListViewAdapter mViewAdapter;
    private List<CatalogBean.ChaptersBean> mBeen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chape08, null);
        mElv_chapter08 = (ExpandableListView) view.findViewById(R.id.expendlist_chapter08);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        mViewAdapter = new MyExpandableListViewAdapter(mBeen);
        mElv_chapter08.setAdapter(mViewAdapter);
        mElv_chapter08.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //界面跳转
                JumpActivity(groupPosition, childPosition);
                return true;
            }
        });
    }

    private void JumpActivity(int groupPosition, int childPosition) {

        switch (groupPosition) {
            case 0:
                if (childPosition == 0) {
                    //记录应用程序的使用次数
                    Intent intent = new Intent(getContext(), Demo080000Activity.class);
                    startActivity(intent);
                }
                break;
            case 1:
                if (childPosition == 0) {
                    //读取SD卡上的文件
                    Intent intent = new Intent(getContext(), Demo080100Activity.class);
                    startActivity(intent);

                }else if (childPosition == 1) {
                    //SD卡文件浏览器
                    ToastUitl.showShort("SD卡文件浏览器");
                    Intent intent = new Intent(getContext(), Demo080101Activity.class);
                    startActivity(intent);

                }
                break;
            case 2:
                if (childPosition == 0) {
                    //英文生词本
                    ToastUitl.showShort("英文生词本");
                    Intent intent = new Intent(getContext(), Demo080200Activity.class);
                    startActivity(intent);
                }
                break;
            case 3:
                if (childPosition == 0) {
                    //通过手势缩放图片
                    ToastUitl.showShort("通过手势缩放图片");
                    Intent intent = new Intent(getContext(), Demo080300Activity.class);
                    startActivity(intent);

                } else if (childPosition == 1) {
                    //通过手势实现翻页效果
                    ToastUitl.showShort("通过手势实现翻页效果");
                    Intent intent = new Intent(getContext(), Demo080300Activity.class);
                    startActivity(intent);

                }
                break;
            case 4:
                if (childPosition == 0) {


                }
                break;
            default:
                break;
        }


    }

    private void initData() {
        mBeen = new ArrayList<>();
        String s = FileUtil.readFromAssets(getContext(), "chapter08.txt");
        Gson gson = new Gson();
        CatalogBean catalogBean = gson.fromJson(s, CatalogBean.class);
        mBeen.clear();
        mBeen.addAll(catalogBean.getChapters());
    }
}
