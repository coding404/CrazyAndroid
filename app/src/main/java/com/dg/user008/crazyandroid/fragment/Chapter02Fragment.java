package com.dg.user008.crazyandroid.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.dg.user008.crazyandroid.R;
import com.dg.user008.crazyandroid.activity.Demo020101Activity;
import com.dg.user008.crazyandroid.activity.Demo020102Activity;
import com.dg.user008.crazyandroid.activity.Demo020103Activity;
import com.dg.user008.crazyandroid.activity.Demo020201Activity;
import com.dg.user008.crazyandroid.activity.Demo020202Activity;
import com.dg.user008.crazyandroid.activity.Demo020203Activity;
import com.dg.user008.crazyandroid.activity.Demo020204Activity;
import com.dg.user008.crazyandroid.activity.Demo020205Activity;
import com.dg.user008.crazyandroid.activity.Demo020301Activity;
import com.dg.user008.crazyandroid.activity.Demo020302Activity;
import com.dg.user008.crazyandroid.activity.Demo020303Activity;
import com.dg.user008.crazyandroid.activity.Demo020304Activity;
import com.dg.user008.crazyandroid.activity.Demo020305Activity;
import com.dg.user008.crazyandroid.activity.Demo020306Activity;
import com.dg.user008.crazyandroid.activity.Demo020307Activity;
import com.dg.user008.crazyandroid.activity.FileUtil;
import com.dg.user008.crazyandroid.adapter.MyExpandableListViewAdapter;
import com.dg.user008.crazyandroid.bean.CatalogBean;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter02Fragment extends Fragment {

    private ExpandableListView mElv_chapter02;
    private MyExpandableListViewAdapter mViewAdapter;
    private List<CatalogBean.ChaptersBean> mBeen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chape02, null);
        mElv_chapter02 = (ExpandableListView) view.findViewById(R.id.expendlist_chapter02);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        mViewAdapter = new MyExpandableListViewAdapter(mBeen);
        mElv_chapter02.setAdapter(mViewAdapter);
        mElv_chapter02.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //界面跳转
                JumpActivity(groupPosition, childPosition);
                //  Toast.makeText(getContext(),"groupPosition="+groupPosition+",childPosition="+childPosition,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void JumpActivity(int groupPosition, int childPosition) {

        switch (groupPosition) {
            case 0:
                if (childPosition == 0) {
                    //用编程的方式开发UI界面
                    Intent intent0000 = new Intent(getContext(), Demo020101Activity.class);
                    startActivity(intent0000);

                } else if (childPosition == 1) {
                    //简单图片浏览器
                    Intent intent0001 = new Intent(getContext(), Demo020102Activity.class);
                    startActivity(intent0001);

                } else if (childPosition == 2) {
                    //跟随手指的小球
                    Intent intent0002 = new Intent(getContext(), Demo020103Activity.class);
                    startActivity(intent0002);

                }
                break;
            case 1:
                if (childPosition == 0) {
                    //丰富的表格布局
                    Intent intent0100 = new Intent(getContext(), Demo020201Activity.class);
                    startActivity(intent0100);

                } else if (childPosition == 1) {
                    //霓虹灯效果
                    Intent intent0101 = new Intent(getContext(), Demo020202Activity.class);
                    startActivity(intent0101);

                } else if (childPosition == 2) {
                    //梅花布局效果
                    Intent intent0102 = new Intent(getContext(), Demo020203Activity.class);
                    startActivity(intent0102);

                } else if (childPosition == 3) {
                    //计算器界面
                    Intent intent0103 = new Intent(getContext(), Demo020204Activity.class);
                    startActivity(intent0103);


                } else if (childPosition == 4) {
                    //登录界面
                    Intent intent0104 = new Intent(getContext(), Demo020205Activity.class);
                    startActivity(intent0104);

                }
                break;
            case 2:
                if (childPosition == 0) {
                    //不同颜色、字体、带链接的文本
                    Intent intent0200 = new Intent(getContext(), Demo020301Activity.class);
                    startActivity(intent0200);

                } else if (childPosition == 1) {
                    //圆角边框、渐变背景的textview
                    Intent intent0201 = new Intent(getContext(), Demo020302Activity.class);
                    startActivity(intent0201);
                } else if (childPosition == 2) {
                    //用户友好的输入界面
                    Intent intent0202 = new Intent(getContext(), Demo020303Activity.class);
                    startActivity(intent0202);
                } else if (childPosition == 3) {
                    //按钮，圆形按钮，带文字的图片按钮
                    Intent intent0203 = new Intent(getContext(), Demo020304Activity.class);
                    startActivity(intent0203);
                } else if (childPosition == 4) {
                    //利用单选框，复选框获取用户信息
                    Intent intent0204 = new Intent(getContext(), Demo020305Activity.class);
                    startActivity(intent0204);
                } else if (childPosition == 5) {
                    //动态控制布局
                    Intent intent0205 = new Intent(getContext(), Demo020306Activity.class);
                    startActivity(intent0205);
                } else if (childPosition == 6) {
                    //手机里的“劳力士”
                    Intent intent0206=new Intent(getContext(), Demo020307Activity.class);
                    startActivity(intent0206);
                }
                break;
            case 3:
                if (childPosition == 0) {


                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                }
                break;
            case 4:
                if (childPosition == 0) {


                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                } else if (childPosition == 3) {


                } else if (childPosition == 4) {


                } else if (childPosition == 5) {


                } else if (childPosition == 6) {


                } else if (childPosition == 7) {


                } else if (childPosition == 8) {


                }
                break;
            case 5:
                if (childPosition == 0) {


                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                }
                break;
            case 6:
                if (childPosition == 0) {


                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                }
                break;
            case 7:
                if (childPosition == 0) {


                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                } else if (childPosition == 3) {


                } else if (childPosition == 4) {


                } else if (childPosition == 5) {


                } else if (childPosition == 6) {


                } else if (childPosition == 7) {


                }
                break;
            case 8:
                if (childPosition == 0) {


                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                } else if (childPosition == 3) {


                } else if (childPosition == 4) {


                } else if (childPosition == 5) {


                }
                break;
            case 9:
                if (childPosition == 0) {


                }
                break;
            case 10:
                if (childPosition == 0) {


                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                } else if (childPosition == 3) {


                }
                break;
            default:
                break;
        }


    }

    private void initData() {
        mBeen = new ArrayList<>();
        String s = FileUtil.readFromAssets(getContext(), "chapter02.txt");
        Gson gson = new Gson();
        CatalogBean catalogBean = gson.fromJson(s, CatalogBean.class);
        mBeen.clear();
        mBeen.addAll(catalogBean.getChapters());
    }
}
