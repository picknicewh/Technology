package com.mayi.yun;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.mayi.yun.base.BaseFragment;
import com.mayi.yun.ui.collect.MyCollectFragment;
import com.mayi.yun.ui.daily.DailyFragment;
import com.mayi.yun.ui.hotstudy.HotStudyFragment;
import com.mayi.yun.ui.video.OpenEyeVideoFragment;
import com.mayi.yun.ui.wexin.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;

    private List<BaseFragment> fragmentList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }
    protected void initView() {
        setSupportActionBar(toolbar);
        setTitle(R.string.home);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
        navView.setCheckedItem(R.id.item_weixin);
        initFragment();

    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(HomeFragment.getInstance());
        fragmentList.add(DailyFragment.getInstance());
        fragmentList.add(HotStudyFragment.getInstance());
        fragmentList.add(OpenEyeVideoFragment.getInstance());
        fragmentList.add(MyCollectFragment.getInstance());
        switchFragment(0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_weixin:
                toolbar.setTitle(R.string.home);
                switchFragment(0);
                break;
            case R.id.item_one:
                toolbar.setTitle(R.string.one);
                switchFragment(1);
                break;
            case R.id.item_ganhot:
                toolbar.setTitle(R.string.gan_hot);
                switchFragment(2);
                break;
            case R.id.item_eye_petizer:
                toolbar.setTitle(R.string.eye_petizer);
                switchFragment(3);
                break;
            case R.id.item_collect:
                toolbar.setTitle(R.string.collect);
                switchFragment(4);
                break;
            case R.id.item_about:
                toolbar.setTitle(R.string.about);
                break;
        }
        mDrawerLayout.closeDrawers();
        return true;
    }

    private int currentPosition = 0;

    public void switchFragment(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        BaseFragment targetFragment = fragmentList.get(position);
        BaseFragment lastFragment = fragmentList.get(currentPosition);
        currentPosition = position;
        transaction.hide(lastFragment);
        if (!targetFragment.isAdded()) {
            transaction.add(R.id.content, targetFragment);
        }
        transaction.show(targetFragment);
        transaction.commit();
    }
}

