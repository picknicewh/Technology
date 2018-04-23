package com.mayi.yun.ui.daily;

import com.mayi.yun.base.BasePresenter;
import com.mayi.yun.base.BaseView;
import com.mayi.yun.bean.DailyVo;

/**
 * 作者： wh
 * 时间：  2018/3/13
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public interface DailyContract {
    interface View extends BaseView{
      void setDailyVo(DailyVo dailyVo );
    }
    interface Presenter extends BasePresenter<View>{
        void getDailyVo();
    }
}
