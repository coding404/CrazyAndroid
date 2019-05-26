package com.liushu.crazyandroid.ui.stage01.chapter02

import com.jaydenxiao.common.base.BaseModel
import com.jaydenxiao.common.base.BasePresenter
import com.jaydenxiao.common.base.BaseView

/**
 *
 *   created by  liushu
 *   created on  2019-05-26
 *   description：
 *
 **/
interface DemoContract {

    interface View :BaseView{

        fun ddd()
    }

    interface Model:BaseModel{
        fun eee()
    }


    abstract class Presenter: BasePresenter<View, Model>() {

    }
}