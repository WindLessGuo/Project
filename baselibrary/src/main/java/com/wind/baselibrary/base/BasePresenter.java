package com.wind.baselibrary.base;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: GBX
 * @time: 16:53
 * @descrip:
 */
public abstract class BasePresenter<T extends BaseView> {

    private T mView;
    private LifecycleOwner lifecycleOwner;


    protected void onDetache() {
        if (mView != null) {
            mView = null;
        }
    }


    public void onAttache(T mView, LifecycleOwner lifecycleOwner) {
        this.mView = mView;
        this.lifecycleOwner = lifecycleOwner;
        initContract(this.mView);
    }

    protected abstract void initContract(T mView);


    protected <O> void obtainNetData(Observable<O> observable, HttpCallBack<O> observer) {
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
                .subscribe(observer);
    }


}
