package com.wind.androidplay.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wind.androidplay.R;
import com.wind.androidplay.base.PlayNormalBaseFragment;

/**
 * @author : guo
 * @package : com.wind.androidplay.ui.fragment
 * @descrip : 首页
 */
public class HomeFragment extends PlayNormalBaseFragment implements OnRefreshListener, OnLoadMoreListener {


    private SmartRefreshLayout refreshLayout;
    private RecyclerView recyclerView;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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
        refreshLayout = rootView.findViewById(R.id.refresh);
        recyclerView = rootView.findViewById(R.id.play_home_recycler);
        //设置 Header 为 Material风格
        refreshLayout.setRefreshHeader(new MaterialHeader(mActivity).setShowBezierWave(true));
        //设置 Footer 为 球脉冲
        refreshLayout.setRefreshFooter(new BallPulseFooter(mActivity).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadMoreListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.play_fragment_home;
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {

    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {

    }
}
