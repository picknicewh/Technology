package com.mayi.yun.ui.wexin;

import android.text.Html;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mayi.yun.R;
import com.mayi.yun.bean.ArticleVo;
import com.mayi.yun.utils.G;

import javax.inject.Inject;

/**
 * 作者： wh
 * 时间：  2018/3/12
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class HomeArticleAdapter extends BaseQuickAdapter<ArticleVo.DatasBean, BaseViewHolder> {

    @Inject
    public HomeArticleAdapter() {
        super(R.layout.item_article, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleVo.DatasBean article) {
        G.log("abc=="+article.getTitle());
        helper.setText(R.id.tv_time, article.getNiceDate());
        helper.setText(R.id.tv_title, Html.fromHtml(article.getTitle()));
        helper.setText(R.id.tv_from, article.getChapterName());
        helper.setText(R.id.tv_content, article.getAuthor());
        //   helper.setImageBitmap(  R.id.civ_image ,)
    }

}