package com.liushu.crazyandroid.ui.stage01.chapter11.fragment;

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
import com.liushu.crazyandroid.ui.stage01.chapter11.activity.Demo110000Activity;
import com.liushu.crazyandroid.ui.stage01.chapter11.activity.Demo110001Activity;
import com.liushu.crazyandroid.ui.stage01.chapter11.activity.Demo110100Activity;
import com.liushu.crazyandroid.ui.stage01.chapter11.activity.Demo110200Activity;
import com.liushu.crazyandroid.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter11Fragment extends BaseFragment {
    @Bind(R.id.expendlist_chapter11)
    ExpandableListView mElv_chapter11;
    private MyExpandableListViewAdapter mViewAdapter;
    private List<CatalogBean.ChaptersBean> mBeen;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_chape11;
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
        mElv_chapter11.setAdapter(mViewAdapter);
        mElv_chapter11.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //界面跳转
                JumpActivity(groupPosition, childPosition);
                // Toast.makeText(getContext(),"groupPosition="+groupPosition+",childPosition="+childPosition,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void JumpActivity(int groupPosition, int childPosition) {

        switch (groupPosition) {
            case 0:
                if (childPosition == 0) {
                    //ToastUitl.showShort("音乐的示波器、均衡、重低音和音场");
                    // TODO: 2017/6/5 更换基类
                    Intent intent = new Intent(getContext(), Demo110000Activity.class);
                    startActivity(intent);

                } else if (childPosition == 1) {
                    //ToastUitl.showShort("使用soundPool播放音乐");
                    Intent intent = new Intent(getContext(), Demo110001Activity.class);
                    startActivity(intent);

                } else if (childPosition == 2) {
                    ToastUitl.showShort("待完成");
                    // TODO: 2017/5/31 使用videoView播放视频

                } else if (childPosition == 3) {
                    ToastUitl.showShort("待完成");
                    // TODO: 2017/5/31 使用mediaPlay和surfaceView播放视频
                }
                break;
            case 1:
                if (childPosition == 0) {
                    ToastUitl.showShort("录制音乐");
                    // TODO: 2017/5/31 录音绘制波形 http://blog.csdn.net/chenzhuo1100/article/details/50673139
                    Intent intent = new Intent(getContext(), Demo110100Activity.class);
                    startActivity(intent);

                }
                break;
            case 2:
                if (childPosition == 0) {
                    //  ToastUitl.showShort("拍照时自动对焦");
                    Intent intent = new Intent(getContext(), Demo110200Activity.class);
                    startActivity(intent);

                } else if (childPosition == 1) {
                    ToastUitl.showShort("录制生活短片");
                    // TODO: 2017/6/5  录制生活短片
                   /* Intent intent = new Intent(getContext(), Demo110201Activity.class);
                    startActivity(intent);*/

                }
                break;
            case 3:
                if (childPosition == 0) {


                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                }
                break;
            default:
                break;
        }


    }

    private void initData() {
        mBeen = new ArrayList<>();
        String s = FileUtil.readFromAssets(getContext(), "chapter11.json");
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
