package com.mayi.yun.dragger.module;

import android.content.Context;

import com.mayi.yun.App;
import com.mayi.yun.dragger.scope.ContextLife;
import com.mayi.yun.dragger.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * 作者： wh
 * 时间：  2018/3/10
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @PerApp
    @Provides
    @ContextLife("Application")
    Context provideApplicationContext() {
        return app.getApplicationContext();
    }
}
