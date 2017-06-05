package com.liushu.crazyandroid.ui.stage01.chapter09.fragment;

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
import com.liushu.crazyandroid.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter09Fragment extends BaseFragment {

    @Bind(R.id.expendlist_chapter09)
    ExpandableListView mElv_chapter09;
    private MyExpandableListViewAdapter mViewAdapter;
    private List<CatalogBean.ChaptersBean> mBeen;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_chape09;
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
        mElv_chapter09.setAdapter(mViewAdapter);
        mElv_chapter09.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
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
                    //使用contentProvider共享生词本数据
                    // TODO: 2017/6/5  使用contentProvider共享生词本数据
                    ToastUitl.showShort("使用contentProvider共享生词本数据");
                   /* Intent intent = new Intent(getContext(), Demo090100Activity.class);
                    startActivity(intent);*/

                }
                break;
            case 2:
                if (childPosition == 0) {


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
                    //监听用户发出的短信
                    // TODO: 2017/6/5  监听用户发出的短信
                    ToastUitl.showShort("监听用户发出的短信");
                  /*  Intent intent = new Intent(getContext(), Demo090300Activity.class);
                    startActivity(intent);
*/
                }
                break;
            default:
                break;
        }


    }

    private void initData() {
        mBeen = new ArrayList<>();
        String s = FileUtil.readFromAssets(getContext(), "chapter09.txt");
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
