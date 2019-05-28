package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.widget.SimpleAdapter
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020504.*
import kotlinx.android.synthetic.main.head_title_layout.*
import java.util.*

class Demo020504Activity : BaseActivity() {
    private val names = arrayOf("虎头", "弄玉", "李清照", "李白")
    private val descs = arrayOf("一个可爱的女孩", "一个擅长音乐的女孩", "一个擅长文学的女性", "一个浪漫主义诗人")
    private val mInts = intArrayOf(R.drawable.tiger, R.drawable.nongyu, R.drawable.qingzhao, R.drawable.libai)

    override val layoutId: Int
        get() = R.layout.activity_demo020504


    override fun initView() {
        tv_title_name!!.text = "使用SimpleAdapter创建ListView"
        val listItems = ArrayList<Map<String, Any>>()
        for (i in names.indices) {
            val map = HashMap<String, Any>()
            map["header"] = mInts[i]
            map["personName"] = names[i]
            map["descs"] = descs[i]
            listItems.add(map)
        }
        val simpleAdapter = SimpleAdapter(this, listItems, R.layout.simple_item,
                arrayOf("header", "personName", "descs"), intArrayOf(R.id.header, R.id.name, R.id.desc))
        lv_test!!.adapter = simpleAdapter
    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
