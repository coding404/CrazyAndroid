package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020303Activity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_demo020303


    override fun initView() {
        tv_title_name!!.text = "用户友好的输入界面"
    }


    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
