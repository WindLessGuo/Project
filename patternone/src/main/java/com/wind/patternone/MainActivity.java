package com.wind.patternone;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wind.baselibrary.base.BaseActivity;

import static com.wind.baselibrary.content.ActivityConstant.patternOneMain;


@Route(path = patternOneMain)
public class MainActivity extends BaseActivity {


    @Override
    protected int getLayoutRes() {
        return R.layout.one_activity_main;
    }

    @Override
    protected void init() {

    }
}
