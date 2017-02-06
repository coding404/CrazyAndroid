package com.jaydenxiao.common.baseapp;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;
import android.util.Log;

/**
 * APPLICATION
 */
public class BaseApplication extends Application {

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }

    public static Context getAppContext() {
        if (baseApplication==null){

            Log.e("6666","22222222222222222");
        }

        return baseApplication;
    }
    public static Resources getAppResources() {
        return baseApplication.getResources();
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 分包
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
