package com.liushu.crazyandroid.ui.stage01.chapter02.activity


import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020305.*
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020305Activity : BaseActivity() {


    override val layoutId: Int
        get() = R.layout.activity_demo020305

    override fun initView() {
        tv_title_name!!.text = "利用单选框，复选框获取用户信息"
        rg!!.setOnCheckedChangeListener { group, checkedId ->
            val string = if (checkedId == R.id.rb_female) "你是女生" else "你是男生"
            tv_content!!.text = string
        }
    }

    @OnClick(R.id.iv_back)
    fun onClick() {
        finish()
    }

}
