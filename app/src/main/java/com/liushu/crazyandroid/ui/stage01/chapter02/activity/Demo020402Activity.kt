package com.liushu.crazyandroid.ui.stage01.chapter02.activity


import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020402Activity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_demo020402

    override fun initView() {
        tv_title_name!!.text = "强大的图片按钮"
    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
