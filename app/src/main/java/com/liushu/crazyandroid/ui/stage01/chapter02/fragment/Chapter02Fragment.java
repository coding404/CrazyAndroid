package com.liushu.crazyandroid.ui.stage01.chapter02.fragment;

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
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020101Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020102Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020103Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020201Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020202Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020203Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020204Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020205Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020301Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020302Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020303Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020304Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020305Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020306Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020307Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020401Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020402Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020403Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020501Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020502Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020503Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020504Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020505Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020506Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020507Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020508Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020509Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020600Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020700Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020800Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo020900Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo021000Activity;
import com.liushu.crazyandroid.ui.stage01.chapter02.activity.Demo021100Activity;
import com.liushu.crazyandroid.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter02Fragment extends BaseFragment {

    @Bind(R.id.expendlist_chapter02)
    ExpandableListView mExpendlistChapter02;
    private MyExpandableListViewAdapter mViewAdapter;
    private List<CatalogBean.ChaptersBean> mBeen;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_chape02;
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
        mExpendlistChapter02.setAdapter(mViewAdapter);
        mExpendlistChapter02.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
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
                    Intent intent0206 = new Intent(getContext(), Demo020307Activity.class);
                    startActivity(intent0206);
                }
                break;
            case 3:
                if (childPosition == 0) {
                    //图片浏览器
                    Intent intent0300 = new Intent(getContext(), Demo020401Activity.class);
                    startActivity(intent0300);

                } else if (childPosition == 1) {
                    //强大的图片按钮
                    Intent intent0301 = new Intent(getContext(), Demo020402Activity.class);
                    startActivity(intent0301);

                } else if (childPosition == 2) {
                    //使用QuickContactBadge关联联系人
                    Intent intent0302 = new Intent(getContext(), Demo020403Activity.class);
                    startActivity(intent0302);
                }
                break;
            case 4:
                if (childPosition == 0) {
                    //改变分隔条，基于数组的ListView
                    Intent intent0400 = new Intent(getContext(), Demo020501Activity.class);
                    startActivity(intent0400);

                } else if (childPosition == 1) {
                    //使用ArrayAdapter创建ListView
                    Intent intent0401 = new Intent(getContext(), Demo020502Activity.class);
                    startActivity(intent0401);

                } else if (childPosition == 2) {
                    //基于ListActivity实现列表
                    Intent intent0402 = new Intent(getContext(), Demo020503Activity.class);
                    startActivity(intent0402);

                } else if (childPosition == 3) {
                    //使用SimpleAdapter创建ListView
                    Intent intent0403 = new Intent(getContext(), Demo020504Activity.class);
                    startActivity(intent0403);

                } else if (childPosition == 4) {
                    //扩建BasseAdapter实现不存储列表项的ListView
                    Intent intent0404 = new Intent(getContext(), Demo020505Activity.class);
                    startActivity(intent0404);

                } else if (childPosition == 5) {
                    //带预览的图片浏览器
                    Intent intent0405 = new Intent(getContext(), Demo020506Activity.class);
                    startActivity(intent0405);

                } else if (childPosition == 6) {
                    //让用户选择
                    Intent intent0406 = new Intent(getContext(), Demo020507Activity.class);
                    startActivity(intent0406);

                } else if (childPosition == 7) {
                    //自动播放的图片库
                    Intent intent0407 = new Intent(getContext(), Demo020508Activity.class);
                    startActivity(intent0407);


                } else if (childPosition == 8) {
                    //叠在一起的图片
                    Intent intent0408 = new Intent(getContext(), Demo020509Activity.class);
                    startActivity(intent0408);

                }
                break;
            case 5:
                //ProgressBar及其子类
                // TODO: 2017/6/2 功能分开写
                Intent intent0500 = new Intent(getContext(), Demo020600Activity.class);
                intent0500.putExtra("groupPosition", groupPosition);
                intent0500.putExtra("childPosition", childPosition);
                startActivity(intent0500);


                break;
            case 6:
                //ViewAnimator及其子类
                // TODO: 2017/6/2 功能分开写
                Intent intent0600 = new Intent(getContext(), Demo020700Activity.class);
                intent0600.putExtra("groupPosition", groupPosition);
                intent0600.putExtra("childPosition", childPosition);
                startActivity(intent0600);
                break;
            case 7:
                //各种杂项组件
                // TODO: 2017/6/2 功能分开写
                Intent intent0700 = new Intent(getContext(), Demo020800Activity.class);
                intent0700.putExtra("groupPosition", groupPosition);
                intent0700.putExtra("childPosition", childPosition);
                startActivity(intent0700);

               /* if (childPosition == 0) {
                    //带图片的消息提示
                    Intent intent0200 = new Intent(getContext(), Demo020801Activity.class);
                    startActivity(intent0200);
                } else if (childPosition == 1) {
                    //选择您的生日
                    Intent intent0201 = new Intent(getContext(), Demo020802Activity.class);
                    startActivity(intent0201);
                } else if (childPosition == 2) {
                    //用户选择日期、时间
                    Intent intent0202 = new Intent(getContext(), Demo020803Activity.class);
                    startActivity(intent0202);
                } else if (childPosition == 3) {
                    //选择您意向的价格范围
                    Intent intent0203 = new Intent(getContext(), Demo020804Activity.class);
                    startActivity(intent0203);
                } else if (childPosition == 4) {
                    //搜索
                    Intent intent0204 = new Intent(getContext(), Demo020805Activity.class);
                    startActivity(intent0204);
                } else if (childPosition == 5) {
                    //通话记录界面
                    Intent intent0205 = new Intent(getContext(), Demo020806Activity.class);
                    startActivity(intent0205);
                } else if (childPosition == 6) {
                    //可垂直和水平滚动的视图
                    Intent intent0206 = new Intent(getContext(), Demo020807Activity.class);
                    startActivity(intent0206);
                } else if (childPosition == 7) {
                    //加薪通知
                    Intent intent0206 = new Intent(getContext(), Demo020808Activity.class);
                    startActivity(intent0206);
                }*/
                break;
            case 8:
                //UI组件，对话框
                // TODO: 2017/6/2 功能分开写
                Intent intent0800 = new Intent(getContext(), Demo020900Activity.class);
                intent0800.putExtra("groupPosition", groupPosition);
                intent0800.putExtra("childPosition", childPosition);
                startActivity(intent0800);
                break;
            case 9:
                //菜单
                // TODO: 2017/6/2 功能分开写
                Intent intent0900 = new Intent(getContext(), Demo021000Activity.class);
                intent0900.putExtra("groupPosition", groupPosition);
                intent0900.putExtra("childPosition", childPosition);
                startActivity(intent0900);
                break;
            case 10:
                //使用活动条（ActionBar）
                // TODO: 2017/6/2 功能分开写
                Intent intent1000 = new Intent(getContext(), Demo021100Activity.class);
                intent1000.putExtra("groupPosition", groupPosition);
                intent1000.putExtra("childPosition", childPosition);
                startActivity(intent1000);
                break;
            default:
                break;
        }


    }

    private void initData() {
        mBeen = new ArrayList<>();
        String s = FileUtil.readFromAssets(getContext(), "chapter02.json");
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
