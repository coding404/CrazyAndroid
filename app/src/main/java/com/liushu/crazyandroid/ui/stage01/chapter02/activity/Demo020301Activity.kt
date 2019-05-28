package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020301Activity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_demo020301

    override fun initView() {
        tv_title_name!!.text = "不同颜色、字体、带链接的文本"
    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
