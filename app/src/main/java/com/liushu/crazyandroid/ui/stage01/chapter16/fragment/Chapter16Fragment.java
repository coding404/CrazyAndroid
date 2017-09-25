package com.liushu.crazyandroid.ui.stage01.chapter16.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ExpandableListView;

import com.google.gson.Gson;
import com.jaydenxiao.common.base.BaseFragment;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.adapter.MyExpandableListViewAdapter;
import com.liushu.crazyandroid.bean.CatalogBean;
import com.liushu.crazyandroid.ui.stage01.chapter16.activity.Demo160100Activity;
import com.liushu.crazyandroid.ui.stage01.chapter16.activity.Demo160101Activity;
import com.liushu.crazyandroid.ui.stage01.chapter16.activity.Demo160200Activity;
import com.liushu.crazyandroid.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter16Fragment extends BaseFragment {
    @Bind(R.id.expendlist_chapter16)
    ExpandableListView mElv_chapter16;
    private MyExpandableListViewAdapter mViewAdapter;
    private List<CatalogBean.ChaptersBean> mBeen;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_chape16;
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
        mElv_chapter16.setAdapter(mViewAdapter);
        mElv_chapter16.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
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

                    //ToastUitl.showShort("获取所有可用的LocationProvider");
                    Intent intent = new Intent(getContext(), Demo160100Activity.class);
                    startActivity(intent);
                } else if (childPosition == 1) {

                    //ToastUitl.showShort("根据Criteria获得LocationProvider");
                    Intent intent = new Intent(getContext(), Demo160101Activity.class);
                    startActivity(intent);

                }
                break;
            case 2:
                if (childPosition == 0) {
//ToastUitl.showShort("获取定位数据");
                    Intent intent = new Intent(getContext(), Demo160200Activity.class);
                    startActivity(intent);

                } else if (childPosition == 1) {


                } else if (childPosition == 2) {


                } else if (childPosition == 3) {


                } else if (childPosition == 4) {


                } else if (childPosition == 5) {


                } else if (childPosition == 6) {


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
        String s = FileUtil.readFromAssets(getContext(), "chapter16.json");
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
