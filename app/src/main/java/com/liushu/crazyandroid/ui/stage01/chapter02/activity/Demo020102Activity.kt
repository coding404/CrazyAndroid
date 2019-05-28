package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import com.jaydenxiao.common.base.BaseMvpActivity
import com.liushu.crazyandroid.R
import com.liushu.crazyandroid.ui.stage01.DemoModel
import com.liushu.crazyandroid.ui.stage01.DemoPresenter
import kotlinx.android.synthetic.main.activity_demo020102.*
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020102Activity : BaseMvpActivity<DemoPresenter, DemoModel>() {


    private val images = intArrayOf(R.drawable.back1, R.mipmap.ic_launcher, R.drawable.back1)
    private var currentImg = 0

    override val layoutId: Int
        get() = R.layout.activity_demo020102

    override fun initView() {
        tv_title_name!!.text = "简单图片浏览器"
        iv_back!!.setOnClickListener { finish() }

        iv_test!!.setImageResource(images[0])
        iv_test!!.setOnClickListener { iv_test!!.setImageResource(images[++currentImg % images.size]) }
    }

    override fun initPresenter() {

    }

    override fun initMvpView() {

    }
}
