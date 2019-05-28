package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.include_simple_title.*

class Demo020902Activity : BaseActivity() {


    override val layoutId: Int
        get() = R.layout.activity_demo020902


    override fun initView() {
        tv_title.text="dialogfragment的使用方法"
        // TODO: 2018/2/24 dialogFragment未完成
    }

    @OnClick(R.id.iv_back)
    fun onViewClicked() {
        finish()
    }
}
