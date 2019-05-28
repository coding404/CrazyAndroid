package com.liushu.crazyandroid.ui.main.activity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.jaydenxiao.common.base.BaseActivity
import com.jaydenxiao.common.commonutils.LogUtils
import com.jaydenxiao.common.daynightmodeutils.ChangeModeController
import com.liushu.crazyandroid.R
import com.liushu.crazyandroid.app.AppConstant
import com.liushu.crazyandroid.bean.TabEntity
import com.liushu.crazyandroid.ui.main.fragment.FirstFragment
import com.liushu.crazyandroid.ui.main.fragment.FourFragment
import com.liushu.crazyandroid.ui.main.fragment.SecondFragment
import com.liushu.crazyandroid.ui.main.fragment.ThirdFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {

    private val mTitles = arrayOf("疯狂android讲义", "android开发艺术探索", "第三阶段", "关于我")
    private val mIconUnselectIds = intArrayOf(R.mipmap.ic_home_normal, R.mipmap.ic_girl_normal, R.mipmap.ic_video_normal, R.mipmap.ic_care_normal)
    private val mIconSelectIds = intArrayOf(R.mipmap.ic_home_selected, R.mipmap.ic_girl_selected, R.mipmap.ic_video_selected, R.mipmap.ic_care_selected)
    private val mTabEntities = ArrayList<CustomTabEntity>()

    private var mFirstFragment: FirstFragment? = null
    private var mSecondFragment: SecondFragment? = null
    private var mThirdFragment: ThirdFragment? = null
    private var mFourFragment: FourFragment? = null
    private var exitTime: Long = 0

    override val layoutId: Int
        get() = R.layout.activity_main


    override fun initView() {
        initTab()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //切换daynight模式要立即变色的页面
        ChangeModeController.getInstance().init(this, R.attr::class.java)
        super.onCreate(savedInstanceState)
        //初始化frament
        initFragment(savedInstanceState)
        tab_layout!!.measure(0, 0)
        tabLayoutHeight = tab_layout!!.measuredHeight
    }

    /**
     * 初始化tab
     */
    private fun initTab() {
        for (i in mTitles.indices) {
            mTabEntities.add(TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]))
        }
        tab_layout!!.setTabData(mTabEntities)
        //点击监听
        tab_layout!!.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                SwitchTo(position)
            }

            override fun onTabReselect(position: Int) {}
        })
    }

    /**
     * 初始化碎片
     */
    private fun initFragment(savedInstanceState: Bundle?) {
        val transaction = supportFragmentManager.beginTransaction()
        var currentTabPosition = 0
        if (savedInstanceState != null) {
            mFirstFragment = supportFragmentManager.findFragmentByTag("newsMainFragment") as FirstFragment?
            mSecondFragment = supportFragmentManager.findFragmentByTag("photosMainFragment") as SecondFragment?
            mThirdFragment = supportFragmentManager.findFragmentByTag("videoMainFragment") as ThirdFragment?
            mFourFragment = supportFragmentManager.findFragmentByTag("careMainFragment") as FourFragment?
            currentTabPosition = savedInstanceState.getInt(AppConstant.HOME_CURRENT_TAB_POSITION)
        } else {
            mFirstFragment = FirstFragment()
            mSecondFragment = SecondFragment()
            mThirdFragment = ThirdFragment()
            mFourFragment = FourFragment()

            transaction.add(R.id.fl_body, mFirstFragment!!, "newsMainFragment")
            transaction.add(R.id.fl_body, mSecondFragment!!, "photosMainFragment")
            transaction.add(R.id.fl_body, mThirdFragment!!, "videoMainFragment")
            transaction.add(R.id.fl_body, mFourFragment!!, "careMainFragment")
        }
        transaction.commit()
        SwitchTo(currentTabPosition)
        tab_layout!!.currentTab = currentTabPosition
    }

    /**
     * 切换
     */
    private fun SwitchTo(position: Int) {
        LogUtils.logd("主页菜单position$position")
        val transaction = supportFragmentManager.beginTransaction()
        when (position) {
            0 -> {
                transaction.hide(mSecondFragment!!)
                transaction.hide(mThirdFragment!!)
                transaction.hide(mFourFragment!!)
                transaction.show(mFirstFragment!!)
                transaction.commitAllowingStateLoss()
            }
            1 -> {
                transaction.hide(mFirstFragment!!)
                transaction.hide(mThirdFragment!!)
                transaction.hide(mFourFragment!!)
                transaction.show(mSecondFragment!!)
                transaction.commitAllowingStateLoss()
            }
            2 -> {
                transaction.hide(mFirstFragment!!)
                transaction.hide(mSecondFragment!!)
                transaction.hide(mFourFragment!!)
                transaction.show(mThirdFragment!!)
                transaction.commitAllowingStateLoss()
            }
            3 -> {
                transaction.hide(mFirstFragment!!)
                transaction.hide(mSecondFragment!!)
                transaction.hide(mThirdFragment!!)
                transaction.show(mFourFragment!!)
                transaction.commitAllowingStateLoss()
            }
            else -> {
            }
        }
    }

    /**
     * 菜单显示隐藏动画
     *
     * @param showOrHide
     */
    private fun startAnimation(showOrHide: Boolean) {
        val layoutParams = tab_layout!!.layoutParams
        val valueAnimator: ValueAnimator
        val alpha: ObjectAnimator
        if (!showOrHide) {
            valueAnimator = ValueAnimator.ofInt(tabLayoutHeight, 0)
            alpha = ObjectAnimator.ofFloat(tab_layout, "alpha", 1f, 0f)
        } else {
            valueAnimator = ValueAnimator.ofInt(0, tabLayoutHeight)
            alpha = ObjectAnimator.ofFloat(tab_layout, "alpha", 0f, 1f)
        }
        valueAnimator.addUpdateListener {
            layoutParams.height = valueAnimator.animatedValue as Int
            tab_layout!!.layoutParams = layoutParams
        }
        val animatorSet = AnimatorSet()
        animatorSet.duration = 500
        animatorSet.playTogether(valueAnimator, alpha)
        animatorSet.start()
    }

    /**
     * 监听全屏视频时返回键
     */
    override fun onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(applicationContext, "再按一次退出程序", Toast.LENGTH_SHORT).show()
            exitTime = System.currentTimeMillis()
        } else {
            val backHome = Intent(Intent.ACTION_MAIN)
            backHome.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            backHome.addCategory(Intent.CATEGORY_HOME)
            startActivity(backHome)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //崩溃前保存位置
        if (tab_layout != null) {
            outState.putInt(AppConstant.HOME_CURRENT_TAB_POSITION, tab_layout!!.currentTab)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        ChangeModeController.onDestory()
    }

    companion object {
        private var tabLayoutHeight: Int = 0

        /**
         * 入口
         *
         * @param activity
         */
        fun startAction(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.fade_in,
                    com.jaydenxiao.common.R.anim.fade_out)
        }
    }

}
