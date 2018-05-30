package com.wind.androidplay.ui.fragment;

import android.os.Bundle;

import com.wind.baselibrary.base.BaseFragment;
import com.wind.baselibrary.base.NormalBaseFragment;

/**
 * @author : guo
 * @package : com.wind.androidplay.ui.fragment
 * @descrip :导航
 */
public class NavigationFragment extends NormalBaseFragment {

    public static NavigationFragment newInstance() {
        NavigationFragment fragment = new NavigationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void onHidden() {

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getLayout() {
        return 0;
    }
}
