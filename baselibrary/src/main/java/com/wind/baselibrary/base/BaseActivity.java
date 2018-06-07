package com.wind.baselibrary.base;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.uber.autodispose.AutoDisposeConverter;
import com.wind.baselibrary.R;
import com.wind.baselibrary.utils.ActivityUtils;
import com.wind.baselibrary.utils.RxLifecycleUtils;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutRes();

    protected abstract void init();

    protected Activity mActivity;


    protected ViewGroup mViewGroup;
    protected View mLoadingView;
    protected LottieAnimationView mLoadingAnimation;


    // private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewGroup = (ViewGroup) ViewGroup.inflate(this, getLayoutRes(), null);
        View.inflate(this, R.layout.loading_view, mViewGroup);
        mLoadingView = mViewGroup.findViewById(R.id.loading_group);
        mLoadingAnimation = mLoadingView.findViewById(R.id.loading_animation);
        setContentView(mViewGroup);
        mLoadingView.setVisibility(View.GONE);
        mActivity = this;
        ActivityUtils.addActivity(this);
        init();
        initPresenter();
    }

    protected abstract void initPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtils.removeActivity(this);
        onActivityDestroy();
    }

    protected void onActivityDestroy() {

    }

    /**
     * 进行生命周期绑定，防止内存泄露
     *
     * @param <T>
     * @return
     */
    protected <T> AutoDisposeConverter<T> bindLife() {
        return RxLifecycleUtils.bindLifeCycle(this);
    }


    protected void showToast(String str) {
        Toast.makeText(mActivity, str, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int strId) {
        showToast(getString(strId));
    }


}
