package com.wind.androidplay.base;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.wind.androidplay.utils.Tags;
import com.wind.baselibrary.base.BaseActivity;
import com.wind.baselibrary.base.BasePresenter;
import com.wind.baselibrary.base.BaseView;

public abstract class PlayBaseActivity<B extends BasePresenter> extends
        BaseActivity implements Tags, BaseView {


    protected B mPresenter;


    protected void initPresenter() {
        if (mPresenter != null) {
            mPresenter.onAttache(this);
        }
    }

    protected void showToast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int strId) {
        showToast(getString(strId));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDetache();
    }


    @Override
    public void showError(String msg) {
        showToast(msg);
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
