package com.wind.baselibrary.widget.behavior.byeburger;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

public class ByeBurgerBottomBehavior extends ByeBurgerBehavior {
    public ByeBurgerBottomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return true;
    }

    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        if (this.canInit) {
            this.canInit = false;
            this.mAnimateHelper = TranslateAnimateHelper.get(child);
            this.mAnimateHelper.setStartY(child.getY());
            this.mAnimateHelper.setMode(TranslateAnimateHelper.MODE_BOTTOM);
        }

        return super.onDependentViewChanged(parent, child, dependency);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        if (Math.abs(dy) > this.mTouchSlop) {
            if (dy < 0) {
                if (this.mAnimateHelper.getState() == 0) {
                    this.mAnimateHelper.show();
                }
            } else if (dy > 0 && this.mAnimateHelper.getState() == 1) {
                this.mAnimateHelper.hide();
            }
        }

    }
}
