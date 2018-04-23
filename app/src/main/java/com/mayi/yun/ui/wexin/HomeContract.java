package com.mayi.yun.ui.wexin;

import com.mayi.yun.base.BasePresenter;
import com.mayi.yun.base.BaseView;
import com.mayi.yun.bean.ArticleVo;
import com.mayi.yun.bean.BannerVo;
import com.mayi.yun.utils.LoadType;

import java.util.List;

/**
 * 作者： wh
 * 时间：  2018/3/12
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public interface HomeContract {
    interface View extends BaseView {
        void setHomeBanner(List<BannerVo> bannerList);
        void setHomeArticle(ArticleVo article, @LoadType.checker int loadType);
    }

    interface Presenter extends BasePresenter<View> {
        void getHomeBanner();

        void getHomeArticle();
        void refresh();

        void loadMore();
    }
}
