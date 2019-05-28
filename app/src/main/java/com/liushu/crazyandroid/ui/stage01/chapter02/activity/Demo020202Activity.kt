package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.TextView
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.head_title_layout.*
import java.util.*

class Demo020202Activity : BaseActivity() {


    private var currentColor = 0
    private val colors = intArrayOf(R.color.color01, R.color.color02, R.color.color03, R.color.color04, R.color.color05, R.color.color06)
    private val ids = intArrayOf(R.id.view01, R.id.view02, R.id.view03, R.id.view04, R.id.view05, R.id.view06)
    private val mTextViews = arrayOfNulls<TextView>(ids.size)
    private val mHandler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 100) {
                for (i in ids.indices) {
                    mTextViews[i]?.setBackgroundResource(colors[(i + currentColor) % colors.size])
                }
                currentColor++
            }
        }
    }

    override val layoutId: Int
        get() = R.layout.activity_demo020202


    override fun initView() {
        tv_title_name!!.text = "霓虹灯效果"
        for (i in ids.indices) {
            mTextViews[i] = findViewById<View>(ids[i]) as TextView
        }
        Timer().schedule(object : TimerTask() {
            override fun run() {
                mHandler.sendEmptyMessage(100)
            }
        }, 0, 400)
    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
