package com.wind.baselibrary.utils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetManager {


    private static final int timeOut = 10;
    private static Retrofit retrofit = null;
    public static String BASE_URL ;


    private static OkHttpClient okHttpClient() {
        /**
         * HttpLoggingInterceptor.Level.NONE 不记录
         *
         * BASIC 请求/响应行
         * --> POST /greeting HTTP/1.1 (3-byte body)
         *<-- HTTP/1.1 200 OK (22ms, 6-byte body)
         *
         * HEADER 请求/响应行 + 头
         * --> Host: example.com
         * Content-Type: plain/text
         * Content-Length: 3
         * <-- HTTP/1.1 200 OK (22ms)
         *Content-Type: plain/text
         *Content-Length: 6
         *
         * BODY 请求/响应行 + 头 + 体x
         */

        HttpLoggingInterceptor loggingInterceptor =
                new HttpLoggingInterceptor(message -> LG.D("net", message));
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .connectTimeout(timeOut, TimeUnit.SECONDS);
        return builder.build();
    }


    private static Retrofit retrofit() {
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();

        return retrofit;
    }


    public static <T> T obtainClass(Class<T> clazz) {
        return retrofit().create(clazz);
    }


}
