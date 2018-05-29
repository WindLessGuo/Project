package com.wind.baselibrary.utils;

import android.util.Log;


import static com.wind.baselibrary.base.BaseApplication.isDebug;

public class LG {
    // dievw wtf

    private static final String defaultTag = "log";

    public static void D(String tag, String msg) {
        if (isDebug()) Log.d(tag, msg);
    }

    public static void D(String msg) {
        D(defaultTag, msg);
    }


    public static void I(String tag, String msg) {
        if (isDebug()) Log.i(tag, msg);
    }

    public static void I(String msg) {
        I(defaultTag, msg);
    }


    public static void E(String tag, String msg) {
        if (isDebug()) Log.e(tag, msg);
    }

    public static void E(String msg) {
        E(defaultTag, msg);
    }

    public static void V(String tag, String msg) {
        if (isDebug()) Log.v(tag, msg);
    }

    public static void V(String msg) {
        V(defaultTag, msg);
    }

    public static void W(String tag, String msg) {
        if (isDebug()) Log.w(tag, msg);
    }

    public static void W(String msg) {
       W(defaultTag, msg);
    }

    public static void WTF(String tag, String msg) {
        if (isDebug()) Log.wtf(tag, msg);
    }

    public static void WTF(String msg) {
        WTF(defaultTag, msg);
    }


}
