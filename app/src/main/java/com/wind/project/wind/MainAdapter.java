package com.wind.project.wind;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wind.baselibrary.utils.ImgLoader;
import com.wind.project.R;

import static com.wind.baselibrary.content.PatternOneUiPath.patternOneMain;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private MainBean mainBeanList = null;
    private Activity activity;

    public MainAdapter(MainBean mainBeanList, Activity activity) {
        this.mainBeanList = mainBeanList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainHolder(LayoutInflater.from(activity)
                .inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, int position) {
        MainBean.ResultDataBean dataBean = mainBeanList.getResultData().get(position);
        holder.textView.setText(dataBean.getName());
        ImgLoader.loadImg(holder.imageView, activity, dataBean.getImagePath());
        holder.itemView.setOnClickListener(v ->
                ARouter.getInstance().build(patternOneMain).navigation());
    }

    @Override
    public int getItemCount() {
        return mainBeanList.getResultData().size();
    }

    static class MainHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public MainHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.content);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
