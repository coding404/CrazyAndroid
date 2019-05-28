package com.liushu.crazyandroid.ui.main.fragment

import android.content.Context
import android.os.Build
import android.text.TextUtils
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.jaydenxiao.common.base.BaseFragment
import com.liushu.crazyandroid.R
import kotlinx.android.synthetic.main.fragment_four.*

/**
 * Created by liushu on 2017/1/26.
 */

class FourFragment : BaseFragment() {

    private var settings: WebSettings? = null

    override fun getLayoutResource(): Int {
        return R.layout.fragment_four
    }

    override fun initPresenter() {

    }

    override fun initView() {
        tv_title!!.text = "版本号：${getVersionName(mContext)}"
        settings = webView!!.settings
        settings!!.javaScriptEnabled = true //如果访问的页面中有Javascript，则mWebView必须设置支持Javascript
        settings!!.javaScriptCanOpenWindowsAutomatically = true
        settings!!.setSupportZoom(true) //支持缩放
        settings!!.builtInZoomControls = true //支持手势缩放
        settings!!.displayZoomControls = false //是否显示缩放按钮

        // >= 19(SDK4.4)启动硬件加速，否则启动软件加速
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView!!.setLayerType(View.LAYER_TYPE_HARDWARE, null)
            settings!!.loadsImagesAutomatically = true //支持自动加载图片
        } else {
            webView!!.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
            settings!!.loadsImagesAutomatically = false
        }

        settings!!.useWideViewPort = true //将图片调整到适合mWebView的大小
        settings!!.loadWithOverviewMode = true //自适应屏幕
        settings!!.domStorageEnabled = true
        settings!!.saveFormData = true
        settings!!.setSupportMultipleWindows(true)
        settings!!.setAppCacheEnabled(true)
        settings!!.cacheMode = WebSettings.LOAD_DEFAULT //优先使用缓存

        webView!!.setHorizontalScrollbarOverlay(true)
        webView!!.isHorizontalScrollBarEnabled = false
        webView!!.overScrollMode = View.OVER_SCROLL_NEVER // 取消mWebView中滚动或拖动到顶部、底部时的阴影
        webView!!.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY // 取消滚动条白边效果
        webView!!.requestFocus()

        webView!!.loadUrl("file:///android_asset/about.html")
        webView!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                iv_back!!.visibility = View.VISIBLE
                return true
            }
        }
    }

 /*   @OnClick(R.id.iv_back)
    fun onViewClicked() {
        if (webView!!.canGoBack()) {
            webView!!.goBack()//返回上一页面

            if (!webView!!.canGoBack()) {
                iv_back!!.visibility = View.INVISIBLE
            }
        }
    }*/

    companion object {

        // 获取当前应用的版本号
        fun getVersionName(context: Context): String {
            try {
                val packageManager = context.packageManager
                val packInfo = packageManager.getPackageInfo(context.packageName, 0)
                val version = packInfo.versionName
                if (!TextUtils.isEmpty(version)) {
                    return version
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return ""
        }
    }
}
