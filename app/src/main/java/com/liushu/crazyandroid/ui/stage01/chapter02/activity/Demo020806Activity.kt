package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.include_simple_title.*

class Demo020806Activity : BaseActivity() {


    override val layoutId: Int
        get() = R.layout.activity_demo020806

    override fun initView() {
        tv_title!!.text = "可垂直和水平滚动的视图"
    }

    @OnClick(R.id.iv_back)
    fun onViewClicked() {
        finish()
    }
}
