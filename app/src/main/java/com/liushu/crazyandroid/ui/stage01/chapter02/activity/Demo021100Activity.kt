package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.liushu.crazyandroid.R
import java.text.SimpleDateFormat
import java.util.*

class Demo021100Activity : AppCompatActivity() {
    private var mGroupPosition: Int = 0
    private var mChildPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo021100)
        mGroupPosition = intent.getIntExtra("groupPosition", -1)
        mChildPosition = intent.getIntExtra("childPosition", -1)
        initView(mChildPosition)
    }

    private fun initView(childPosition: Int) {
        when (childPosition) {
            0 -> initData0()
            1 -> {
            }
            2 -> {
            }
            3 -> {
            }
        }
    }

    private fun initData0() {

        val deadLine = java.lang.Long.parseLong("1488210720000")
        val dateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm")
        val date = Date(deadLine)
        val endTime = dateFormat.format(date)
    }
}
