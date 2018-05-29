package com.wind.baselibrary.base;

public interface  BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

}
