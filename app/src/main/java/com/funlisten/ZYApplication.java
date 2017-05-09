package com.funlisten;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.bugtags.library.Bugtags;
import com.bugtags.library.BugtagsOptions;
import com.funlisten.service.db.ZYDBManager;
import com.funlisten.thirdParty.statistics.DataStatistics;
import com.funlisten.utils.ZYLog;
import com.funlisten.utils.ZYUncaughtExceptionHandler;

import java.io.File;

/**
 * Created by ZY on 17/4/27.
 */

public class ZYApplication extends Application implements ZYUncaughtExceptionHandler.OnUncaughtExceptionHappenListener {

    public static ZYApplication mInstance;

    public static final String APP_ROOT_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "smartreader";

    public static final String BOOK_ROOT_DIR = APP_ROOT_DIR + File.separator + "course" + File.separator;

    public static final String BOOK_ZIP_ROOT_DIR = APP_ROOT_DIR + File.separator + "courseZip" + File.separator;

    public static final String TRACT_AUDIO_ROOT_DIR = APP_ROOT_DIR + File.separator + "tractAudio" + File.separator;

    public static final String CACHE_ROOT_DIR = APP_ROOT_DIR + File.separator + "cache" + File.separator;

    private Activity currentActivity;

    @Override
    public void onCreate() {
        super.onCreate();

        //在主进程中进行初始化
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo info : activityManager.getRunningAppProcesses()) {
            if (info.pid == android.os.Process.myPid()) {
                if (getPackageName().equals(info.processName)) {
                    init();
                }
            }
        }
    }

    public static ZYApplication getInstance() {
        return mInstance;
    }

    private void init() {
        mInstance = this;
        //日志初使化
        ZYLog.init(BuildConfig.DEBUG);
        //数据统计
        DataStatistics.init(this);
        //数据库
        ZYDBManager.getInstance();
        initFileDir();

        ZYUncaughtExceptionHandler crashHandler = ZYUncaughtExceptionHandler.getInstance();
        crashHandler.init(this, APP_ROOT_DIR, BuildConfig.DEBUG);
        crashHandler.setListener(this);

        //在这里初始化
        initBugTags();
    }

    private void initFileDir() {
        File file = new File(BOOK_ROOT_DIR);
        if (!file.exists()) {
            ZYLog.e(getClass().getSimpleName(), "initFileDir: " + file.mkdirs() + file.getAbsolutePath());
        }

        file = new File(BOOK_ZIP_ROOT_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File(TRACT_AUDIO_ROOT_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }

        file = new File(CACHE_ROOT_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void initBugTags() {
        if (BuildConfig.DEBUG) {
            BugtagsOptions options = new BugtagsOptions.Builder()
                    .trackingLocation(true)
                    .trackingCrashLog(true).build();
            Bugtags.start(ZYAppConstants.BUGTAGS_KEY, this, Bugtags.BTGInvocationEventShake, options);
        } else {
            Bugtags.start(ZYAppConstants.BUGTAGS_KEY, this, Bugtags.BTGInvocationEventNone);
        }
    }

    public Activity getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(Activity currentActivity) {
        this.currentActivity = currentActivity;
    }

    @Override
    public void onUncaughtExceptionHappen(Thread thread, Throwable ex) {

    }
}