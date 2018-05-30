package com.wind.baselibrary.base;

/**
 * @author ：老中医
 * @create ：2016/10/21 17:29
 * @description ：ViewPagerBaseFragment
 */

public abstract class ViewPagerBaseFragment extends BaseFragment {
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) lazyLoad();
        else onHidden();
    }

    protected abstract void onHidden();

    protected abstract void lazyLoad();


}
