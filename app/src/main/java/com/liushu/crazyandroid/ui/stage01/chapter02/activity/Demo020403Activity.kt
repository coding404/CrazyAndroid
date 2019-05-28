package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020403.*
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020403Activity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_demo020403

    override fun initView() {
        tv_title_name!!.text = "使用QuickContactBadge关联联系人"
        qcb_test!!.assignContactFromPhone("18117527783", true)
    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }
}
