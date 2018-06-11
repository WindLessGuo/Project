package com.wind.androidplay.ui.activity;


import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wind.androidplay.R;
import com.wind.androidplay.base.PlayBaseActivity;

import static com.wind.androidplay.utils.PlayUiPath.loginActivity;


/**
 * @author: GBX
 * @time: 14:26
 * @descrip:
 */
@Route(path = loginActivity)
public class LoginActivity extends PlayBaseActivity {

    private Toolbar toolbar;
    private TextView register;


    @Override
    protected int getLayoutRes() {
        return R.layout.play_activity_login;
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        register = findViewById(R.id.register);
        register.setText("还未登录过？可以选择" + Html.fromHtml("<font color=#D20A0A>注册</font>"));
        register.setOnClickListener(v ->
                ARouter.getInstance().build(registerActivity).navigation());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            LoginActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initPresenter() {

    }
}
