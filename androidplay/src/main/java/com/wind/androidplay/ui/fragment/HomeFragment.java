package com.wind.androidplay.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
import com.wind.androidplay.bean.HomeBannerBean;
import com.wind.androidplay.bean.HomeListDataBean;
import com.wind.androidplay.presenter.HomeContract;
import com.wind.androidplay.presenter.HomePresenter;
import com.wind.androidplay.ui.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : guo
 * @package : com.wind.androidplay.ui.fragment
 * @descrip : 首页
 */
public class HomeFragment extends PlayNormalBaseFragment<HomePresenter> implements OnRefreshListener, OnLoadMoreListener, HomeContract.HomeView {


    private SmartRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    private int index = 0;
    private List<HomeListDataBean> mlist = new ArrayList<>();

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
        mPresenter.obtainBanner();
    }

    @Override
    protected void init() {
        refreshLayout = rootView.findViewById(R.id.refresh);
        recyclerView = rootView.findViewById(R.id.play_home_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        //设置 Header 为 Material风格
        refreshLayout.setRefreshHeader(new MaterialHeader(mActivity).setShowBezierWave(true));
        //设置 Footer 为 球脉冲
        refreshLayout.setRefreshFooter(new BallPulseFooter(mActivity).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadMoreListener(this);
        mPresenter = new HomePresenter(this);
        homeAdapter = new HomeAdapter(R.layout.play_home_adapter, mlist);
        obtainNetData();
    }

    private void obtainNetData() {
        mPresenter.obtainBanner();
        mPresenter.obtainHomeList(index);
    }

    @Override
    protected int getLayout() {
        return R.layout.play_fragment_home;
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        index = 0;
        obtainNetData();
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        index++;
        obtainNetData();
    }

    @Override
    public void showBanner(List<HomeBannerBean> list) {

    }

    @Override
    public void showHomeList(List<HomeListDataBean> list) {
        if (index == 0 && mlist.size() > 0) {
            mlist.clear();
        }
    }

    @Override
    public void dataEmpty() {

    }


}
