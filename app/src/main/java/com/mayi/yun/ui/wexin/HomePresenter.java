package com.mayi.yun.ui.wexin;

import com.mayi.yun.base.RxPresenter;
import com.mayi.yun.bean.ArticleVo;
import com.mayi.yun.bean.BannerVo;
import com.mayi.yun.bean.Result;
import com.mayi.yun.network.RetrofitManager;
import com.mayi.yun.network.RxSchedulers;
import com.mayi.yun.network.ThrowCustomer;
import com.mayi.yun.network.WeXinApiServer;
import com.mayi.yun.utils.G;
import com.mayi.yun.utils.LoadType;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * 作者： wh
 * 时间：  2018/3/12
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class HomePresenter extends RxPresenter<HomeContract.View> implements HomeContract.Presenter {
    private int mPage = 0;
    private boolean mIsRefresh;

    @Inject
    public HomePresenter() {
        mIsRefresh = true;
    }

    @Override
    public void getHomeBanner() {
        RetrofitManager.create(WeXinApiServer.class, WeXinApiServer.HOST).
                getHomeBanners()
                .compose(RxSchedulers.<Result<List<BannerVo>>>applySchedulers())
                .subscribe(new Consumer<Result<List<BannerVo>>>() {
                    @Override
                    public void accept(Result<List<BannerVo>> listResult) throws Exception {
                        List<BannerVo> bannerList = listResult.getData();
                        mView.setHomeBanner(bannerList);
                    }
                }, new ThrowCustomer(new ThrowCustomer.CallBack() {
                    @Override
                    public void getErrorMessage(String message) {
                        G.log("xxx" + message);
                        mView.showMessage(message);
                    }
                }));
    }

    @Override
    public void getHomeArticle() {
        RetrofitManager.create(WeXinApiServer.class, WeXinApiServer.HOST).getHomeArticles(mPage)
                .compose(RxSchedulers.<Result<ArticleVo>>applySchedulers())
                .subscribe(new Consumer<Result<ArticleVo>>() {
                    @Override
                    public void accept(Result<ArticleVo> articleResult) throws Exception {
                        ArticleVo article = articleResult.getData();
                        @LoadType.checker int loadType = mIsRefresh ? LoadType.TYPE_REFRESH_SUCCESS : LoadType.TYPE_LOAD_MORE_SUCCESS;
                        mView.setHomeArticle(article, loadType);
                    }
                }, new ThrowCustomer(new ThrowCustomer.CallBack() {
                    @Override
                    public void getErrorMessage(String message) {
                        @LoadType.checker int loadType = mIsRefresh ? LoadType.TYPE_REFRESH_ERROR : LoadType.TYPE_LOAD_MORE_ERROR;
                        mView.setHomeArticle(new ArticleVo(), loadType);
                    }
                }));
    }

    @Override
    public void refresh() {
        mPage = 0;
        mIsRefresh = true;
        getHomeBanner();
        getHomeArticle();
    }

    @Override
    public void loadMore() {
        mPage++;
        mIsRefresh = false;
        getHomeArticle();
    }
}
