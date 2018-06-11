package com.wind.androidplay.presenter;

import com.wind.baselibrary.base.BasePresenter;
import com.wind.baselibrary.base.BaseView;

/**
 * @author : guo
 * @package : com.wind.androidplay.presenter
 * @descrip :
 */
public interface LoginContrace {

    interface LoginView extends BaseView {

        void loginSuccess();

        void loginfailure(String msg);

    }

    interface Presenter {
        void login(String name, String pass);
    }

}
