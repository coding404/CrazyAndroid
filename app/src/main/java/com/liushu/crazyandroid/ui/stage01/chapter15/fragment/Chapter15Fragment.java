package com.liushu.crazyandroid.ui.stage01.chapter15.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ExpandableListView;

import com.google.gson.Gson;
import com.jaydenxiao.common.base.BaseFragment;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.adapter.MyExpandableListViewAdapter;
import com.liushu.crazyandroid.bean.CatalogBean;
import com.liushu.crazyandroid.ui.stage01.chapter15.activity.Demo150000Activity;
import com.liushu.crazyandroid.ui.stage01.chapter15.activity.Demo150100Activity;
import com.liushu.crazyandroid.ui.stage01.chapter15.activity.Demo150200Activity;
import com.liushu.crazyandroid.ui.stage01.chapter15.activity.Demo150201Activity;
import com.liushu.crazyandroid.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter15Fragment extends BaseFragment {
    @BindView(R.id.expendlist_chapter15)
    ExpandableListView mElv_chapter15;
    private MyExpandableListViewAdapter mViewAdapter;
    private List<CatalogBean.ChaptersBean> mBeen;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_chape15;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        mViewAdapter = new MyExpandableListViewAdapter(mBeen);
        mElv_chapter15.setAdapter(mViewAdapter);
        mElv_chapter15.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
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
                    ToastUitl.showShort("加速传感器");
                    Intent intent = new Intent(getContext(), Demo150000Activity.class);
                    startActivity(intent);

                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                }
                break;
            case 1:
                if (childPosition == 0) {
                    ToastUitl.showShort("常用传感器");
                    Intent intent = new Intent(getContext(), Demo150100Activity.class);
                    startActivity(intent);

                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                } else if (childPosition == 3) {


                } else if (childPosition == 4) {


                }
                break;
            case 2:
                if (childPosition == 0) {
                    ToastUitl.showShort("指南针");
                    Intent intent = new Intent(getContext(), Demo150200Activity.class);
                    startActivity(intent);

                } else if (childPosition == 1) {
                    ToastUitl.showShort("水平仪");
                    Intent intent = new Intent(getContext(), Demo150201Activity.class);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }


    }

    private void initData() {
        mBeen = new ArrayList<>();
        String s = FileUtil.readFromAssets(getContext(), "chapter15.json");
        Gson gson = new Gson();
        CatalogBean catalogBean = gson.fromJson(s, CatalogBean.class);
        mBeen.clear();
        mBeen.addAll(catalogBean.getChapters());
    }
}
