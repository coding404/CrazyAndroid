package com.liushu.crazyandroid.ui.stage01.chapter06.fragment;

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
import com.liushu.crazyandroid.ui.stage01.chapter06.activity.Demo060401Activity;
import com.liushu.crazyandroid.ui.stage01.chapter06.activity.Demo060402Activity;
import com.liushu.crazyandroid.ui.stage01.chapter06.activity.Demo060403Activity;
import com.liushu.crazyandroid.ui.stage01.chapter06.activity.Demo060404Activity;
import com.liushu.crazyandroid.ui.stage01.chapter06.activity.Demo060501Activity;
import com.liushu.crazyandroid.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter06Fragment extends BaseFragment {
    @Bind(R.id.expendlist_chapter06)
    ExpandableListView mElv_chapter06;
    private MyExpandableListViewAdapter mViewAdapter;
    private List<CatalogBean.ChaptersBean> mBeen;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_chape06;
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
        mElv_chapter06.setAdapter(mViewAdapter);
        mElv_chapter06.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
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

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:
                if (childPosition == 0) {
                    //ToastUitl.showShort("高亮显示正在输入的文本框");
                    Intent intent = new Intent(mContext, Demo060401Activity.class);
                    startActivity(intent);
                } else if (childPosition == 1) {
                    //  ToastUitl.showShort("定制拖动条的外观");
                    Intent intent = new Intent(mContext, Demo060402Activity.class);
                    startActivity(intent);
                } else if (childPosition == 2) {
                    // ToastUitl.showShort("椭圆形渐变背景的文本框");
                    Intent intent = new Intent(mContext, Demo060403Activity.class);
                    startActivity(intent);
                } else if (childPosition == 3) {
                    //  ToastUitl.showShort("徐徐展开的风景");
                    Intent intent = new Intent(mContext, Demo060404Activity.class);
                    startActivity(intent);
                }
                break;
            case 4:
                if (childPosition == 0) {
                    //ToastUitl.showShort("不断渐变的背景色");
                    Intent intent= new Intent(mContext, Demo060501Activity.class);
                    startActivity(intent);

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
        String s = FileUtil.readFromAssets(getContext(), "chapter06.json");
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
