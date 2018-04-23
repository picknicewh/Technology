package com.mayi.yun.dragger.component;

import android.content.Context;

import com.mayi.yun.dragger.module.ActivityModule;
import com.mayi.yun.dragger.scope.ContextLife;
import com.mayi.yun.dragger.scope.PerActivity;

import dagger.Component;

/**
 * 作者： wh
 * 时间：  2018/3/10
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context provideActivityContext();

    @ContextLife("Application")
    Context provideApplicationContext();

   // void inject(MainActivity mainActivity);
}
