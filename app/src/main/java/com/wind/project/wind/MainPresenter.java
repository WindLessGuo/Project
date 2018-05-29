package com.wind.project.wind;

import com.wind.baselibrary.utils.HttpHelper;
import com.wind.baselibrary.utils.NetManager;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.MainView mainView;

    private MainBean data;

    public MainPresenter(MainContract.MainView mainView) {
        this.mainView = checkNotNull(mainView, "mainView can't null");
        mainView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        loadData();
    }

    private MainBean loadData() {
        mainView.showLoading();
        NetManager.obtainClass(MainAPI.class)
                .obtainData().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new HttpHelper<MainBean>() {
                    @Override
                    public void onSuccess(MainBean mainBean) {
                        data = mainBean;
                        mainView.setAdapter(data);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mainView.showError();
                    }

                    @Override
                    public void onFinish() {

                    }
                });
        return data;
    }

    @Override
    public void unsubscribe() {

    }



}
