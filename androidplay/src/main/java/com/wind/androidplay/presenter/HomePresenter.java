package com.wind.androidplay.presenter;

import com.wind.androidplay.bean.HomeBannerBean;
import com.wind.androidplay.bean.HomeListDataBean;
import com.wind.androidplay.net.Api;
import com.wind.baselibrary.base.BasePresenter;
import com.wind.baselibrary.base.HttpCallBack;
import com.wind.baselibrary.utils.NetManager;

/**
 * @author: GBX
 * @time: 14:29
 * @descrip:
 */
public class HomePresenter extends BasePresenter<HomeContract.HomeView> implements HomeContract.Presenter {

    private HomeContract.HomeView mView;


    @Override
    public void obtainBanner(HomeBannerBean bannerBean) {
        obtainNetData(NetManager.obtainClass(Api.class).obtainHomeBannerData(),
                new HttpCallBack<HomeBannerBean>() {
                    @Override
                    protected void onSuccess(HomeBannerBean bannerBean) {

                    }

                    @Override
                    protected void onFailer(Throwable e) {

                    }

                    @Override
                    protected void onFinish() {

                    }
                });
    }

    @Override
    public void obtainHomeList(HomeListDataBean bean) {

    }


    @Override
    protected void initContract(HomeContract.HomeView mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }
}
