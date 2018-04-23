package com.mayi.yun.ui.daily;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mayi.yun.R;
import com.mayi.yun.base.BaseFragment;
import com.mayi.yun.bean.DailyVo;
import com.mayi.yun.widget.ProgressWebView;

import butterknife.BindView;

public class DailyFragment extends BaseFragment<DailyPresenter> implements DailyContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.webView)
    ProgressWebView webView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void initView() {
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setOnRefreshListener(this);
        WebSettings settings = webView.getSettings();
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        String dir = mContext.getDir("database", Context.MODE_PRIVATE).getPath();
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(dir);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        mPresenter.getDailyVo();
    }


    @Override
    protected void initInject() {
        mDaggerFragmentComponent.inject(this);
    }


    public static DailyFragment getInstance() {
        return new DailyFragment();
    }

    @Override
    public void setDailyVo(DailyVo dailyVo) {

    }

    @Override
    public void onRefresh() {
        mPresenter.getDailyVo();
    }
}
