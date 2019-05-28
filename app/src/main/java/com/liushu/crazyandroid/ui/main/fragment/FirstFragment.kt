package com.liushu.crazyandroid.ui.main.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.TypedValue
import android.view.View
import com.jaydenxiao.common.base.BaseFragment
import com.liushu.crazyandroid.R
import com.liushu.crazyandroid.adapter.MyPagerAdapter
import com.liushu.crazyandroid.ui.stage01.chapter01.fragment.Chapter01Fragment
import com.liushu.crazyandroid.ui.stage01.chapter02.fragment.Chapter02Fragment
import com.liushu.crazyandroid.ui.stage01.chapter03.fragment.Chapter03Fragment
import com.liushu.crazyandroid.ui.stage01.chapter04.fragment.Chapter04Fragment
import com.liushu.crazyandroid.ui.stage01.chapter05.fragment.Chapter05Fragment
import com.liushu.crazyandroid.ui.stage01.chapter06.fragment.Chapter06Fragment
import com.liushu.crazyandroid.ui.stage01.chapter07.fragment.Chapter07Fragment
import com.liushu.crazyandroid.ui.stage01.chapter08.fragment.Chapter08Fragment
import com.liushu.crazyandroid.ui.stage01.chapter09.fragment.Chapter09Fragment
import com.liushu.crazyandroid.ui.stage01.chapter10.fragment.Chapter10Fragment
import com.liushu.crazyandroid.ui.stage01.chapter11.fragment.Chapter11Fragment
import com.liushu.crazyandroid.ui.stage01.chapter12.fragment.Chapter12Fragment
import com.liushu.crazyandroid.ui.stage01.chapter13.fragment.Chapter13Fragment
import com.liushu.crazyandroid.ui.stage01.chapter14.fragment.Chapter14Fragment
import com.liushu.crazyandroid.ui.stage01.chapter15.fragment.Chapter15Fragment
import com.liushu.crazyandroid.ui.stage01.chapter16.fragment.Chapter16Fragment
import com.liushu.crazyandroid.utils.MyUtils
import com.liushu.crazyandroid.widget.PagerSlidingTabStrip
import kotlinx.android.synthetic.main.fragment_first.*
import java.util.*


/**
 * Created by liushu on 2017/1/26.
 */

class FirstFragment : BaseFragment() {

    private val ta111bs: PagerSlidingTabStrip? = null
    private var mPagerAdapter: MyPagerAdapter? = null
    private val oldBackground: Drawable? = null
    private val currentColor: Int = 0
    private var mFragments: MutableList<Fragment>? = null

    override fun getLayoutResource(): Int {
        return R.layout.fragment_first
    }

    override fun initPresenter() {

    }

    override fun initView() {

        mFragments = ArrayList()
        mPagerAdapter = MyPagerAdapter(childFragmentManager, mFragments)
        vp_first!!.adapter = mPagerAdapter
        vp_first!!.offscreenPageLimit = 8
        tab_layout!!.setupWithViewPager(vp_first)
        MyUtils.dynamicSetTabLayoutMode(tab_layout)
        val pageMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4f, resources
                .displayMetrics).toInt()
        vp_first!!.pageMargin = pageMargin
        val position = activity!!.intent.getIntExtra("position", 0)
        vp_first!!.currentItem = position
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragments()
        mPagerAdapter!!.notifyDataSetChanged()
    }

    private fun initFragments() {

        val chapter01Fragment = Chapter01Fragment()
        mFragments!!.add(chapter01Fragment)
        val chapter02Fragment = Chapter02Fragment()
        mFragments!!.add(chapter02Fragment)
        val chapter03Fragment = Chapter03Fragment()
        mFragments!!.add(chapter03Fragment)
        val chapter04Fragment = Chapter04Fragment()
        mFragments!!.add(chapter04Fragment)
        val chapter05Fragment = Chapter05Fragment()
        mFragments!!.add(chapter05Fragment)
        val chapter06Fragment = Chapter06Fragment()
        mFragments!!.add(chapter06Fragment)
        val chapter07Fragment = Chapter07Fragment()
        mFragments!!.add(chapter07Fragment)
        val chapter08Fragment = Chapter08Fragment()
        mFragments!!.add(chapter08Fragment)
        val chapter09Fragment = Chapter09Fragment()
        mFragments!!.add(chapter09Fragment)
        val chapter10Fragment = Chapter10Fragment()
        mFragments!!.add(chapter10Fragment)
        val chapter11Fragment = Chapter11Fragment()
        mFragments!!.add(chapter11Fragment)
        val chapter12Fragment = Chapter12Fragment()
        mFragments!!.add(chapter12Fragment)
        val chapter13Fragment = Chapter13Fragment()
        mFragments!!.add(chapter13Fragment)
        val chapter14Fragment = Chapter14Fragment()
        mFragments!!.add(chapter14Fragment)
        val chapter15Fragment = Chapter15Fragment()
        mFragments!!.add(chapter15Fragment)
        val chapter16Fragment = Chapter16Fragment()
        mFragments!!.add(chapter16Fragment)
    }
}
