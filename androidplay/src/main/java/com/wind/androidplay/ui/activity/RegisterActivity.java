package com.wind.androidplay.ui.activity;

import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wind.androidplay.R;
import com.wind.androidplay.base.PlayBaseActivity;
import com.wind.androidplay.presenter.RegisterContract;
import com.wind.androidplay.presenter.RegisterPresenter;


import static com.wind.androidplay.utils.PlayUiPath.registerActivity;

/**
 * @author: GBX
 * @time: 16:39
 * @descrip:
 */

@Route(path = registerActivity)
public class RegisterActivity extends PlayBaseActivity<RegisterPresenter> implements RegisterContract.RegisterView {

    private AutoCompleteTextView registerEmail, registerPass, registerPassAgain;


    @Override
    protected int getLayoutRes() {
        return R.layout.play_activity_register;
    }

    @Override
    protected void init() {
        registerEmail = findViewById(R.id.register_email);
        registerPass = findViewById(R.id.register_pass);
        registerPassAgain = findViewById(R.id.register_pass_again);
    }



    @Override
    protected void registerPresenter() {
        mPresenter = new RegisterPresenter(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            RegisterActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void userRegister(View v) {
        if (TextUtils.isEmpty(registerEmail.getText().toString()) ||
                TextUtils.isEmpty(registerPass.getText().toString()) ||
                TextUtils.isEmpty(registerPassAgain.getText().toString())) {
            return;
        }


        if (!TextUtils.equals(registerPass.getText().toString(),
                registerPassAgain.getText().toString())) {
            return;
        }

        mPresenter.userRegister(registerEmail.getText().toString(),
                registerPass.getText().toString(),
                registerPassAgain.getText().toString());

    }


    @Override
    public void registerSuccess() {
        showToast("恭喜您，注册成功！");
        RegisterActivity.this.finish();
    }
}
