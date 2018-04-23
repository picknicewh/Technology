package com.mayi.yun.dragger.component;

import android.app.Activity;
import android.content.Context;

import com.mayi.yun.dragger.module.FragmentModule;
import com.mayi.yun.dragger.scope.ContextLife;
import com.mayi.yun.dragger.scope.PerFragment;
import com.mayi.yun.ui.daily.DailyFragment;
import com.mayi.yun.ui.wexin.HomeFragment;

import dagger.Component;

/**
 * 作者： wh
 * 时间：  2018/3/12
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
@PerFragment
@Component(dependencies = AppComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {
    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(HomeFragment weXinFragment);

   void inject(DailyFragment dailyFragment);
   // void inject( HotStudyFragment hotStudyFragment);
   // void inject(OpenEyeVideoFragment  openEyeVideoFragment);
   // void inject(MyCollectFragment myCollectFragment);
}
