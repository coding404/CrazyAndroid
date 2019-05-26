package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import com.jaydenxiao.common.base.BaseActivity
import com.jaydenxiao.common.base.BaseModel
import com.jaydenxiao.common.base.BasePresenter
import com.liushu.crazyandroid.R

import java.util.Date

/**
 * Created by liushu on 2017/2/6.
 */

class Demo020101Activity() : BaseActivity() {

    private var mIVBack: ImageView? = null
    private var mTVTitle: TextView? = null

    override val layoutId: Int
        get() = -1


    override//layout.setId(View.generateViewId());
    val layoutView: View?
        get() {

            val layout = LinearLayout(this)
            layout.orientation = LinearLayout.VERTICAL
            val inflate = layoutInflater.inflate(R.layout.head_title_layout, null)
            mIVBack = inflate.findViewById<View>(R.id.iv_back) as ImageView
            mTVTitle = inflate.findViewById<View>(R.id.tv_title_name) as TextView
            val textView = TextView(this)
            val button = Button(this)
            button.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            button.text = "ok"
            button.setOnClickListener { textView.text = "Hello Android!" + Date() }
            layout.addView(inflate)
            layout.addView(textView)
            layout.addView(button)
            return layout
        }


    override fun initView() {
        mTVTitle!!.text = "用编程的方式开发UI界面"
        mIVBack!!.setOnClickListener { finish() }
    }


}
