package com.wind.androidplay.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wind.androidplay.R;
import com.wind.androidplay.base.PlayNormalBaseFragment;
import com.wind.androidplay.bean.HomeBannerBean;
import com.wind.androidplay.bean.HomeListDataBean;
import com.wind.androidplay.presenter.HomeContract;
import com.wind.androidplay.presenter.HomePresenter;
import com.wind.androidplay.ui.adapter.HomeAdapter;
import com.wind.baselibrary.utils.BannerGlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

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
    private List<HomeListDataBean.DatasBean> mlist = new ArrayList<>();
    private Banner banner;

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
        obtainNetData();
    }

    private void obtainNetData() {
        mPresenter.obtainBanner();
        mPresenter.obtainHomeList(index);
    }

    @Override
    protected void init() {
        refreshLayout = rootView.findViewById(R.id.refresh);
        recyclerView = rootView.findViewById(R.id._recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        //数据 只有一列的情况下（未超过一屏）
        refreshLayout.setEnableLoadMoreWhenContentNotFull(true);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadMoreListener(this);

        homeAdapter = new HomeAdapter(R.layout.play_item_home_adapter, mlist);
        View headerView = View.inflate(mActivity, R.layout.play_item_home_banner, null);
        banner = headerView.findViewById(R.id.banner);
        homeAdapter.addHeaderView(headerView);
        homeAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        homeAdapter.setOnItemClickListener((adapter, view, position)
                -> skipView(mlist.get(position).getLink(),
                mlist.get(position).getTitle(), false));
        recyclerView.setAdapter(homeAdapter);
        obtainNetData();
    }

    @Override
    protected int getLayout() {
        return R.layout.play_fragment_home;
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        index = 0;
        mPresenter.obtainHomeList(index);
        refreshLayout.finishRefresh(1000);
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        index++;
        mPresenter.obtainHomeList(index);
        refreshLayout.finishLoadMore(1000);
    }

    @Override
    public void showBanner(List<HomeBannerBean> list) {
        List<String> imgUrls = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (HomeBannerBean bean : list) {
            imgUrls.add(bean.getImagePath());
            titles.add(bean.getTitle());
        }
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new BannerGlideImageLoader());
        //设置图片集合
        banner.setImages(imgUrls);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.ForegroundToBackground);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(list.size() * 300);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setOnBannerListener(i ->
                skipView(list.get(i).getUrl(), list.get(i).getTitle(), true));
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    private void skipView(String url, String mTitle, boolean s) {
        ARouter.getInstance().build(webViewActivity)
                .withString(linkUrl, url)
                .withString(title, mTitle)
                .withBoolean(isBanner, s).navigation();
    }

    @Override
    public void showHomeList(HomeListDataBean bean) {
        if (index == 0 && mlist.size() > 0) {
            mlist.clear();
            mlist.addAll(bean.getDatas());
            homeAdapter.replaceData(mlist);
        } else {
            mlist.addAll(bean.getDatas());
            homeAdapter.addData(bean.getDatas());
        }
    }


    @Override
    public void showError(String msg) {
        super.showError(msg);
        if (index == 0)
            refreshLayout.finishRefresh(false);
        else refreshLayout.finishLoadMore(false);
    }

    @Override
    public void dataEmpty() {

    }


    @Override
    protected void initializablePresenter() {
        mPresenter = new HomePresenter(this);
    }
}
