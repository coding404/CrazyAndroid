package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.jaydenxiao.common.commonutils.ToastUitl
import com.liushu.crazyandroid.R
import com.liushu.crazyandroid.widget.OneChioceDialog
import kotlinx.android.synthetic.main.include_simple_title.*
import java.util.*


class Demo020901Activity : BaseActivity() {

    private val mStrings = arrayOf("111", "222", "334", "442134", "666")

    override val layoutId: Int
        get() = R.layout.activity_demo020901

    @OnClick(R.id.btn_show_message, R.id.btn_simple_list, R.id.btn_onechioce_list, R.id.btn_onechioce_self, R.id.btn_morechioce_list, R.id.btn_custom_list, R.id.btn_custom_view, R.id.iv_back)
    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_show_message -> showDialog0()
            R.id.btn_simple_list -> showDialog1()
            R.id.btn_onechioce_list -> showDialog2()
            R.id.btn_morechioce_list -> showDialog3()
            R.id.btn_custom_list -> showDialog4()
            R.id.btn_custom_view -> showDialog5()
            R.id.btn_onechioce_self -> showDialog6()
            R.id.iv_back -> finish()
            else -> {
            }
        }
    }

    private fun showDialog6() {

        val builder = OneChioceDialog.Builder(this@Demo020901Activity)
        builder.setTitle("需要填写的标题")
        val list = ArrayList<String>()
        for (i in 0..9) {
            list.add("这是第" + i + "条")
        }
        builder.setList(list)
        builder.setNegativeButton("取消") { dialog, which -> dialog.dismiss() }
        builder.setPositiveButton("确定") { dialog, which ->
            dialog.dismiss()
            val contact = builder.contact
            ToastUitl.showShort(contact)
        }
        builder.create().show()
    }

    private fun showDialog0() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("显示提示消息的对话框")
        builder.setMessage("显示消息的内容\n这是第二行")
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setPositiveButton("确定") { dialog, which -> ToastUitl.showShort("点击了确定按钮") }
        builder.setNegativeButton("取消") { dialog, which -> ToastUitl.showShort("点击了取消按钮") }
        builder.create().show()

    }

    private fun showDialog1() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("简单列表项对话框")
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setItems(mStrings) { dialog, which -> ToastUitl.showShort("你选择了：" + mStrings[which]) }

        builder.setPositiveButton("确定") { dialog, which -> ToastUitl.showShort("点击了确定按钮") }
        builder.setNegativeButton("取消") { dialog, which -> ToastUitl.showShort("点击了取消按钮") }
        builder.create().show()


    }

    private fun showDialog2() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("单选列表项对话框")
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setSingleChoiceItems(mStrings, 0) { dialog, which -> ToastUitl.showShort("你选择了：" + mStrings[which]) }

        builder.setPositiveButton("确定") { dialog, which -> ToastUitl.showShort("点击了确定按钮") }
        builder.setNegativeButton("取消") { dialog, which -> ToastUitl.showShort("点击了取消按钮") }
        builder.create().show()
    }

    private fun showDialog3() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("多选列表项对话框")
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setMultiChoiceItems(mStrings, booleanArrayOf(true, true, true, true, true)) { dialog, which, isChecked -> }

        builder.setPositiveButton("确定") { dialog, which -> ToastUitl.showShort("点击了确定按钮") }
        builder.setNegativeButton("取消") { dialog, which -> ToastUitl.showShort("点击了取消按钮") }
        builder.create().show()
    }

    private fun showDialog4() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("自定义列表项对话框")
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setAdapter(ArrayAdapter(this, R.layout.array_item, mStrings), null)

        builder.setPositiveButton("确定") { dialog, which -> ToastUitl.showShort("点击了确定按钮") }
        builder.setNegativeButton("取消") { dialog, which -> ToastUitl.showShort("点击了取消按钮") }
        builder.create().show()
    }

    private fun showDialog5() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("自定义列表项对话框")
        builder.setIcon(R.mipmap.ic_launcher)
        val view = LayoutInflater.from(this).inflate(R.layout.activity_demo020205, null)
        builder.setView(view)
        builder.setNegativeButton("取消") { dialog, which -> ToastUitl.showShort("点击了取消按钮") }
        builder.create().show()
    }

    override fun initView() {
        tv_title!!.text = "Dialog的使用方法"
    }
}
