package com.mayi.yun.ui.video;

import com.mayi.yun.R;
import com.mayi.yun.base.BaseFragment;

/**
 * 作者： wh
 * 时间：  2018/3/12
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class OpenEyeVideoFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_open_eye_video;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {

    }


    public static OpenEyeVideoFragment getInstance() {
        return new OpenEyeVideoFragment();
    }
}
