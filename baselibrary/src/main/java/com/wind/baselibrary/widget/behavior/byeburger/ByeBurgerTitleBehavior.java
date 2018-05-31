package com.wind.baselibrary.widget.behavior.byeburger;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

public class ByeBurgerTitleBehavior extends ByeBurgerBehavior {
    public ByeBurgerTitleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        if (this.canInit) {
            this.mAnimateHelper = TranslateAnimateHelper.get(child);
            this.canInit = false;
        }

        return super.layoutDependsOn(parent, child, dependency);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        if (this.isFirstMove) {
            this.isFirstMove = false;
            this.mAnimateHelper.setStartY(child.getY());
            this.mAnimateHelper.setMode(TranslateAnimateHelper.MODE_TITLE);
        }

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
