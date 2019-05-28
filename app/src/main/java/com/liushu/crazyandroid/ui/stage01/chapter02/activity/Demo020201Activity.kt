package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020201Activity : BaseActivity() {


    override val layoutId: Int
        get() = R.layout.activity_demo020201


    override fun initView() {
        tv_title_name!!.text = "丰富的表格布局"
        iv_back!!.setOnClickListener { finish() }
    }
}
