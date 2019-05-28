package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.view.View
import android.widget.SimpleAdapter
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020509.*
import kotlinx.android.synthetic.main.head_title_layout.*
import java.util.*

class Demo020509Activity : BaseActivity() {

    private val mInts = intArrayOf(R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7, R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10, R.drawable.bomb11, R.drawable.bomb12, R.drawable.bomb13, R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16)

    override val layoutId: Int
        get() = R.layout.activity_demo020509

    override fun initView() {
        tv_title_name!!.text = "叠在一起的图片"
        val list = ArrayList<Map<String, Any>>()
        for (i in mInts.indices) {
            val map = HashMap<String, Any>()
            map["image"] = mInts[i]
            list.add(map)
        }
        val adapter = SimpleAdapter(this, list, R.layout.cell, arrayOf("image"), intArrayOf(R.id.iv))
        sv!!.adapter = adapter
    }


    @OnClick(R.id.iv_back, R.id.btn_previous, R.id.btn_next)
    fun onClick(view: View) {
        when (view.id) {
            R.id.iv_back -> finish()
            R.id.btn_previous -> sv!!.showPrevious()
            R.id.btn_next -> sv!!.showNext()
        }
    }
}
