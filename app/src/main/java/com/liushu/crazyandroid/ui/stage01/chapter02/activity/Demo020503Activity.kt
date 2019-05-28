package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.app.ListActivity
import android.os.Bundle
import android.widget.ArrayAdapter

class Demo020503Activity : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_demo020503);
        val strings = arrayOf("hello", "world", "22222", "sssss")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, strings)
        listAdapter = adapter
    }
}
