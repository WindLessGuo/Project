package com.wind.baselibrary.utils.gilde;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.ViewTarget;

public class ImgLoader {


    public static void loadImg(ImageView img, Activity activity, String url) {
        Glide.with(activity)
                .load(url)
                .into(img);
    }


    public static void loadCircleImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(url)
                .apply(RequestOptions.bitmapTransform(new CenterCrop())).into(iv);
    }


    public static void loadCircleImage(Context context, int  id, ImageView iv) {
        Glide.with(context).load(id)
                .apply(RequestOptions.circleCropTransform()).into(iv);
    }



}
