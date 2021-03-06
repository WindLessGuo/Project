package com.wind.baselibrary.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;
    protected View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayout(), container, false);
        initPresenter();
        init();
        //initializeLoading(rootView);
        return rootView;
    }

    //protected abstract void initializeLoading(View rootView);

    protected abstract void initPresenter();

    protected abstract void init();

    protected abstract int getLayout();

    protected <B extends View> B $(int id) {
        return (B) super.getActivity().findViewById(id);
    }

}
