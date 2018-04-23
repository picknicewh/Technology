package com.mayi.yun.network;

import com.mayi.yun.bean.DailyVo;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 作者： wh
 * 时间：  2018/3/12
 * 名称：知乎日报
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public interface ZhiHuApiServer {

    String HOST = "https://news-at.zhihu.com/";
    /**
     * 最新消息最新消息
     *
     * @return
     */
    @GET("api/4/news/latest")
    Observable<DailyVo> getZhiHu();
}
