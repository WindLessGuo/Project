package com.wind.androidplay.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wind.androidplay.R;
import com.wind.androidplay.bean.HomeListDataBean;

import java.util.List;

/**
 * @author: GBX
 * @time: 14:05
 * @descrip:
 */
public class HomeAdapter extends BaseQuickAdapter<HomeListDataBean.DatasBean, HomeAdapter.ViewHolder> {


    public HomeAdapter(int layoutResId, @Nullable List<HomeListDataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(HomeAdapter.ViewHolder helper, HomeListDataBean.DatasBean item) {
        helper.textView.setText(item.getAuthor());
    }


    public static class ViewHolder extends BaseViewHolder {
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.name);
        }
    }


}
