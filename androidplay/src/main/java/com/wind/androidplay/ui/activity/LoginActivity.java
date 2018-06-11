package com.wind.androidplay.ui.activity;


import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wind.androidplay.R;
import com.wind.androidplay.base.PlayBaseActivity;
import com.wind.androidplay.presenter.LoginContrace;
import com.wind.androidplay.presenter.LoginPresenter;

import static com.wind.androidplay.utils.PlayUiPath.loginActivity;


/**
 * @author: GBX
 * @time: 14:26
 * @descrip:
 */
@Route(path = loginActivity)
public class LoginActivity extends PlayBaseActivity<LoginPresenter> implements LoginContrace.LoginView {

    private Toolbar toolbar;
    private TextView register, userName, userPass;


    @Override
    protected int getLayoutRes() {
        return R.layout.play_activity_login;
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);

        userName = findViewById(R.id.login_user_name);
        userPass = findViewById(R.id.login_user_password);

        register = findViewById(R.id.register);
        register.setText(Html.fromHtml("还没有账号？点击" + "<font color=#D20A0A>注册</font>"));
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
    protected void registerPresenter() {
        mPresenter = new LoginPresenter(this);
    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginfailure(String msg) {

    }

    public void userLogin(View view) {
        if (TextUtils.isEmpty(userName.getText().toString()) ||
                TextUtils.isEmpty(userPass.getText().toString()))
            return;

        mPresenter.login(userName.getText().toString(),
                userPass.getText().toString());


    }
}
