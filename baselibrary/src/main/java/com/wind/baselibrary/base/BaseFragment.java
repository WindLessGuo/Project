package com.wind.baselibrary.base;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;
    protected View rootView;

    private Unbinder bind;

/*    public static BaseFragment newInstance(String param1, String param2) {
        BaseFragment fragment = new BaseFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }*/



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mActivity = getActivity();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayout(), container, false);
        bind = ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }

    protected abstract int getLayout();

    protected <B extends View> B $(int id) {
        return (B) super.getActivity().findViewById(id);
    }
}
