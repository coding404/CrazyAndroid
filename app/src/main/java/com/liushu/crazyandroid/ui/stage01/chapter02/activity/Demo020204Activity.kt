package com.liushu.crazyandroid.ui.stage01.chapter02.activity


import android.view.Gravity
import android.widget.Button
import android.widget.GridLayout
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020204.*
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020204Activity : BaseActivity() {

    private val mStrings = arrayOf("7", "8", "9", "÷", "4", "5", "6", "*", "1", "2", "3", "-", ".", "0", "=", "+")

    override val layoutId: Int
        get() = R.layout.activity_demo020204


    override fun initView() {
        tv_title_name!!.text = "计算器界面"
        for (i in mStrings.indices) {
            val button = Button(this)
            button.text = mStrings[i]
            button.textSize = 40f
            button.setPadding(5, 35, 5, 35)
            val rawSpec = GridLayout.spec(i / 4 + 2)
            val columnSpec = GridLayout.spec(i % 4)
            val params = GridLayout.LayoutParams(rawSpec, columnSpec)
            params.setGravity(Gravity.FILL)
            gl_test!!.addView(button, params)

        }
    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
