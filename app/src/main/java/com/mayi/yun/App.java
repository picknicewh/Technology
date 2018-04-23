package com.mayi.yun;

import android.app.Application;

import com.mayi.yun.dragger.component.DaggerAppComponent;
import com.mayi.yun.dragger.module.AppModule;
import com.mayi.yun.utils.AppActivityTaskManager;

/**
 * 作者： wh
 * 时间：  2018/3/10
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class App extends Application {
    public static App mInstance;
    private static final String TAG = "app";
    private static DaggerAppComponent mDaggerAppComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initComponent();

    }


    private void initComponent() {
        mDaggerAppComponent = (DaggerAppComponent) DaggerAppComponent.builder().
                appModule(new AppModule(this)).build();
    }

    public static DaggerAppComponent getDaggerAppComponent() {
        return mDaggerAppComponent;
    }

    public static void exit() {
        AppActivityTaskManager.getInstance().removeAllActivity();
    }


}
