package com.wind.androidplay.presenter;

import com.wind.androidplay.base.BaseBean;
import com.wind.androidplay.net.Api;
import com.wind.baselibrary.base.BasePresenter;
import com.wind.baselibrary.base.HttpCallBack;
import com.wind.baselibrary.utils.NetManager;

/**
 * @author : guo
 * @package : com.wind.androidplay.presenter
 * @descrip :
 */
public class LoginPresenter extends
        BasePresenter<LoginContrace.LoginView> implements LoginContrace.Presenter {

    public LoginPresenter(LoginContrace.LoginView mView) {
        super(mView);
    }


    @Override
    public void login(String name, String pass) {
        mView.showLoading();

        obtainNetData(NetManager.obtainClass(Api.class)
                .userLogin(name, pass), new HttpCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean baseBean) {
                if (isSuccess(baseBean.errorCode)) {
                    mView.loginSuccess();
                } else mView.loginfailure(baseBean.errorMsg);
            }

            @Override
            protected void onFailure(Throwable e) {
                mView.showError(e.getMessage());
            }

            @Override
            protected void onFinish() {
                mView.closeLoading();
            }
        });

    }
}
