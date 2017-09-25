package com.liushu.crazyandroid.ui.stage01.chapter14.fragment;

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
import com.liushu.crazyandroid.ui.stage01.chapter14.activity.Demo140100Activity;
import com.liushu.crazyandroid.ui.stage01.chapter14.activity.Demo140200Activity;
import com.liushu.crazyandroid.ui.stage01.chapter14.activity.Demo140300Activity;
import com.liushu.crazyandroid.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter14Fragment extends BaseFragment {
    @Bind(R.id.expendlist_chapter14)
    ExpandableListView mElv_chapter14;
    private MyExpandableListViewAdapter mViewAdapter;
    private List<CatalogBean.ChaptersBean> mBeen;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_chape14;
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
        mElv_chapter14.setAdapter(mViewAdapter);
        mElv_chapter14.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
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

                    ToastUitl.showShort("蜿蜒壁纸");
                    Intent intent = new Intent(getContext(), Demo140100Activity.class);
                    startActivity(intent);
                }
                break;
            case 2:
                if (childPosition == 0) {
                    ToastUitl.showShort("让程序占领桌面");
                    Intent intent = new Intent(getContext(), Demo140200Activity.class);
                    startActivity(intent);

                }
                break;
            case 3:
                if (childPosition == 0) {

                    ToastUitl.showShort("液晶时钟");
                    Intent intent = new Intent(getContext(), Demo140300Activity.class);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }


    }

    private void initData() {
        mBeen = new ArrayList<>();
        String s = FileUtil.readFromAssets(getContext(), "chapter14.json");
        Gson gson = new Gson();
        CatalogBean catalogBean = gson.fromJson(s, CatalogBean.class);
        mBeen.clear();
        mBeen.addAll(catalogBean.getChapters());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
