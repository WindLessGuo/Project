package com.wind.androidplay.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wind.androidplay.R;
import com.wind.androidplay.base.PlayNormalBaseFragment;
import com.wind.baselibrary.base.NormalBaseFragment;

/**
 * @author : guo
 * @package : com.wind.androidplay.ui.fragment
 * @descrip :体系
 */
public class SystemFragment extends PlayNormalBaseFragment {


    private SmartRefreshLayout refreshLayout;
    private RecyclerView recyclerView;

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
    protected void init() {

    }

    @Override
    protected int getLayout() {
        return R.layout.play_fragment_system;
    }

    @Override
    protected void initializablePresenter() {

    }
}
