package com.wind.androidplay.utils;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.wind.androidplay.R;

import io.reactivex.disposables.Disposable;

/**
 * @author: GBX
 * @time: 10:23
 * @descrip:
 */
public class Loading {

    private static Dialog dialog;
    private static LottieAnimationView view;


    public static Dialog showLoading(Context context) {
        if (view != null && view.isAnimating()) {
            view.cancelAnimation();
            view = null;
        }

        if (dialog != null) {
            if (dialog.isShowing()) dialog.dismiss();
            dialog = null;

        }

        dialog = new Dialog(context);
        dialog.setContentView(com.wind.baselibrary.R.layout.loading_view);

        view = dialog.findViewById(R.id.loading_animation);
        view.setAnimation("custom_load.json");
        //mLoadingAnimation.setRepeatMode(ValueAnimator.INFINITE); 并不起作用
        view.loop(true);
        view.playAnimation();
        dialog.show();
        return dialog;
    }


    public static void closeLoading() {
        if (view != null) {
            if (view.isAnimating()) view.cancelAnimation();
            view = null;
        }

        if (dialog != null) {
            if (dialog.isShowing()) dialog.dismiss();
            dialog = null;
        }


    }


}
