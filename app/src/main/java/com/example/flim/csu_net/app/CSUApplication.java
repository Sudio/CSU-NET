package com.example.flim.csu_net.app;

import android.app.Application;
import android.content.Context;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by Flim on 2015/12/6.
 */
public class CSUApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        CrashReport.initCrashReport(getContext(),"900013767",true);
    }

    public static Context getContext() {
        return context;
    }
}
