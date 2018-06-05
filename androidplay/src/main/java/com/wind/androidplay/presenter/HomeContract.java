package com.wind.androidplay.presenter;

import com.wind.androidplay.base.AbstractView;
import com.wind.androidplay.bean.HomeBannerBean;
import com.wind.androidplay.bean.HomeListDataBean;
import com.wind.baselibrary.base.AbstractContract;
import com.wind.baselibrary.base.BaseView;

import java.util.List;

/**
 * @author: GBX
 * @time: 14:25
 * @descrip: 首页
 */
public interface HomeContract extends BaseView {


    interface HomeView extends BaseView {
        void showBanner(List<HomeBannerBean> list);

        void showHomeList(List<HomeListDataBean> list);

        void dataEmpty();
    }

    interface Presenter {
        void obtainBanner();

        void obtainHomeList(int index);
    }

}
