package com.wind.baselibrary.utils;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;

public class ImgLoader {


    public static ViewTarget<ImageView, Drawable> loadImg(ImageView img, Activity activity, String url) {
         return Glide.with(activity)
                .load(url)
                .into(img);
    }


}
