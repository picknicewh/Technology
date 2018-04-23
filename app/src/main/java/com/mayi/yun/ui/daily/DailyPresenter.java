package com.mayi.yun.ui.daily;

import com.mayi.yun.base.RxPresenter;
import com.mayi.yun.bean.DailyVo;
import com.mayi.yun.network.RetrofitManager;
import com.mayi.yun.network.RxSchedulers;
import com.mayi.yun.network.ThrowCustomer;
import com.mayi.yun.network.ZhiHuApiServer;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * 作者： wh
 * 时间：  2018/3/13
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class DailyPresenter extends RxPresenter<DailyContract.View> implements DailyContract.Presenter {
    @Inject
    public DailyPresenter() {

    }

    @Override
    public void getDailyVo() {
        addSubscible(RetrofitManager.create(ZhiHuApiServer.class, ZhiHuApiServer.HOST)
                .getZhiHu().compose(RxSchedulers.<DailyVo>applySchedulers()).subscribe(new Consumer<DailyVo>() {
                    @Override
                    public void accept(DailyVo dailyVo) throws Exception {
                        mView.setDailyVo(dailyVo);
                    }
                }, new ThrowCustomer(new ThrowCustomer.CallBack() {
                    @Override
                    public void getErrorMessage(String message) {
                        mView.showMessage(message);
                    }
                })));
    }
}
