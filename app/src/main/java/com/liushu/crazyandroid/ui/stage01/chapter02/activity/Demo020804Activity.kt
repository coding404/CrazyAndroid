package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.jaydenxiao.common.commonutils.ToastUitl
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020804.*
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020804Activity : BaseActivity() {

    private var minPrice = 25
    private var maxPrice = 75
    override val layoutId: Int
        get() = R.layout.activity_demo020804

    override fun initView() {
        tv_title_name!!.text = "选择您意向的价格范围"

        number_pick_low!!.minValue = 10
        number_pick_low!!.maxValue = 50
        number_pick_low!!.value = minPrice
         number_pick_high!!.minValue = 60
        number_pick_high!!.maxValue = 100
        number_pick_high!!.value = maxPrice
        number_pick_low!!.setOnValueChangedListener { picker, oldVal, newVal ->
            minPrice = newVal
            showSelectPrice()
        }
        number_pick_high!!.setOnValueChangedListener { picker, oldVal, newVal ->
            maxPrice = newVal
            showSelectPrice()
        }
    }

    private fun showSelectPrice() {
        ToastUitl.showShort("您选择的最低价格为：$minPrice\n最高价格为：$maxPrice")
    }


    @OnClick(R.id.iv_back)
    fun onViewClicked() {
        finish()
    }
}
