package com.guosun.meichat.fragment;

import android.os.Bundle;
import android.view.View;

import com.utilcommonlib.log.ULog;
import com.guosun.meichat.R;

public class HomeFragment extends BaseFragment{

    public static HomeFragment newInstance()
    {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }


    @Override
    protected boolean showHeader() {
        return false;
    }


    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_home;
    }
    

    @Override
    protected void initUI(View view) {

    }

    @Override
    protected void initData() {
        super.initData();
        ULog.i("initData()........","1111111");

    }

}
