package com.dg.user008.crazyandroid.app;

import com.dg.user008.crazyandroid.BuildConfig;
import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;


/**
 * Created by liushu on 2017/2/6.
 */

public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger
        LogUtils.logInit(BuildConfig.LOG_DEBUG);
    }
}
