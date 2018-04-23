package com.mayi.yun.ui.wexin;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mayi.yun.R;
import com.mayi.yun.base.BaseFragment;
import com.mayi.yun.bean.ArticleVo;
import com.mayi.yun.bean.BannerVo;
import com.mayi.yun.utils.GlideImageLoader;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_wexin)
    RecyclerView rvWeXin;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private com.youth.banner.Banner banner;
    /**
     * 头部标题view
     */
    private View mHeadView;
    /**
     * 适配器
     */
    @Inject
    HomeArticleAdapter articleAdapter;
    /**
     * 图片列表
     */
    private List<String> linkList;
    /**
     * 标题列表
     */
    private List<String> titleList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_we_xin;
    }

    @Override
    protected void initView() {
        linkList = new ArrayList<>();
        titleList = new ArrayList<>();
        mHeadView = LayoutInflater.from(getContext()).inflate(R.layout.layout_banner_head, null);
        banner = mHeadView.findViewById(R.id.banner);
        rvWeXin.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvWeXin.setAdapter(articleAdapter);
        articleAdapter.addHeaderView(mHeadView);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        articleAdapter.setOnLoadMoreListener(this, rvWeXin);
        mPresenter.refresh();
    }

    @Override
    protected void initInject() {
        mDaggerFragmentComponent.inject(this);
    }


    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }


    @Override
    public void onLoadMoreRequested() {
        mPresenter.loadMore();
    }

    @Override
    public void setHomeBanner(List<BannerVo> bannerList) {
        List<String> imageUrlList = new ArrayList<>();
        titleList.clear();
        for (int i = 0; i < bannerList.size(); i++) {
            BannerVo banner = bannerList.get(i);
            imageUrlList.add(banner.getImagePath());
            titleList.add(banner.getTitle());
            linkList.add(banner.getUrl());
        }
        banner.setImages(imageUrlList)
                .setBannerTitles(titleList)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    @Override
    public void setHomeArticle(ArticleVo article, int loadType) {
        setLoadDataResult(articleAdapter, mSwipeRefreshLayout, article.getDatas(), loadType);
    }
}
