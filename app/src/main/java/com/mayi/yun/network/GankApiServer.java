package com.mayi.yun.network;

import com.mayi.yun.bean.GankVo;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * 作者： wh
 * 时间：  2018/3/12
 * 名称：干货热门
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public interface GankApiServer {

    String HOST = "http://www.gank.io/";
    /**
     * 干货数据
     * @param type 数据类型：福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * @param size 请求个数
     * @param page 页数
     */
    // Observable<GankVo> getGanHuoDatas(@Path("type") String type, @Path("size") int size, @Path("page") int page);
    @GET("api/data/{type}/{size}/{page}")
    Observable<GankVo> getGanHuoDatas(  @QueryMap Map<String,Object> params);


}
