package com.mayi.yun.ui.hotstudy;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.mayi.yun.R;
import com.mayi.yun.base.BaseFragment;

import butterknife.BindView;

public class HotStudyFragment extends BaseFragment {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot_study;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {

    }

    public static HotStudyFragment getInstance() {
        return new HotStudyFragment();
    }


}
