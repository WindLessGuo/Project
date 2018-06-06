package com.wind.androidplay.ui.activity;

import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wind.androidplay.R;
import com.wind.androidplay.base.PlayBaseActivity;

import static com.wind.baselibrary.content.PlayUiPath.webViewActivity;

/**
 * @author: GBX
 * @time: 15:42
 * @descrip: webview
 */
@Route(path = webViewActivity)
public class PlayWebViewActivity extends PlayBaseActivity {

    private WebView mWebView;
    private String url;
    private Toolbar mToolbar;


    @Override
    protected int getLayoutRes() {
        return R.layout.play_activity_webview;
    }

    @Override
    protected void init() {
        if (!TextUtils.isEmpty(getIntent().getStringExtra(linlUrl)))
            url = getIntent().getStringExtra(linlUrl);

        mToolbar = findViewById(R.id.web_toolbar);
        setSupportActionBar(mToolbar);

        mToolbar.setTitle(getIntent().getStringExtra(title));

        mWebView = findViewById(R.id.webview);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        //设置 JS 是否可以打开 WebView 新窗口
        settings.setJavaScriptCanOpenWindowsAutomatically(true);

        //WebView 是否支持多窗口，如果设置为 true，需要重写
        //WebChromeClient#onCreateWindow(WebView, boolean, boolean, Message) 函数，默认为 false
        //settings.setSupportMultipleWindows(true);

        //显示WebView提供的缩放控件
        //settings.setDisplayZoomControls(true);

        //设置 WebView 字体的大小，默认大小为 16
        //settings.setDefaultFontSize(20);
        //设置 WebView 支持的最小字体大小，默认为 8
        //settings.setMinimumFontSize(12);

        //设置页面是否支持缩放
        // settings.setSupportZoom(true);
        //不显示缩放按钮
        settings.setDisplayZoomControls(false);
        //设置自适应屏幕，两者合用
        //将图片调整到适合WebView的大小
        settings.setUseWideViewPort(true);
        //缩放至屏幕的大小
        settings.setLoadWithOverviewMode(true);
        //自适应屏幕
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(String.valueOf(request.getUrl()));
                }
                return true;
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient());


        mWebView.loadUrl(url);
    }


    @Override
    protected void onDestroy() {
        mWebView.clearCache(true);
        mWebView = null;
        super.onDestroy();
    }

    @Override
    protected void initPresenter() {

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 因为网页加载在堆栈中，所以能一级一级的返回，通过对返回键的监听来返回上一堆栈
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 判断是否可以返回
            if (mWebView.canGoBack()) {
                // 可以返回时，就返回
                mWebView.goBack();
                return true;
            } else {
                // 当不能返回时，关闭程序。
                PlayWebViewActivity.this.finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }


}
