package com.dg.user008.crazyandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.dg.user008.crazyandroid.R;
import com.dg.user008.crazyandroid.activity.FileUtil;
import com.dg.user008.crazyandroid.adapter.MyExpandableListViewAdapter;
import com.dg.user008.crazyandroid.bean.CatalogBean;
import com.google.gson.Gson;

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
                //  JumpActivity(groupPosition,childPosition);
                Toast.makeText(getContext(),"groupPosition="+groupPosition+",childPosition="+childPosition,Toast.LENGTH_SHORT).show();
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


                }else if (childPosition==1){


                }else if(childPosition==2){


                }else if (childPosition==3) {


                }else if (childPosition==4){


                }else if (childPosition==5){


                }else if (childPosition==6){


                }
                break;
            case 3:
                if (childPosition==0){


                }else if (childPosition==1){


                }else if(childPosition==2){


                }
                break;
            case 4:
                if (childPosition==0){


                }else if (childPosition==1){


                }else if(childPosition==2){


                }else if (childPosition==3) {


                }else if (childPosition==4){


                }else if (childPosition==5){


                }else if (childPosition==6){


                }else if (childPosition==7){


                }else if (childPosition==8){


                }
                break;
            case 5:
                if (childPosition==0){


                }else if (childPosition==1){


                }else if(childPosition==2){


                }
                break;
            case 6:
                if (childPosition==0){


                }else if (childPosition==1){


                }else if(childPosition==2){


                }
                break;
            case 7:
                if (childPosition==0){


                }else if (childPosition==1){


                }else if(childPosition==2){


                }else if (childPosition==3) {


                }else if (childPosition==4){


                }else if (childPosition==5){


                }else if (childPosition==6){


                }else if (childPosition==7){


                }
                break;
            case 8:
                if (childPosition==0){


                }else if (childPosition==1){


                }else if(childPosition==2){


                }else if (childPosition==3) {


                }else if (childPosition==4){


                }else if (childPosition==5){


                }
                break;
            case 9:
                if (childPosition==0){


                }
                break;
            case 10:
                if (childPosition==0){


                }else if (childPosition==1){


                }else if(childPosition==2){


                }else if (childPosition==3) {


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
