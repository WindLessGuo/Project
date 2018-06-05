package com.wind.androidplay.ui.fragment;

import android.os.Bundle;

import com.wind.androidplay.R;
import com.wind.androidplay.base.PlayNormalBaseFragment;
import com.wind.baselibrary.base.NormalBaseFragment;

/**
 * @author : guo
 * @package : com.wind.androidplay.ui.fragment
 * @descrip : 项目
 */
public class ProjectFragment extends PlayNormalBaseFragment {

    public static ProjectFragment newInstance() {
        ProjectFragment fragment = new ProjectFragment();
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
    protected void init() {

    }

    @Override
    protected int getLayout() {
        return R.layout.play_fragment_project;
    }

    @Override
    protected void initializablePresenter() {

    }
}
