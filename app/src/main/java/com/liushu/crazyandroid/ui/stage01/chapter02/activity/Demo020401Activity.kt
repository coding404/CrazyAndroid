package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import android.view.View
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020401.*
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020401Activity : BaseActivity() {

    private val mInts = intArrayOf(R.drawable.shuangta, R.drawable.lijiang, R.drawable.shui, R.drawable.qiao)
    private var currentInt = 2
    private var alpha = 255

    override val layoutId: Int
        get() = R.layout.activity_demo020401


    override fun initView() {
        tv_title_name!!.text = "图片浏览器"
        iv_big!!.setOnTouchListener { v, event ->
            val drawable = iv_big!!.drawable as BitmapDrawable
            val bitmap = drawable.bitmap

            val scale = 1.0 * bitmap.height / iv_big!!.height
            var x = (event.x * scale).toInt()
            var y = (event.y * scale).toInt()
            Log.e("x", x.toString() + "")
            Log.e("y", y.toString() + "")
            if (x <= 0) {
                x = 0
            }
            if (y <= 0) {
                y = 0
            }

            if (x + 160 > bitmap.width) {
                x = bitmap.width - 160
            }
            if (y + 160 > bitmap.height) {
                y = bitmap.height - 160
            }
            iv_small!!.setImageBitmap(Bitmap.createBitmap(bitmap, x, y, 160, 160))
            iv_small!!.imageAlpha = alpha
            true
        }
    }

    @OnClick(R.id.iv_back, R.id.btn_01, R.id.btn_02, R.id.btn_03)
    fun onClick(view: View) {
        when (view.id) {
            R.id.iv_back -> finish()
            R.id.btn_01 -> {
                alpha += 20
                if (alpha >= 255) {
                    alpha = 255
                }
                iv_big!!.imageAlpha = alpha
            }
            R.id.btn_02 -> {
                alpha -= 20
                if (alpha <= 0) {
                    alpha = 0
                }
                iv_big!!.imageAlpha = alpha
            }
            R.id.btn_03 -> {
                currentInt += 1
                iv_big!!.setImageResource(mInts[currentInt % mInts.size])
            }
        }
    }
}
