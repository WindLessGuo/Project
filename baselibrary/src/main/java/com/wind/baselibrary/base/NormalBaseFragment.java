package com.wind.baselibrary.base;

import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.wind.baselibrary.R;

/**
 * @author ：老中医
 * @create ：2016/10/21 17:34
 * @description ：NormalBaseFragment
 */

public abstract class NormalBaseFragment extends BaseFragment {
    protected boolean canShowing;

    /**
     * false == 未隐藏
     * true == 隐藏
     *
     * @param hidden
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        canShowing = hidden;
        if (hidden) onHidden();
        else lazyLoad();
    }

    protected abstract void onHidden();

    protected abstract void lazyLoad();


}
