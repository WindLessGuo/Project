package com.wind.androidplay.ui.activity;

import android.app.Fragment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.wind.androidplay.R;
import com.wind.androidplay.base.PlayBaseActivity;
import com.wind.androidplay.ui.fragment.HomeFragment;
import com.wind.androidplay.ui.fragment.NavigationFragment;
import com.wind.androidplay.ui.fragment.ProjectFragment;
import com.wind.androidplay.ui.fragment.SystemFragment;
import com.wind.baselibrary.utils.ActivityUtils;
import com.wind.baselibrary.utils.BottomNavigationViewHelper;

import static com.google.common.base.Preconditions.checkNotNull;


public class HomeActivity extends PlayBaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    DrawerLayout mDrawerLayout;
    Toolbar toolbar;
    TextView title;
    NavigationView mNavigationView;

    private HomeFragment homeFragment;
    private NavigationFragment navigationFragment;
    private ProjectFragment projectFragment;
    private SystemFragment systemFragment;
    private Fragment[] fragments;
    private boolean isExit;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();


        int i = item.getItemId();
        if (i == R.id.play_navigation_home) {
            title.setText(getString(R.string.play_main_home));
            //开启手势滑动
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            showFragment(transaction, homeFragment);
            return true;
        } else if (i == R.id.play_navigation_dashboard) {
            title.setText(getString(R.string.play_main_system));
            mDrawerLayout.closeDrawers();
            //关闭手势滑动
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            showFragment(transaction, systemFragment);
            return true;
        } else if (i == R.id.play_navigation_notifications) {
            title.setText(getString(R.string.play_main_navigation));
            mDrawerLayout.closeDrawers();
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            showFragment(transaction, navigationFragment);
            return true;
        } else if (i == R.id.play_navigation_pro) {
            title.setText(getString(R.string.play_main_project));
            mDrawerLayout.closeDrawers();
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            showFragment(transaction, projectFragment);
            return true;
        }
        return false;
    };


    @Override
    protected int getLayoutRes() {
        return R.layout.play_activity_home;
    }

    @Override
    protected void init() {
        initViews();
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowTitleEnabled(false);

        title.setText(getString(R.string.play_main_home));

        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        homeFragment = HomeFragment.newInstance();
        transaction.add(R.id.fragment_container, homeFragment, homeFragmentTag);

        navigationFragment = NavigationFragment.newInstance();
        transaction.add(R.id.fragment_container, navigationFragment, navigationFragmentTag);

        projectFragment = ProjectFragment.newInstance();
        transaction.add(R.id.fragment_container, projectFragment, projectFragmentTag);

        systemFragment = SystemFragment.newInstance();
        transaction.add(R.id.fragment_container, systemFragment, systemFragmentTag);
        transaction.commit();

        fragments = new Fragment[]{homeFragment, navigationFragment, projectFragment, systemFragment};

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        bottomNavigationView.setSelectedItemId(R.id.play_navigation_home);
        initDrawLayout();
    }

    private void initViews() {
        bottomNavigationView = findViewById(R.id.play_bottom_navigation_view);
        mDrawerLayout = findViewById(R.id.play_drawer_layout);
        toolbar = findViewById(R.id.play_toolbar);
        title = findViewById(R.id.play_main_title);
        mNavigationView = findViewById(R.id.play_navigation);
    }


    private void initDrawLayout() {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(mActivity, mDrawerLayout,
                toolbar,
                R.string.play_navigation_drawer_open, R.string.play_navigation_drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                //获取mDrawerLayout中的第一个子布局，也就是布局中的RelativeLayout
                //获取抽屉的view
                View mContent = mDrawerLayout.getChildAt(0);
                float scale = 1 - slideOffset;
                float endScale = 0.8f + scale * 0.2f;
                float startScale = 1 - 0.3f * scale;

                //设置左边菜单滑动后的占据屏幕大小
                drawerView.setScaleX(startScale);
                drawerView.setScaleY(startScale);
                //设置菜单透明度
                drawerView.setAlpha(0.6f + 0.4f * (1 - scale));

                //设置内容界面水平和垂直方向偏转量
                //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
                mContent.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
                //设置内容界面操作无效（比如有button就会点击无效）
                mContent.invalidate();
                //设置右边菜单滑动后的占据屏幕大小
                mContent.setScaleX(endScale);
                mContent.setScaleY(endScale);
            }
        };
        toggle.syncState();
        mDrawerLayout.addDrawerListener(toggle);
        mNavigationView.setNavigationItemSelectedListener(this);
    }


    private void showFragment(android.app.FragmentTransaction transaction, Fragment showFragment) {
        checkNotNull(fragments);
        for (Fragment f : fragments) {
            if (f == showFragment) {
                transaction.show(showFragment);
            } else transaction.hide(f);
        }
        transaction.commit();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
                mDrawerLayout.closeDrawer(GravityCompat.START);
            else {
                if (!isExit) {
                    showToast(R.string.play_main_exit);
                    isExit = !isExit;
                    new Handler().postDelayed(() -> isExit = !isExit, 2000);
                } else {
                    ActivityUtils.removeAll();
                    finish();
                }
            }
            return false;
        } else return super.onKeyDown(keyCode, event);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.play_menu_home_toolbar, menu);
        return true;
    }

    //toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.action_usage) {
        } else if (i == R.id.action_search) {

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else super.onBackPressed();
    }


    //drawerlayout
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
        }
        return true;
    }
}
