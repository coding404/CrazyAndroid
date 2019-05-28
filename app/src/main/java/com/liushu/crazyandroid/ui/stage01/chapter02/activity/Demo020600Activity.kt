package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RatingBar
import android.widget.SeekBar
import butterknife.ButterKnife
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020600.*

class Demo020600Activity : AppCompatActivity() {

    private var mGroupPosition: Int = 0
    private var mChildPosition: Int = 0
    private val mData = IntArray(100)
    private var status = 0
    private var hasData = 0

    private val mHandler = object : Handler() {

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 1) {
                pb_01!!.progress = status
                pb_02!!.progress = status
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        mGroupPosition = intent.getIntExtra("groupPosition", -1)
        mChildPosition = intent.getIntExtra("childPosition", -1)
        setContentView(R.layout.activity_demo020600)
        ButterKnife.bind(this)
        initData(mGroupPosition, mChildPosition)

    }

    private fun initData(groupPosition: Int, childPosition: Int) {
        when (childPosition) {
            0 -> {
                ll_progressbardemo01!!.visibility = View.VISIBLE
                initData0()
            }
            1 -> {
                ll_progressbardemo02!!.visibility = View.VISIBLE
                initData1()
            }
            2 -> {
                ll_progressbardemo03!!.visibility = View.VISIBLE
                initData2()
            }
        }
    }

    private fun initData2() {
        rb_test!!.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser -> iv_lijiang02!!.imageAlpha = (rating * 255 / 5).toInt() }

    }

    private fun initData1() {
        seekb_test!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                iv_lijiang!!.imageAlpha = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })


    }

    private fun initData0() {
        object : Thread() {
            override fun run() {
                super.run()
                while (status < 100) {

                    status = dowork()
                    mHandler.sendEmptyMessage(1)
                }

            }
        }.start()

    }

    private fun dowork(): Int {
        mData[hasData++] = (Math.random() * 100).toInt()
        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return hasData
    }

}
