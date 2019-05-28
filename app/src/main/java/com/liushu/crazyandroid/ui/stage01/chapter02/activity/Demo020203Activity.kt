package com.liushu.crazyandroid.ui.stage01.chapter02.activity


import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020203Activity : BaseActivity() {


    override val layoutId: Int
        get() = R.layout.activity_demo020203


    override fun initView() {
        tv_title_name!!.text = "梅花布局效果"
    }


    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
