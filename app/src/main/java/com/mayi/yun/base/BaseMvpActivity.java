package com.mayi.yun.base;

import android.support.annotation.Nullable;

import com.mayi.yun.App;
import com.mayi.yun.dragger.component.DaggerActivityComponent;
import com.mayi.yun.dragger.module.ActivityModule;
import com.mayi.yun.utils.G;

import javax.inject.Inject;

/**
 * 作者： wh
 * 时间：  2018/3/10
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {
    @Nullable
    @Inject
    T mPresenter;
    protected DaggerActivityComponent mDaggerActivityComponent;


    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initComponent();
        initInject();
        attachView();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detachView();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String message) {
        G.showToast(this, message);
    }

    protected abstract void initInject();

    private void initComponent() {
        mDaggerActivityComponent = (DaggerActivityComponent) DaggerActivityComponent.builder()
                .appComponent(App.getDaggerAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    /**
     * 贴上view
     */
    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 分离view
     */
    private void detachView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
