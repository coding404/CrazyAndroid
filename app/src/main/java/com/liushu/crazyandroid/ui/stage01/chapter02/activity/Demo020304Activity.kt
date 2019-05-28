package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020304Activity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_demo020304

    override fun initView() {
        tv_title_name!!.text = "按钮，圆形按钮，带文字的图片按钮"
    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
