package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.widget.ArrayAdapter
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020502.*
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020502Activity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_demo020502


    override fun initView() {
        tv_title_name!!.text = "使用ArrayAdapter创建ListView"
        val attrs = arrayOf("111", "222", "333", "444")
        val adapter01 = ArrayAdapter(this@Demo020502Activity, R.layout.array_item, attrs)
        lv_num01!!.adapter = adapter01
        val attrs2 = arrayOf("122", "2212", "3313", "4414")
        val adapter02 = ArrayAdapter(this@Demo020502Activity, R.layout.check_item, attrs2)
        lv_num02!!.adapter = adapter02
    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
