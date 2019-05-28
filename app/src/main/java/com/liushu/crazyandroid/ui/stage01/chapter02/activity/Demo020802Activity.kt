package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.jaydenxiao.common.commonutils.ToastUitl
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020802.*
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020802Activity : BaseActivity() {


    override val layoutId: Int
        get() = R.layout.activity_demo020802


    override fun initView() {
        tv_title_name!!.text = "选择您的生日"
        calend_view!!.setOnDateChangeListener { view, year, month, dayOfMonth -> ToastUitl.showShort("您的生日是：" + year + "年" + month + "月" + dayOfMonth + "日") }
    }


    @OnClick(R.id.iv_back)
    fun onViewClicked() {
        finish()
    }
}
