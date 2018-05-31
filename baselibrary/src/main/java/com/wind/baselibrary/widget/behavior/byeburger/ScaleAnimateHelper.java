package com.wind.baselibrary.widget.behavior.byeburger;

import android.animation.ValueAnimator;
import android.view.View;

public class ScaleAnimateHelper implements AnimateHelper {
    public View mTarget;
    public int mCurrentState = 1;

    private ScaleAnimateHelper(View view) {
        this.mTarget = view;
    }

    public static ScaleAnimateHelper get(View view) {
        return new ScaleAnimateHelper(view);
    }

    public void show() {
        ValueAnimator va = ValueAnimator.ofFloat(new float[]{this.mTarget.getScaleX(), 1.0F});
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float scale = (Float)valueAnimator.getAnimatedValue();
                ScaleAnimateHelper.this.mTarget.setScaleX(scale);
                ScaleAnimateHelper.this.mTarget.setScaleY(scale);
            }
        });
        va.setDuration(300L);
        va.start();
        this.mCurrentState = 1;
    }

    public void hide() {
        ValueAnimator va = ValueAnimator.ofFloat(new float[]{this.mTarget.getScaleX(), 0.0F});
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float scale = (Float)valueAnimator.getAnimatedValue();
                ScaleAnimateHelper.this.mTarget.setScaleX(scale);
                ScaleAnimateHelper.this.mTarget.setScaleY(scale);
            }
        });
        va.setDuration(300L);
        va.start();
        this.mCurrentState = 0;
    }

    public void setStartY(float y) {
    }

    public void setMode(int modeBottom) {
    }

    public int getState() {
        return this.mCurrentState;
    }
}
