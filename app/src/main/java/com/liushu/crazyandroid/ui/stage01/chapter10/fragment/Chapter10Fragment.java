package com.liushu.crazyandroid.ui.stage01.chapter10.fragment;

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
import com.liushu.crazyandroid.ui.stage01.chapter10.activity.Demo100000Activity;
import com.liushu.crazyandroid.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter10Fragment extends BaseFragment {
    @Bind(R.id.expendlist_chapter10)
    ExpandableListView mElv_chapter10;
    private MyExpandableListViewAdapter mViewAdapter;
    private List<CatalogBean.ChaptersBean> mBeen;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_chape10;
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
        mElv_chapter10.setAdapter(mViewAdapter);
        mElv_chapter10.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //界面跳转
                JumpActivity(groupPosition, childPosition);
                // Toast.makeText(getContext(), "groupPosition=" + groupPosition + ",childPosition=" + childPosition, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void JumpActivity(int groupPosition, int childPosition) {

        switch (groupPosition) {
            case 0:
                if (childPosition == 0) {
                    //绑定本地service并与之通信
                    Intent intent = new Intent(getContext(), Demo100000Activity.class);
                    startActivity(intent);

                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                }
                break;
            case 1:
                if (childPosition == 0) {
                    //获取网络和SIM卡信息
                    // TODO: 2017/6/5  获取网络和SIM卡信息
                    ToastUitl.showShort("获取网络和SIM卡信息");
                   /* Intent intent = new Intent(getContext(), Demo100100Activity.class);
                    startActivity(intent);*/
                } else if (childPosition == 1) {
                    // TODO: 2017/6/5  监听手机来电
                    ToastUitl.showShort("监听手机来电");
                    /*Intent intent = new Intent(getContext(), Demo100101Activity.class);
                    startActivity(intent);*/

                }
                break;
            case 2:
                if (childPosition == 0) {
                    ToastUitl.showShort("发送短信");
                    // TODO: 2017/6/5  发送短信
                  /*  Intent intent = new Intent(getContext(), Demo100200Activity.class);
                    startActivity(intent);*/

                } else if (childPosition == 1) {
                    ToastUitl.showShort("短信群发");
                    // TODO: 2017/6/5  短信群发
                   /* Intent intent = new Intent(getContext(), Demo100201Activity.class);
                    startActivity(intent);*/

                }
                break;
            case 3:
                if (childPosition == 0) {
                    ToastUitl.showShort("使用AudioManager控制手机音频");
                    // TODO: 2017/6/5  使用AudioManager控制手机音频
                    /*Intent intent = new Intent(getContext(), Demo100300Activity.class);
                    startActivity(intent);*/

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
                    ToastUitl.showShort("定时更换壁纸");
                    // TODO: 2017/6/5  定时更换壁纸
                    /*Intent intent = new Intent(getContext(), Demo100500Activity.class);
                    startActivity(intent);*/


                }
                break;
            case 6:
                if (childPosition == 0) {
                    ToastUitl.showShort("基于service的音乐播放器");
                    // TODO: 2017/6/5  基于service的音乐播放器
                   /* Intent intent = new Intent(getContext(), Demo100600Activity.class);
                    startActivity(intent);*/

                }
                break;
            case 7:
                if (childPosition == 0) {
                    ToastUitl.showShort("开机自动运行的service");
                    // TODO: 2017/6/5 开机自动运行的service
                    /*Intent intent = new Intent(getContext(), Demo100700Activity.class);
                    startActivity(intent);*/

                } else if (childPosition == 1) {
                    ToastUitl.showShort("短信提醒");
                    // TODO: 2017/6/5 短信提醒
                   /* Intent intent = new Intent(getContext(), Demo100701Activity.class);
                    startActivity(intent);*/

                } else if (childPosition == 2) {
                    ToastUitl.showShort("手机电量提示");
                    // TODO: 2017/6/5 手机电量提示
                   /* Intent intent = new Intent(getContext(), Demo100702Activity.class);
                    startActivity(intent);*/

                }
                break;
            default:
                break;
        }


    }

    private void initData() {
        mBeen = new ArrayList<>();
        String s = FileUtil.readFromAssets(getContext(), "chapter10.txt");
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
