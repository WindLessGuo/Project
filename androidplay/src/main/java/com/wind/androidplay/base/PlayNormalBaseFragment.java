package com.wind.androidplay.base;

import android.view.View;

import com.wind.androidplay.R;
import com.wind.androidplay.utils.Tags;
import com.wind.baselibrary.base.BasePresenter;
import com.wind.baselibrary.base.BaseView;
import com.wind.baselibrary.base.NormalBaseFragment;
import com.wind.baselibrary.content.PlayUiPath;

public abstract class PlayNormalBaseFragment<P extends BasePresenter>
        extends NormalBaseFragment implements Tags, BaseView,PlayUiPath {

    protected P mPresenter;
    protected View emptyView;


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

    protected View emptyView() {
        if (emptyView == null)
            emptyView = View.inflate(mActivity, R.layout.item_error_place_holder, null);
        return emptyView;
    }


}
