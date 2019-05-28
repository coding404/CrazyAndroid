package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020803.*
import kotlinx.android.synthetic.main.head_title_layout.*
import java.util.*

class Demo020803Activity : BaseActivity() {

    private var mYear: Int = 0
    private var mMonth: Int = 0
    private var mDay: Int = 0
    private var mHour: Int = 0
    private var mMinute: Int = 0

    override val layoutId: Int
        get() = R.layout.activity_demo020803


    override fun initView() {
        tv_title_name!!.text = "用户选择日期、时间"
        val instance = Calendar.getInstance()
        mYear = instance.get(Calendar.YEAR)
        mMonth = instance.get(Calendar.MONTH)
        mDay = instance.get(Calendar.DAY_OF_MONTH)
        mHour = instance.get(Calendar.AM_PM)
        mMinute = instance.get(Calendar.MINUTE)
        date_picker!!.init(mYear, mMonth, mDay) { view, year, monthOfYear, dayOfMonth ->
            mYear = year
            mMonth = monthOfYear
            mDay = dayOfMonth
            showDate(mYear, mMonth, mDay, mHour, mMinute)
        }
        time_picker!!.setOnTimeChangedListener { view, hourOfDay, minute ->
            mHour = hourOfDay
            mMinute = minute
            showDate(mYear, mMonth, mDay, mHour, mMinute)
        }
    }

    private fun showDate(year: Int, month: Int, day: Int, hour: Int, minute: Int) {
        et_test03!!.setText("您的购买日期为：" + year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分")
    }

    @OnClick(R.id.iv_back)
    fun onViewClicked() {
        finish()
    }
}
