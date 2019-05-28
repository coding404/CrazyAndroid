package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.text.TextUtils
import android.widget.ArrayAdapter
import android.widget.SearchView
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.jaydenxiao.common.commonutils.ToastUitl
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.activity_demo020805.*
import kotlinx.android.synthetic.main.head_title_layout.*

class Demo020805Activity : BaseActivity() {

    private val mStrings = arrayOf("aaaa", "bbbbbbbbb", "ccccccc")

    override val layoutId: Int
        get() = R.layout.activity_demo020805

    override fun initView() {
        tv_title_name!!.text = "搜索"
        lv_test5!!.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mStrings)
        lv_test5!!.isTextFilterEnabled = true
        sv!!.setIconifiedByDefault(false)
        sv!!.isSubmitButtonEnabled = true
        sv!!.queryHint = "查找"
        sv!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (TextUtils.isEmpty(query)) {
                    lv_test5!!.clearTextFilter()
                } else {
                    lv_test5!!.setFilterText(query)
                }

                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                ToastUitl.showShort("您选择的是：$newText")
                return false
            }
        })
    }

    @OnClick(R.id.iv_back)
    fun onViewClicked() {
        finish()
    }
}
