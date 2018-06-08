package com.wind.androidplay.presenter;

import com.wind.androidplay.base.BaseBean;
import com.wind.androidplay.bean.HomeBannerBean;
import com.wind.androidplay.bean.HomeListDataBean;
import com.wind.androidplay.net.Api;
import com.wind.baselibrary.base.BasePresenter;
import com.wind.baselibrary.base.HttpCallBack;
import com.wind.baselibrary.utils.NetManager;

import java.util.List;

/**
 * @author: GBX
 * @time: 14:29
 * @descrip:
 */
public class HomePresenter extends BasePresenter<HomeContract.HomeView> implements HomeContract.Presenter {


    public HomePresenter(HomeContract.HomeView mView) {
        super(mView);
    }

    public void obtainBanner() {
        obtainNetData(NetManager.obtainClass(Api.class).obtainHomeBannerData(),
                new HttpCallBack<BaseBean<List<HomeBannerBean>>>() {
                    @Override
                    protected void onSuccess(BaseBean<List<HomeBannerBean>> obj) {
                        if (isSuccess(obj.errorCode) && obj.data.size() > 0) {
                            mView.showBanner(obj.data);
                        } else mView.showError(obj.errorMsg);
                    }


                    @Override
                    protected void onFailer(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    protected void onFinish() {
                    }
                });
    }


    public void obtainHomeList(int index) {
        mView.showLoading();
        obtainNetData(NetManager.obtainClass(Api.class)
                        .obtainHomeListData(index),
                new HttpCallBack<BaseBean<HomeListDataBean>>() {
                    @Override
                    protected void onSuccess(BaseBean<HomeListDataBean> bean) {
                        if (isSuccess(bean.errorCode)) {
                            mView.showHomeList(bean.data);
                        } else {
                            mView.showError(bean.errorMsg);
                        }
                    }

                    @Override
                    protected void onFailer(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    protected void onFinish() {
                       // mView.closeLoading();
                    }
                });
    }


}
