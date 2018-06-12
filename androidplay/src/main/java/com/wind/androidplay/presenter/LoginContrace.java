package com.wind.androidplay.presenter;

import com.wind.androidplay.base.BaseBean;
import com.wind.androidplay.bean.UserBean;
import com.wind.baselibrary.base.BaseView;

/**
 * @author : guo
 * @package : com.wind.androidplay.presenter
 * @descrip :
 */
public interface LoginContrace {

    interface LoginView extends BaseView {

        void loginSuccess(BaseBean<UserBean> baseBean);

        void loginfailure(String msg);

    }

    interface Presenter {
        void login(String name, String pass);
    }

}
