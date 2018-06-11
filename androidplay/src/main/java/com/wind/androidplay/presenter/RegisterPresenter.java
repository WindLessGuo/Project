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
public class RegisterPresenter extends
        BasePresenter<RegisterContract.RegisterView>
        implements RegisterContract.RegisterPresenter {

    public RegisterPresenter(RegisterContract.RegisterView mView) {
        super(mView);
    }

    @Override
    public void userRegister(String username, String password, String repassword) {
        mView.showLoading();
        obtainNetData(NetManager.obtainClass(Api.class).userRegister(
                username, password, repassword), new HttpCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean baseBean) {
                if (isSuccess(baseBean.errorCode)) {
                    mView.registerSuccess();
                } else mView.showError(baseBean.errorMsg);
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
