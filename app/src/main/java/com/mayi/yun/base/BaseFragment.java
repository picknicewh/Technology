package com.mayi.yun.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mayi.yun.App;
import com.mayi.yun.dragger.component.DaggerFragmentComponent;
import com.mayi.yun.dragger.module.FragmentModule;
import com.mayi.yun.utils.Constants;
import com.mayi.yun.utils.G;
import com.mayi.yun.utils.LoadType;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者： wh
 * 时间：  2018/3/10
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public  abstract class BaseFragment<T extends RxPresenter> extends Fragment implements BaseView {

    @Nullable
    @Inject
    public T mPresenter;
    private Unbinder mUnBinder;
    protected Activity mActivity;
    protected Context mContext;
    public DaggerFragmentComponent mDaggerFragmentComponent;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(getLayoutId(), null);
        mUnBinder = ButterKnife.bind(this, mView);
        init();
        initInject();
        attachView();
        initView();
        return mView;
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initInject();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
        detachView();
    }

    private void init() {
        mDaggerFragmentComponent = (DaggerFragmentComponent) DaggerFragmentComponent.builder()
                .appComponent(App.getDaggerAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String message) {
        G.showToast(mContext,message);
    }
    public void setLoadDataResult(BaseQuickAdapter baseQuickAdapter, SwipeRefreshLayout swipeRefreshLayout, List list, @LoadType.checker int loadType) {
        switch (loadType) {
            case LoadType.TYPE_REFRESH_SUCCESS:
                baseQuickAdapter.setNewData(list);
                swipeRefreshLayout.setRefreshing(false);
                break;
            case LoadType.TYPE_REFRESH_ERROR:
                swipeRefreshLayout.setRefreshing(false);
                break;
            case LoadType.TYPE_LOAD_MORE_SUCCESS:
                if (list != null) {
                    baseQuickAdapter.addData(list);
                }
                break;
            case LoadType.TYPE_LOAD_MORE_ERROR:
                baseQuickAdapter.loadMoreFail();
                break;
        }
        if (list == null || list.isEmpty() || list.size() < Constants.PAGE_SIZE) {
            baseQuickAdapter.loadMoreEnd(false);
        } else {
            baseQuickAdapter.loadMoreComplete();
        }

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
