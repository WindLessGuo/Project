package com.wind.baselibrary.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.uber.autodispose.AutoDisposeConverter;
import com.wind.baselibrary.content.ActivityConstant;
import com.wind.baselibrary.utils.ActivityUtils;
import com.wind.baselibrary.utils.RxLifecycleUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutRes();

    protected abstract void init();

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        bind = ButterKnife.bind(this);
        ActivityUtils.addActivity(this);
        init();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        ActivityUtils.removeActivity(this);
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


}
