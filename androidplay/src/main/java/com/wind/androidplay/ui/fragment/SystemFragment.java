package com.wind.androidplay.ui.fragment;

import android.os.Bundle;

import com.wind.baselibrary.base.NormalBaseFragment;

/**
 * @author : guo
 * @package : com.wind.androidplay.ui.fragment
 * @descrip :体系
 */
public class SystemFragment extends NormalBaseFragment {

    public static SystemFragment newInstance() {
        SystemFragment fragment = new SystemFragment();
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