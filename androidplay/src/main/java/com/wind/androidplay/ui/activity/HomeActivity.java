package com.wind.androidplay.ui.activity;

import android.app.Fragment;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.View;

import com.wind.androidplay.R;
import com.wind.androidplay.base.PlayBaseActivity;
import com.wind.androidplay.ui.fragment.HomeFragment;
import com.wind.androidplay.ui.fragment.NavigationFragment;
import com.wind.androidplay.ui.fragment.ProjectFragment;
import com.wind.androidplay.ui.fragment.SystemFragment;
import com.wind.baselibrary.utils.BottomNavigationViewHelper;

import butterknife.BindView;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 *
 */
public class HomeActivity extends PlayBaseActivity {

    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private HomeFragment homeFragment;
    private NavigationFragment navigationFragment;
    private ProjectFragment projectFragment;
    private SystemFragment systemFragment;
    private Fragment[] fragments;
    //private   android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.navigation_home:
                showFragment(transaction, homeFragment);
                return true;
            case R.id.navigation_dashboard:
                showFragment(transaction, systemFragment);
                return true;
            case R.id.navigation_notifications:
                showFragment(transaction, navigationFragment);
                return true;
            case R.id.navigation_pro:
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
        // bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        showFragment(transaction, homeFragment);

        initDrawLayout();
    }

    private void initDrawLayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(mActivity, mDrawerLayout,
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
    }


    private void showFragment(android.app.FragmentTransaction transaction, Fragment showFragment) {
        checkNotNull(fragments);


        Log.d("fragment", "transaction: " + transaction.toString());
        for (Fragment f : fragments) {
            if (f == showFragment) {
                Log.d("fragment", "showFragment: " + showFragment.toString());
                transaction.show(showFragment);
            } else transaction.hide(f);
        }
    }


}
