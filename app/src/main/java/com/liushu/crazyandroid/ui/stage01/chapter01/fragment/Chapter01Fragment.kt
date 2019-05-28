package com.liushu.crazyandroid.ui.stage01.chapter01.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.andexert.calendarlistview.library.DatePickerController
import com.andexert.calendarlistview.library.SimpleMonthAdapter
import com.google.gson.Gson
import com.jaydenxiao.common.base.BaseFragment
import com.liushu.crazyandroid.R
import com.liushu.crazyandroid.bean.CatalogBean
import kotlinx.android.synthetic.main.fragment_chape01.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Created by liushu on 2017/2/3.
 */

class Chapter01Fragment : BaseFragment(), DatePickerController {


    override fun getLayoutResource(): Int {
        return R.layout.fragment_chape01
    }

    override fun initPresenter() {

    }

    override fun initView() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // readFromAssets();
        day_picker!!.setController(this)
    }

    /**
     * 从assets中读取txt
     */
    private fun readFromAssets() {
        try {
            val `is` = activity!!.assets.open("chapter02.json")
            val text = readTextFromSDcard(`is`)

            val gson = Gson()
            val catalogBean02 = gson.fromJson(text, CatalogBean::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * 按行读取txt
     *
     * @param is
     * @return
     * @throws Exception
     */
    @Throws(Exception::class)
    private fun readTextFromSDcard(`is`: InputStream): String {
        val reader = InputStreamReader(`is`)
        val bufferedReader = BufferedReader(reader)
        val buffer = StringBuffer("")
        var str: String?=bufferedReader.readLine()
        while (str != null) {
            buffer.append(str)
            buffer.append("\n")
            str=bufferedReader.readLine()
        }
        return buffer.toString()
    }

    override fun getMaxYear(): Int {
        return 2020
    }

    override fun onDayOfMonthSelected(year: Int, month: Int, day: Int) {

    }

    override fun onHourSelected(ourString: String) {

    }

    override fun onDateRangeSelected(selectedDays: SimpleMonthAdapter.SelectedDays<SimpleMonthAdapter.CalendarDay>) {
        Toast.makeText(context, selectedDays.first.toString() + " --> " + selectedDays.last.toString(), Toast.LENGTH_SHORT).show()
    }

}
