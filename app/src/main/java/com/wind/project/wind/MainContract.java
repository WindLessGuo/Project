package com.wind.project.wind;

public interface MainContract {


    interface Presenter extends BasePresenter {


    }


    interface MainView extends BaseView<Presenter> {
        void showLoading();

        void showError();

        void setAdapter(MainBean v);

    }


}
