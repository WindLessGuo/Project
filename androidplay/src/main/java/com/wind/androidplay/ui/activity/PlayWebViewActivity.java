package com.wind.androidplay.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wind.androidplay.R;
import com.wind.androidplay.base.PlayBaseActivity;
import com.wind.androidplay.utils.Tags;

import java.lang.reflect.Method;

import static com.wind.androidplay.utils.PlayUiPath.webViewActivity;


/**
 * @author: GBX
 * @time: 15:42
 * @descrip: webview
 */
@Route(path = webViewActivity)
public class PlayWebViewActivity extends PlayBaseActivity {

    private WebView mWebView;
    private Toolbar mToolbar;
    private ProgressBar mProgressBar;

    private String url;
    private String mTitle;
    private boolean isBanner, isCollectioned;
    private MenuItem itemCollection;


    @Override
    protected int getLayoutRes() {
        return R.layout.play_activity_webview;
    }

    @Override
    protected void init() {
        getIntentData();
        mToolbar = findViewById(R.id.web_toolbar);
        mToolbar.setTitle(mTitle);
        setSupportActionBar(mToolbar);
        mProgressBar = findViewById(R.id.progressbar);

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

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                    closeLoading();
                } else {
                    showLoading();
                    mProgressBar.setVisibility(View.VISIBLE);
                    mProgressBar.setProgress(newProgress);
                }
            }
        });


        mWebView.loadUrl(url);
    }

    private void getIntentData() {
        if (!TextUtils.isEmpty(getIntent().getStringExtra(linkUrl)))
            url = getIntent().getStringExtra(linkUrl);
        if (!TextUtils.isEmpty(getIntent().getStringExtra(title))) {
            mTitle = getIntent().getStringExtra(title);
        }
        isBanner = getIntent().getBooleanExtra(Tags.isBanner, false);

        isCollectioned = getIntent().getBooleanExtra(Tags.collection, false);
    }


    @Override
    protected void onDestroy() {
        mWebView.clearHistory();
        mWebView.clearCache(true);
        mWebView = null;
        super.onDestroy();
    }

    @Override
    protected void initPresenter() {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (isBanner) {
            getMenuInflater().inflate(R.menu.play_menu_webview_banner, menu);
        } else {
            getMenuInflater().inflate(R.menu.play_menu_webview_not_banner, menu);
            itemCollection = menu.getItem(R.id.collection);
            setCollectionMenuItem();
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void setCollectionMenuItem() {
        if (isCollectioned) {
            itemCollection.setIcon(R.mipmap.play_collction);
            itemCollection.setTitle(R.string.play_un_collection);
        } else {
            itemCollection.setIcon(R.mipmap.play_un_collection);
            itemCollection.setTitle(R.string.play_collection);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            PlayWebViewActivity.this.finish();
        } else if (item.getItemId() == R.id.share) {
            systemShare();
        } else if (item.getItemId() == R.id.open_with_client_browser) {
            openWithSystemBrowser();
        } else if (item.getItemId() == R.id.collection) {
            if (isCollectioned){

            }
        }


        return super.onOptionsItemSelected(item);
    }

    private void openWithSystemBrowser() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
        startActivity(intent);
    }

    private void systemShare() {
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        textIntent.setAction(Intent.ACTION_SEND);
        textIntent.setType("text/plain");
        textIntent.putExtra(Intent.EXTRA_TEXT, mTitle + url);
        startActivity(Intent.createChooser(textIntent, "分享"));
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

    /*  */

    /**
     * 让菜单同时显示图标和文字
     *
     * @param featureId Feature id
     * @param menu      Menu
     * @return menu if opened
     */
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            try {
                @SuppressLint("PrivateApi")
                Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(menu, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

}
