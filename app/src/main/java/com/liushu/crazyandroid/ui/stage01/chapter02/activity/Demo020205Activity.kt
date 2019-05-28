package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020205Activity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_demo020205


    override fun initView() {
        tv_title_name!!.text = "登录界面"

    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }

    /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
    }*/
}
