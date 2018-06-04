package com.wind.baselibrary.base;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.uber.autodispose.AutoDisposeConverter;
import com.wind.baselibrary.utils.ActivityUtils;
import com.wind.baselibrary.utils.RxLifecycleUtils;

public abstract class BaseActivity<B extends BasePresenter>
        extends AppCompatActivity implements BaseView {

    protected abstract int getLayoutRes();

    protected abstract void init();

    protected Activity mActivity;

    protected B mPresenter;

    // private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        mActivity = this;
        // bind = ButterKnife.bind(this);
        ActivityUtils.addActivity(this);
        init();
        initPresenter();
    }

    private void initPresenter() {
        if (mPresenter != null) {
            mPresenter.onAttache(this, this);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //bind.unbind();
        ActivityUtils.removeActivity(this);
        if (mPresenter != null) mPresenter.onDetache();
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


    @Override
    public void setPresenter(AbstractContract presenter) {

    }

    @Override
    public void showError(String msg) {

    }
}
