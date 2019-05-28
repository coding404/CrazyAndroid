package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.RadioButton
import android.widget.TextView

import com.liushu.crazyandroid.R

/**
 * Created by liushu on 2017/8/2.
 */

class OneChioceAdapter(private val mList: List<String>, private val mSelects: List<Boolean>) : BaseAdapter() {


    override fun getCount(): Int {
        return mList.size
    }

    override fun getItem(position: Int): Any {
        return mList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var holder: ViewHolder? = null
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.context).inflate(R.layout.item_one_chioce, null)
            holder = ViewHolder()
            holder.mTvContact = convertView!!.findViewById<View>(R.id.tv_contact) as TextView
            holder.mRbOneChioce = convertView.findViewById<View>(R.id.rb_one_chioce) as RadioButton
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.mTvContact!!.text = mList[position]
        holder.mRbOneChioce!!.isChecked = mSelects[position]
        return convertView
    }

    class ViewHolder {
         var mTvContact: TextView? = null
         var mRbOneChioce: RadioButton? = null
    }
}
