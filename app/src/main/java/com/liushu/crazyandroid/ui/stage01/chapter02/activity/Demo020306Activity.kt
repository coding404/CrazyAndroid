package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.widget.CompoundButton
import android.widget.LinearLayout
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020306.*
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020306Activity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_demo020306

    override fun initView() {
        tv_title_name!!.text = "动态控制布局"
        val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                switch_test!!.isChecked = true
                tb_test!!.isChecked = true
                ll_test!!.orientation = LinearLayout.VERTICAL
            } else {
                switch_test!!.isChecked = false
                tb_test!!.isChecked = false
                ll_test!!.orientation = LinearLayout.HORIZONTAL
            }
        }
        switch_test!!.setOnCheckedChangeListener(listener)
        tb_test!!.setOnCheckedChangeListener(listener)
    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
