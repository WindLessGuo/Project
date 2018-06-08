package com.wind.androidplay.base;

import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.wind.androidplay.R;
import com.wind.androidplay.utils.Tags;
import com.wind.baselibrary.base.BasePresenter;
import com.wind.baselibrary.base.BaseView;
import com.wind.baselibrary.base.NormalBaseFragment;
import com.wind.baselibrary.content.PlayUiPath;

public abstract class PlayNormalBaseFragment<P extends BasePresenter>
        extends NormalBaseFragment implements Tags, BaseView, PlayUiPath {

    protected P mPresenter;
    protected View emptyView;


    private LottieAnimationView mLoadingAnimation;
    private View mLoadingView;
    private ViewGroup mNormalView;


    protected void initPresenter() {
        initializablePresenter();
        if (mPresenter != null) {
            mPresenter.onAttache(this);
        }
    }


    @Override
    protected void initializeLoading(View rootView) {
        if (rootView == null) return;
        mNormalView = rootView.findViewById(R.id.common_view);
        if (mNormalView == null) {
            throw new IllegalStateException(
                    "The subclass of RootActivity must contain a View named 'mNormalView'.");
        }
        if (!(mNormalView.getParent() instanceof ViewGroup)) {
            throw new IllegalStateException(
                    "mNormalView's ParentView should be a ViewGroup.");
        }


        ViewGroup parent = (ViewGroup) mNormalView.getParent();
        View.inflate(mActivity, R.layout.loading_view, parent);
        // View.inflate(_mActivity, R.layout.error_view, parent);
        mLoadingView = parent.findViewById(R.id.loading_group);
        // mErrorView = parent.findViewById(R.id.error_group);
        //TextView reloadTv = mErrorView.findViewById(R.id.error_reload_tv);
        // reloadTv.setOnClickListener(v -> reload());
        mLoadingAnimation = mLoadingView.findViewById(R.id.loading_animation);
        //mErrorView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.GONE);
        mNormalView.setVisibility(View.VISIBLE);
    }


    protected abstract void initializablePresenter();


    @Override
    public void showError(String msg) {

    }

    @Override
    public void showLoading() {
        if (!canShowing) {
            if (mLoadingView == null) return;
            mLoadingView.setVisibility(View.VISIBLE);
            mLoadingAnimation.setAnimation("custom_load.json");
            //mLoadingAnimation.setRepeatMode(ValueAnimator.INFINITE); 并不起作用
            mLoadingAnimation.loop(true);
            mLoadingAnimation.playAnimation();
        }
    }

    @Override
    public void closeLoading() {
        if (mLoadingAnimation.isAnimating() && mLoadingView.getVisibility() == View.VISIBLE)
            mLoadingAnimation.cancelAnimation();
        mLoadingView.setVisibility(View.GONE);
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
