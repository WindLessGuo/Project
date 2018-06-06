package com.wind.androidplay.ui.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wind.androidplay.R;
import com.wind.androidplay.bean.HomeListDataBean;
import com.wind.baselibrary.utils.gilde.ImgLoader;

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
        //helper.textView.setText(item.getAuthor());
        if (TextUtils.isEmpty(item.getHeadPic())) {
            ImgLoader.loadCircleImage(mContext, R.mipmap.place_header, helper.header);
        } else {
            ImgLoader.loadCircleImage(mContext, item.getHeadPic(), helper.header);
        }
        helper.title.setText(item.getTitle());
        helper.classifyName.setText("分类：" + item.getSuperChapterName() + "/" + item.getChapterName());
        helper.author.setText(item.getAuthor());
        helper.time.setText("分享于\t" + item.getNiceDate());
    }


    public static class ViewHolder extends BaseViewHolder {
        ImageView header;
        TextView title, classifyName, author, time;


        public ViewHolder(View view) {
            super(view);
            header = view.findViewById(R.id.play_home_list_author_header);
            title = view.findViewById(R.id.play_home_title);
            classifyName = view.findViewById(R.id.play_home_classify_name);
            author = view.findViewById(R.id.play_home_list_author);
            time = view.findViewById(R.id.play_home_list_time);
        }
    }


}
