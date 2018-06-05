package com.wind.baselibrary.base;

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

    protected T mView;
    private LifecycleOwner lifecycleOwner;
    private AbstractContract contract;


    public void onDetache() {
        if (mView != null) {
            mView = null;
        }
    }


    public void onAttache(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;

    }




    public BasePresenter(T mView) {
        this.mView = mView;
    }


    protected <O> void obtainNetData(Observable<O> observable, HttpCallBack<O> observer) {
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
                .subscribe(observer);
    }


    protected boolean isSuccess(int errorCode) {
        if (errorCode >= 0) return true;
        return false;
    }


}
