package com.example.mary.smartbutler.application;

import android.app.Application;

import com.example.mary.smartbutler.utils.StaticClass;
import com.tencent.bugly.crashreport.CrashReport;

import cn.bmob.v3.Bmob;

/**
 * Created by mary on 2017/10/9.
 */

public class BaseApplication  extends Application{

    //创建
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化Bugly
        CrashReport.initCrashReport(getApplicationContext(), StaticClass.BUGLY_APP_ID,true);
        //初始化Bomb
        Bmob.initialize(this, StaticClass.BMOB_APP_ID);
    }
}
