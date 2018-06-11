package com.wind.androidplay.base;

import android.view.View;
import android.widget.Toast;

import com.wind.androidplay.utils.PlayUiPath;
import com.wind.androidplay.utils.Tags;
import com.wind.baselibrary.base.BaseActivity;
import com.wind.baselibrary.base.BasePresenter;
import com.wind.baselibrary.base.BaseView;

public abstract class PlayBaseActivity<B extends BasePresenter> extends
        BaseActivity implements Tags, BaseView, PlayUiPath {


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
        if (mLoadingView == null) return;
        mLoadingView.setVisibility(View.VISIBLE);
        mLoadingAnimation.setAnimation("custom_load.json");
        //mLoadingAnimation.setRepeatMode(ValueAnimator.INFINITE); 并不起作用
        mLoadingAnimation.loop(true);
        mLoadingAnimation.playAnimation();
    }


    @Override
    public void closeLoading() {
        if (mLoadingAnimation.isAnimating() && mLoadingView.getVisibility() == View.VISIBLE)
            mLoadingAnimation.cancelAnimation();
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLoadingAnimation.pauseAnimation();
        mLoadingView.setVisibility(View.GONE);
    }


    @Override
    protected void onActivityDestroy() {
        if (mLoadingAnimation != null && mLoadingView.getVisibility() == View.VISIBLE) {
            mLoadingAnimation.cancelAnimation();
            mLoadingView.setVisibility(View.GONE);
        }
    }

    @Override
    public void empty() {

    }
}
