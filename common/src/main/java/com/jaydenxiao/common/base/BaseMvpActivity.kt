package com.jaydenxiao.common.base

import android.os.Bundle
import com.jaydenxiao.common.commonutils.TUtil

/**
 *
 *   created by  liushu
 *   created on  2019-05-26
 *   description：
 *
 **/
abstract class BaseMvpActivity<T : BasePresenter<*, *>, E : BaseModel>() : BaseActivity() {
    var mPresenter: T? = null
    var mModel: E? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        mPresenter = TUtil.getT(this, 0)

        super.onCreate(savedInstanceState)
    }

    override fun initView() {

        mPresenter=TUtil.getT(this,0)
        mModel=TUtil.getT(this,1)
        mPresenter?.mContext=this
        this.initPresenter()
        this.initMvpView()
    }

    abstract fun initPresenter()
    abstract fun initMvpView()
}