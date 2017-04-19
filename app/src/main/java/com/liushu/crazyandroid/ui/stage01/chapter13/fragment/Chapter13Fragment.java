package com.liushu.crazyandroid.ui.stage01.chapter13.fragment;

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
import com.liushu.crazyandroid.ui.stage01.chapter13.activity.Demo130200Activity;
import com.liushu.crazyandroid.ui.stage01.chapter13.activity.Demo130201Activity;
import com.liushu.crazyandroid.ui.stage01.chapter13.activity.Demo130300Activity;
import com.liushu.crazyandroid.ui.stage01.chapter13.activity.Demo130400Activity;
import com.liushu.crazyandroid.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter13Fragment extends Fragment {
    private ExpandableListView mElv_chapter13;
    private MyExpandableListViewAdapter mViewAdapter;
    private List<CatalogBean.ChaptersBean> mBeen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chape13, null);
        mElv_chapter13 = (ExpandableListView) view.findViewById(R.id.expendlist_chapter13);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        mViewAdapter = new MyExpandableListViewAdapter(mBeen);
        mElv_chapter13.setAdapter(mViewAdapter);
        mElv_chapter13.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //界面跳转
                JumpActivity(groupPosition,childPosition);
                //Toast.makeText(getContext(),"groupPosition="+groupPosition+",childPosition="+childPosition,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void JumpActivity(int groupPosition, int childPosition) {

        switch (groupPosition){
            case 0:
                if (childPosition==0){


                }else if (childPosition==1){


                }else if(childPosition==2){


                }
                break;
            case 1:
                if (childPosition==0){


                }else if (childPosition==1){


                }else if(childPosition==2){


                }else if (childPosition==3){


                }else if (childPosition==4){


                }
                break;
            case 2:
                if (childPosition==0){
                    ToastUitl.showShort("多线程下载");
                    Intent intent=new Intent(getContext(), Demo130200Activity.class);
                    startActivity(intent);
                }else if (childPosition==1){
                    ToastUitl.showShort("访问被保护资源");
                    Intent intent=new Intent(getContext(), Demo130201Activity.class);
                    startActivity(intent);

                }
                break;
            case 3:
                if (childPosition==0){
                    ToastUitl.showShort("迷你浏览器");
                    Intent intent=new Intent(getContext(), Demo130300Activity.class);
                    startActivity(intent);
                }
                break;
            case 4:
                if (childPosition==0){
                    ToastUitl.showShort("调用基于CXF的webService");
                    Intent intent=new Intent(getContext(), Demo130400Activity.class);
                    startActivity(intent);

                }
                break;
            default:
                break;
        }




    }

    private void initData() {
        mBeen = new ArrayList<>();
        String s = FileUtil.readFromAssets(getContext(), "chapter13.txt");
        Gson gson=new Gson();
        CatalogBean catalogBean = gson.fromJson(s, CatalogBean.class);
        mBeen.clear();
        mBeen.addAll(catalogBean.getChapters());
    }
}