package com.liushu.crazyandroid.ui.stage01.chapter07.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.adapter.MyExpandableListViewAdapter;
import com.liushu.crazyandroid.bean.CatalogBean;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070100Activity;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070101Activity;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070102Activity;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070103Activity;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070200Activity;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070201Activity;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070202Activity;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070300Activity;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070301Activity;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070400Activity;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070401Activity;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070402Activity;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070500Activity;
import com.liushu.crazyandroid.ui.stage01.chapter07.activity.Demo070600Activity;
import com.liushu.crazyandroid.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter07Fragment extends Fragment {
    private ExpandableListView mElv_chapter07;
    private MyExpandableListViewAdapter mViewAdapter;
    private List<CatalogBean.ChaptersBean> mBeen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chape07, null);
        mElv_chapter07 = (ExpandableListView) view.findViewById(R.id.expendlist_chapter07);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        mViewAdapter = new MyExpandableListViewAdapter(mBeen);
        mElv_chapter07.setAdapter(mViewAdapter);
        mElv_chapter07.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(getContext(), "groupPosition=" + groupPosition + ",childPosition=" + childPosition, Toast.LENGTH_SHORT).show();
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


                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                }
                break;
            case 1:
                if (childPosition == 0) {
                    //Android绘图基础
                    Intent intent = new Intent(getContext(), Demo070100Activity.class);
                    startActivity(intent);
                } else if (childPosition == 1) {
                    //path类
                    Intent intent = new Intent(getContext(), Demo070101Activity.class);
                    startActivity(intent);
                } else if (childPosition == 2) {
                    //采用双缓冲实现画图板
                    Intent intent = new Intent(getContext(), Demo070102Activity.class);
                    startActivity(intent);
                } else if (childPosition == 3) {
                    //弹球游戏
                    Intent intent = new Intent(getContext(), Demo070103Activity.class);
                    startActivity(intent);
                }
                break;
            case 2:
                if (childPosition == 0) {
                    //移动游戏背景
                    Intent intent = new Intent(getContext(), Demo070200Activity.class);
                    startActivity(intent);
                } else if (childPosition == 1) {
                    //可揉动的图片
                    Intent intent = new Intent(getContext(), Demo070201Activity.class);
                    startActivity(intent);

                } else if (childPosition == 2) {
                    //使用shader填充图形
                    Intent intent = new Intent(getContext(), Demo070202Activity.class);
                    startActivity(intent);
                }
                break;
            case 3:
                if (childPosition == 0) {
                    //animationDrawable与逐帧动画
                    Intent intent = new Intent(getContext(), Demo070300Activity.class);
                    startActivity(intent);

                } else if (childPosition == 1) {

                    //在指定点爆炸
                    Intent intent = new Intent(getContext(), Demo070301Activity.class);
                    startActivity(intent);

                }
                break;
            case 4:
                if (childPosition == 0) {
                    //位置、大小、旋转度、透明度改变的补间动画
                    Intent intent = new Intent(getContext(), Demo070400Activity.class);
                    startActivity(intent);
                } else if (childPosition == 1) {
                    //蝴蝶飞舞
                    Intent intent = new Intent(getContext(), Demo070401Activity.class);
                    startActivity(intent);
                }else if (childPosition ==2) {
                    //自定义补间动画
                    Intent intent = new Intent(getContext(), Demo070402Activity.class);
                    startActivity(intent);
                }
                break;
            case 5:
                if (childPosition == 0) {
                    //大珠小珠落玉盘
                    Intent intent = new Intent(getContext(), Demo070500Activity.class);
                    startActivity(intent);

                }
                break;
            case 6:
                if (childPosition == 0) {
                    //基于SurfaceView开发示波器
                    Intent intent = new Intent(getContext(), Demo070600Activity.class);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }


    }

    private void initData() {
        mBeen = new ArrayList<>();
        String s = FileUtil.readFromAssets(getContext(), "chapter07.txt");
        Gson gson = new Gson();
        CatalogBean catalogBean = gson.fromJson(s, CatalogBean.class);
        mBeen.clear();
        mBeen.addAll(catalogBean.getChapters());
    }
}
