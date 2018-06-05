package com.wind.androidplay.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wind.androidplay.bean.HomeListDataBean;

import java.util.List;

/**
 * @author: GBX
 * @time: 14:05
 * @descrip:
 */
public class HomeAdapter extends BaseQuickAdapter<HomeListDataBean,HomeAdapter.ViewHolder> {



    public HomeAdapter(int layoutResId, @Nullable List<HomeListDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(HomeAdapter.ViewHolder helper, HomeListDataBean item) {

    }


    public static class ViewHolder extends BaseViewHolder{
        public ViewHolder(View view) {
            super(view);
        }
    }


}
