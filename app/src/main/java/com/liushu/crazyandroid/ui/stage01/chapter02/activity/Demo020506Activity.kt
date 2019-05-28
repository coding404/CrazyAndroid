package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.view.View
import android.widget.AdapterView
import android.widget.SimpleAdapter
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020506.*
import kotlinx.android.synthetic.main.head_title_layout.*
import java.util.*

class Demo020506Activity : BaseActivity() {

    private val mInts = intArrayOf(R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7, R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10, R.drawable.bomb11, R.drawable.bomb12, R.drawable.bomb13, R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16)

    override val layoutId: Int
        get() = R.layout.activity_demo020506


    override fun initView() {
        tv_title_name!!.text = "带预览的图片浏览器"
        val list = ArrayList<Map<String, Any>>()
        for (i in mInts.indices) {
            val map = HashMap<String, Any>()
            map["image"] = mInts[i]
            list.add(map)
        }
        val adapter = SimpleAdapter(this, list, R.layout.cell, arrayOf("image"), intArrayOf(R.id.iv))
        gv_test!!.adapter = adapter
        gv_test!!.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id -> iv_test!!.setImageResource(mInts[position]) }
        gv_test!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                iv_test!!.setImageResource(mInts[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
