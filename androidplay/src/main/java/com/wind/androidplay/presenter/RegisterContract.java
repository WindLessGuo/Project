package com.wind.androidplay.presenter;

import com.wind.baselibrary.base.AbstractContract;
import com.wind.baselibrary.base.BaseView;

/**
 * @author : guo
 * @package : com.wind.androidplay.presenter
 * @descrip :
 */
public interface RegisterContract {

    interface RegisterView extends BaseView {
        void registerSuccess();
    }

    interface RegisterPresenter extends AbstractContract {

        void userRegister(String username, String password, String repassword);
    }

}
