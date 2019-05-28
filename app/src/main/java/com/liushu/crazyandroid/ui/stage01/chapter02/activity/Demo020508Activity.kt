package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020508.*
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020508Activity : BaseActivity() {

    private val mInts = intArrayOf(R.drawable.chunv, R.drawable.shuangyu, R.drawable.shuangzi, R.drawable.baiyang, R.drawable.shizi, R.drawable.mojie, R.drawable.juxie, R.drawable.tianxie, R.drawable.tiancheng, R.drawable.sheshou, R.drawable.jinniu, R.drawable.shuiping)

    override val layoutId: Int
        get() = R.layout.activity_demo020508

    override fun initView() {
        tv_title_name!!.text = "自动播放的图片库"
        val adapter = object : BaseAdapter() {
            override fun getCount(): Int {
                return mInts.size
            }

            override fun getItem(position: Int): Any? {
                return null
            }

            override fun getItemId(position: Int): Long {
                return 0
            }

            override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
                val imageView = ImageView(this@Demo020508Activity)
                imageView.setImageResource(mInts[position])
                imageView.scaleType = ImageView.ScaleType.FIT_XY
                imageView.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                return imageView
            }
        }
        avf!!.adapter = adapter
    }


    @OnClick(R.id.iv_back, R.id.btn_next, R.id.btn_before, R.id.btn_auto)
    fun onClick(view: View) {
        when (view.id) {
            R.id.iv_back -> finish()
            R.id.btn_next -> {
                avf!!.showNext()
                avf!!.stopFlipping()
            }
            R.id.btn_before -> {
                avf!!.showPrevious()
                avf!!.stopFlipping()
            }
            R.id.btn_auto -> avf!!.startFlipping()
        }
    }
}
