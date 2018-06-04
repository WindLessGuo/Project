package com.wind.baselibrary.base;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//

public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;
    protected View rootView;
    //使用ButterKnife时出现 Android Attribute value must be constant的问题，暂未解决
    //private Unbinder bind;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mActivity = getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayout(), container, false);
      //  bind = ButterKnife.bind(this, rootView);
        init();
        return rootView;
    }

    protected abstract void init();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
       // bind.unbind();
    }

    protected abstract int getLayout();

    protected <B extends View> B $(int id) {
        return (B) super.getActivity().findViewById(id);
    }
}
