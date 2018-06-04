package com.wind.baselibrary.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: GBX
 * @time: 17:10
 * @descrip:
 */
public abstract class HttpCallBack<T> implements Observer<T> {

    protected abstract void onSuccess(T t);

    protected abstract void onFailer(Throwable e);

    protected abstract void onFinish();

    private Disposable d;

    public Disposable collectDisposable() {
        return d;
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }


    @Override
    public void onError(Throwable e) {
        onFailer(e);
        onFinish();
    }

    @Override
    public void onComplete() {
        onFinish();
    }
}
