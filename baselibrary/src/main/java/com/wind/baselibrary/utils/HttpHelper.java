package com.wind.baselibrary.utils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class HttpHelper<T> implements Observer<T> {

    public abstract void onSuccess(T t);

    public abstract void onFailure(String msg);

    public abstract void onFinish();

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        onFailure(e.getMessage());
        onFinish();
    }

    @Override
    public void onComplete() {
        onFinish();
    }
}
