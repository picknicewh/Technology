package com.mayi.yun.dragger.module;

import android.app.Activity;
import android.content.Context;

import com.mayi.yun.dragger.scope.ContextLife;
import com.mayi.yun.dragger.scope.PerActivity;

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
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return activity;
    }


    @Provides
    @PerActivity
    @ContextLife("Activity")
    Context provideActivityContext() {
        return activity;
    }

}
