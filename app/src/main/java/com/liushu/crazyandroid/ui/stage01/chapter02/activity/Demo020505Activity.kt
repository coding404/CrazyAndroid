package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020505.*
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020505Activity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_demo020505

    override fun initView() {
        tv_title_name!!.text = "扩建BasseAdapter实现不存储列表项的ListView"
        val adapter = object : BaseAdapter() {
            override fun getCount(): Int {
                return 20
            }

            override fun getItem(position: Int): Any {
                return position
            }

            override fun getItemId(position: Int): Long {
                return 0
            }

            override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
                val layout = LinearLayout(this@Demo020505Activity)
                layout.orientation = LinearLayout.HORIZONTAL
                val imageView = ImageView(this@Demo020505Activity)
                imageView.setImageResource(R.mipmap.ic_launcher)
                val textView = TextView(this@Demo020505Activity)
                textView.text = "这是第" + position + "个条目。"
                layout.addView(imageView)
                layout.addView(textView)
                return layout
            }
        }
        lv_demo020505!!.adapter = adapter
    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
