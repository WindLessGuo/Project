package com.wind.project.wind;


import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.wind.baselibrary.base.BaseActivity;
import com.wind.baselibrary.utils.ActivityUtils;
import com.wind.baselibrary.utils.LG;
import com.wind.project.R;

public class MainActivity extends BaseActivity implements MainFragment.OnFragmentInteractionListener {


    private Toolbar mToolbar;

    //main？


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("主页面");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MainFragment mainFragment
                = (MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);

        if (mainFragment == null) {
            mainFragment = mainFragment.newInstance("");

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    R.id.contentFrame, mainFragment);
        }

        new MainPresenter(mainFragment);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "you clicked it", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        LG.D("?????????????????????????????????");
    }
}
