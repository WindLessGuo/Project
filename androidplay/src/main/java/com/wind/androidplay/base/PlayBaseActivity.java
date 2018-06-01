package com.wind.androidplay.base;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.wind.androidplay.utils.Tags;
import com.wind.baselibrary.base.BaseActivity;

public abstract class PlayBaseActivity extends BaseActivity implements Tags {

    protected void showToast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int strId) {
        showToast(getString(strId));
    }



}
