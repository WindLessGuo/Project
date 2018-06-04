package com.wind.baselibrary.base;

public interface  BaseView<T extends AbstractContract> {

    void setPresenter(T presenter);

    void showError(String msg);

}
