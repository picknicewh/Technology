package com.mayi.yun.base;

/**
 * 作者： wh
 * 时间：  2018/3/10
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
}
