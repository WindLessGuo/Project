package com.wind.androidplay.presenter;

import com.wind.androidplay.bean.HomeBannerBean;
import com.wind.androidplay.bean.HomeListDataBean;
import com.wind.baselibrary.base.AbstractContract;
import com.wind.baselibrary.base.BaseView;

/**
 * @author: GBX
 * @time: 14:25
 * @descrip: 首页
 */
public interface HomeContract {

    interface HomeView extends BaseView<Presenter> {
    }


    interface Presenter extends AbstractContract {
        void obtainBanner(HomeBannerBean bannerBean);

        void obtainHomeList(HomeListDataBean bean);
    }


}
