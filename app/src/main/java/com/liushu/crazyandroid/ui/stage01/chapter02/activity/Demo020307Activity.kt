package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.os.SystemClock
import android.widget.Chronometer
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020307.*
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020307Activity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_demo020307


    override fun initView() {
        tv_title_name!!.text = "手机里的“劳力士”"
        btn_test!!.setOnClickListener {
            chronometer_test!!.base = SystemClock.elapsedRealtime()
            chronometer_test!!.start()
            btn_test!!.isClickable = false
        }
        chronometer_test!!.onChronometerTickListener = Chronometer.OnChronometerTickListener { chronometer ->
            if (SystemClock.elapsedRealtime() - chronometer.base > 20 * 1000) {
                chronometer_test!!.stop()
                btn_test!!.isClickable = true
            }
        }
    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
