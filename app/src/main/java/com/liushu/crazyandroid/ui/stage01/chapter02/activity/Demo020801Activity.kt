package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020801Activity : BaseActivity() {


    override val layoutId: Int
        get() = R.layout.activity_demo020801

    override fun initView() {
        tv_title_name!!.text = "Toast工具类"
        //   ToastUitl.showShort("");
    }


    @OnClick(R.id.iv_back, R.id.btn_simple, R.id.btn_image)
    fun onViewClicked(view: View) {
        when (view.id) {
            R.id.iv_back -> finish()
            R.id.btn_simple -> Toast.makeText(mContext, "简单的提示", Toast.LENGTH_SHORT).show()
            R.id.btn_image -> {
                val toast = Toast(this)
                val layout = LinearLayout(this)
                val imageView = ImageView(this)
                imageView.setImageResource(R.mipmap.ic_launcher)
                layout.addView(imageView)
                val textView = TextView(this)
                textView.text = "带图片的提示"
                textView.setTextColor(Color.BLUE)
                textView.textSize = 24f
                layout.addView(textView)
                toast.view = layout
                toast.duration = Toast.LENGTH_SHORT
                toast.show()
            }
        }
    }
}
