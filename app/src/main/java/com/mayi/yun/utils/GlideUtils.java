package com.mayi.yun.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 作者： wh
 * 时间：  2018/3/12
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class GlideUtils {

    /**
     * 默认加载
     * @param  mContext 上下文本
     * @param  path 图片路径
     *@param  mImageView 图片控件
     */
    public static void loadImageView(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).into(mImageView);

    }
}
