package com.wind.androidplay.utils;

import com.wind.androidplay.ui.activity.LoginActivity;
import com.wind.androidplay.ui.activity.PlayWebViewActivity;
import com.wind.androidplay.ui.activity.RegisterActivity;

public interface PlayUiPath {

    String BASEROUTE = "/play/";


    /**
     * {@link RegisterActivity}
     */
    String registerActivity = BASEROUTE + "RegisterActivity";

    /**
     * {@link LoginActivity}
     */
    String loginActivity = BASEROUTE + "LoginActivity";


    /**
     * {@link PlayWebViewActivity }
     */
    String webViewActivity = BASEROUTE + "PlayWebViewActivity";


}
