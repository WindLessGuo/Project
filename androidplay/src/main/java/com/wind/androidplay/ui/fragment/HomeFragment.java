package com.wind.androidplay.ui.fragment;

import android.os.Bundle;
import android.util.Log;

import com.wind.androidplay.R;
import com.wind.androidplay.base.PlayNormalBaseFragment;

/**
 * @author : guo
 * @package : com.wind.androidplay.ui.fragment
 * @descrip : 首页
 */
public class HomeFragment extends PlayNormalBaseFragment {

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void onHidden() {
        Log.d("fragment", "onHidden");
    }

    @Override
    protected void lazyLoad() {
        Log.d("fragment", "lazyLoad");
    }

    @Override
    protected int getLayout() {
        return R.layout.play_fragment_home;
    }
}
