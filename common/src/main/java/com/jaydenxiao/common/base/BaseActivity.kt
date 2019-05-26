package com.jaydenxiao.common.base


import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window

import com.jaydenxiao.common.BuildConfig
import com.jaydenxiao.common.R
import com.jaydenxiao.common.baseapp.AppManager
import com.jaydenxiao.common.baserx.RxManager
import com.jaydenxiao.common.commonutils.TUtil
import com.jaydenxiao.common.commonutils.ToastUitl
import com.jaydenxiao.common.commonwidget.LoadingDialog
import com.jaydenxiao.common.commonwidget.StatusBarCompat
import com.jaydenxiao.common.daynightmodeutils.ChangeModeController
import com.umeng.analytics.MobclickAgent

import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * 基类
 */

/***************使用例子 */
//1.mvp模式
//public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
//    }
//
//    @Override
//    public void initView() {
//    }
//}
//2.普通模式
//public class SampleActivity extends BaseActivity {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//    }
//
//    @Override
//    public void initView() {
//    }
//}
abstract class BaseActivity : AppCompatActivity() {

    lateinit var mContext: Context
    lateinit var mRxManager: RxManager

    private var bind: Unbinder? = null

    /*********************子类实现 */
    //获取布局文件
    abstract val layoutId: Int

    open val layoutView: View?
        get() = null


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRxManager = RxManager()
        doBeforeSetcontentView()
        if (layoutId != -1) {
            setContentView(layoutId)
        } else {
            setContentView(layoutView)
        }

        bind = ButterKnife.bind(this)
        mContext = this
        /*mPresenter = TUtil.getT<T>(this, 0)
        mModel = TUtil.getT<E>(this, 1)
        if (mPresenter != null) {
            mPresenter!!.mContext = this
        }*/
      //  this.initPresenter()
        this.initView()
    }

    /**
     * 设置layout前配置
     */
    private fun doBeforeSetcontentView() {
        //设置昼夜主题
        initTheme()
        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this)
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        // 设置竖屏
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        // 默认着色状态栏
        SetStatusBarColor()
    }

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
   // abstract fun initPresenter()

    //初始化view
    abstract fun initView()


    /**
     * 设置主题
     */
    private fun initTheme() {
        ChangeModeController.setTheme(this, R.style.DayTheme, R.style.NightTheme)
    }

    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected fun SetStatusBarColor() {
        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, R.color.main_color))
    }

    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected fun SetStatusBarColor(color: Int) {
        StatusBarCompat.setStatusBarColor(this, color)
    }

    /**
     * 沉浸状态栏（4.4以上系统有效）
     */
    protected fun SetTranslanteBar() {
        StatusBarCompat.translucentStatusBar(this)
    }

    /**
     * 通过Class跳转界面
     */
    fun startActivityForResult(cls: Class<*>, requestCode: Int) {
        startActivityForResult(cls, null, requestCode)
    }

    /**
     * 含有Bundle通过Class跳转界面
     */
    fun startActivityForResult(cls: Class<*>, bundle: Bundle?,
                               requestCode: Int) {
        val intent = Intent()
        intent.setClass(this, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, requestCode)
    }

    /**
     * 含有Bundle通过Class跳转界面
     */
    fun startActivity(cls: Class<*>, bundle: Bundle? = null) {
        val intent = Intent()
        intent.setClass(this, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    /**
     * 开启浮动加载进度条
     */
    fun startProgressDialog() {
        LoadingDialog.showDialogForLoading(this)
    }

    /**
     * 开启浮动加载进度条
     *
     * @param msg
     */
    fun startProgressDialog(msg: String) {
        LoadingDialog.showDialogForLoading(this, msg, true)
    }

    /**
     * 停止浮动加载进度条
     */
    fun stopProgressDialog() {
        LoadingDialog.cancelDialogForLoading()
    }

    /**
     * 短暂显示Toast提示(来自String)
     */
    fun showShortToast(text: String) {
        ToastUitl.showShort(text)
    }

    /**
     * 短暂显示Toast提示(id)
     */
    fun showShortToast(resId: Int) {
        ToastUitl.showShort(resId)
    }

    /**
     * 长时间显示Toast提示(来自res)
     */
    fun showLongToast(resId: Int) {
        ToastUitl.showLong(resId)
    }

    /**
     * 长时间显示Toast提示(来自String)
     */
    fun showLongToast(text: String) {
        ToastUitl.showLong(text)
    }

    /**
     * 带图片的toast
     *
     * @param text
     * @param res
     */
    fun showToastWithImg(text: String, res: Int) {
        ToastUitl.showToastWithImg(text, res)
    }

    /**
     * 网络访问错误提醒
     */
    fun showNetErrorTip() {
        ToastUitl.showToastWithImg(getText(R.string.net_error).toString(), R.drawable.ic_wifi_off)
    }

    fun showNetErrorTip(error: String) {
        ToastUitl.showToastWithImg(error, R.drawable.ic_wifi_off)
    }

    override fun onResume() {
        super.onResume()
        //debug版本不统计crash
        if (!BuildConfig.LOG_DEBUG) {
            //友盟统计
            MobclickAgent.onResume(this)
        }
    }

    override fun onPause() {
        super.onPause()
        //debug版本不统计crash
        if (!BuildConfig.LOG_DEBUG) {
            //友盟统计
            MobclickAgent.onPause(this)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        /*if (mPresenter != null)
            mPresenter!!.onDestroy()*/
        mRxManager.clear()
        bind!!.unbind()
        AppManager.getAppManager().finishActivity(this)
    }
}
/**
 * 通过Class跳转界面
 */
