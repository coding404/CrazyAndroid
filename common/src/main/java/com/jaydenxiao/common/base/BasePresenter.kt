package com.jaydenxiao.common.base

import android.content.Context

import com.jaydenxiao.common.baserx.RxManager

/**
 * des:基类presenter
 * Created by xsf
 * on 2016.07.11:55
 */
abstract class BasePresenter<T, E> {
    var mContext: Context? = null
    var mModel: E?=null
    var mView: T?=null
    var mRxManage = RxManager()

    fun setVM(v: T, m: E) {
        this.mView = v
        this.mModel = m
        this.onStart()
    }

    fun onStart() {}
    fun onDestroy() {
        mRxManage.clear()
    }
}
