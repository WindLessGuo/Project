package com.wind.baselibrary.utils;

import android.arch.lifecycle.LifecycleOwner;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

public class RxLifecycleUtils {

    private RxLifecycleUtils(){
        throw new IllegalStateException("Can't instance RxLifecycleUtils");
    }


    public static <T> AutoDisposeConverter<T> bindLifeCycle(LifecycleOwner lifecycleOwner) {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner));
    }


}
