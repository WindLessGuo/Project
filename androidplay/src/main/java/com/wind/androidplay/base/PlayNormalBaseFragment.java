package com.wind.androidplay.base;

import com.wind.androidplay.utils.Tags;
import com.wind.baselibrary.base.BasePresenter;
import com.wind.baselibrary.base.BaseView;
import com.wind.baselibrary.base.NormalBaseFragment;

public abstract class PlayNormalBaseFragment<P extends BasePresenter>
        extends NormalBaseFragment implements Tags ,BaseView{

    protected P mPresenter;


    protected void initPresenter() {
        initializablePresenter();
        if (mPresenter != null) {
            mPresenter.onAttache(this);
        }
    }

    protected abstract void initializablePresenter();


    @Override
    public void showError(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void closeLoading() {

    }

    @Override
    public void empty() {

    }
}
