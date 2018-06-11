package com.wind.androidplay.ui.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wind.androidplay.R;
import com.wind.androidplay.base.PlayBaseActivity;

import static com.wind.androidplay.utils.PlayUiPath.registerActivity;

/**
 * @author: GBX
 * @time: 16:39
 * @descrip:
 */

@Route(path = registerActivity)
public class RegisterActivity extends PlayBaseActivity {
    @Override
    protected int getLayoutRes() {
        return R.layout.play_activity_register;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initPresenter() {

    }
}
