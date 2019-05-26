package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.liushu.crazyandroid.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo020805Activity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.sv)
    SearchView mSv;
    @BindView(R.id.lv_test5)
    ListView mLvTest5;

    private String[] mStrings = {"aaaa", "bbbbbbbbb", "ccccccc"};

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020805;
    }

    @Override
    public void initView() {
        mTvTitle.setText("搜索");
        mLvTest5.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings));
        mLvTest5.setTextFilterEnabled(true);
        mSv.setIconifiedByDefault(false);
        mSv.setSubmitButtonEnabled(true);
        mSv.setQueryHint("查找");
        mSv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (TextUtils.isEmpty(query)) {
                    mLvTest5.clearTextFilter();
                } else {
                    mLvTest5.setFilterText(query);
                }

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ToastUitl.showShort("您选择的是：" + newText);
                return false;
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
