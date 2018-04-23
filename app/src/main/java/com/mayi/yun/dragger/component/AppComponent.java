package com.mayi.yun.dragger.component;

import android.content.Context;

import com.mayi.yun.dragger.module.AppModule;
import com.mayi.yun.dragger.scope.ContextLife;
import com.mayi.yun.dragger.scope.PerApp;

import dagger.Component;

/**
 * 作者： wh
 * 时间：  2018/3/10
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
@PerApp
@Component(modules = AppModule.class)
public interface AppComponent {
    @ContextLife("Application")
    Context getApplicationContext();
}

