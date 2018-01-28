package com.android.zhhr.application;

import android.app.Application;
import android.content.Context;

import com.android.zhhr.data.commons.Constants;
import com.android.zhhr.db.manager.DaoManager;
import com.android.zhhr.db.manager.GreenDaoManager;
import com.zonst.libzadsdk.ZAdSdk;

import cn.jpush.android.api.JPushInterface;

/**
 * For developer startup JPush SDK
 * 
 * 一般建议在自定义 Application 类里初始化。也可以在主 Activity 里。
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);            // 初始化 JPush
        DaoManager.getInstance(this.getApplicationContext());

        //广告开关
        if(Constants.isAD){
            ZAdSdk.initialize(getApplicationContext());
            ZAdSdk.getInstance().setEnableLog(true);
        }
    }

}