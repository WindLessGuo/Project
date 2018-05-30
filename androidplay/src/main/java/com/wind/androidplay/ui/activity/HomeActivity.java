package com.wind.androidplay.ui.activity;

import android.support.design.widget.BottomNavigationView;
import android.widget.FrameLayout;

import com.wind.androidplay.R;
import com.wind.androidplay.ui.fragment.HomeFragment;
import com.wind.androidplay.ui.fragment.NavigationFragment;
import com.wind.androidplay.ui.fragment.ProjectFragment;
import com.wind.androidplay.ui.fragment.SystemFragment;
import com.wind.baselibrary.base.BaseActivity;

import butterknife.BindView;

/**
 *
 */
public class HomeActivity extends BaseActivity {

    @BindView(R.id.navigation) BottomNavigationView navigation;

    @BindView(R.id.fragment_container) FrameLayout container;

    private HomeFragment homeFragment;
    private NavigationFragment navigationFragment;
    private ProjectFragment projectFragment;
    private SystemFragment systemFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                return true;
            case R.id.navigation_dashboard:
                return true;
            case R.id.navigation_notifications:
                return true;
            case R.id.navigation_pro:
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
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


}
