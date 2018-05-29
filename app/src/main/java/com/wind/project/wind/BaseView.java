package com.wind.project.wind;

public interface  BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

}
