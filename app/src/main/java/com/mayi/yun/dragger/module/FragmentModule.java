package com.mayi.yun.dragger.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.mayi.yun.dragger.scope.ContextLife;
import com.mayi.yun.dragger.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * 作者： wh
 * 时间：  2018/3/12
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PerFragment
    @ContextLife("Activity")
    public Context provideActivityContext() {
        return fragment.getActivity();
    }

    @Provides
    @PerFragment
    public Activity provideActivity() {
        return fragment.getActivity();
    }
    @Provides
    @PerFragment
    Fragment provideFragment() {
        return fragment;
    }
}
