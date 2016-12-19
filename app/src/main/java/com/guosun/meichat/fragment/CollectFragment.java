package com.guosun.meichat.fragment;

import android.os.Bundle;
import android.view.View;

import com.guosun.meichat.R;

public class CollectFragment extends BaseFragment{

    public static CollectFragment newInstance()
    {
        CollectFragment collectFragment = new CollectFragment();
        Bundle bundle = new Bundle();
        collectFragment.setArguments(bundle);
        return collectFragment;
    }

    @Override
    protected boolean showHeader() {
        return true;
    }

    @Override
    protected String getHeaderTitle() {
        return "收藏";
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_collect;
    }
    

    @Override
    protected void initUI(View view) {


    }

    @Override
    protected void initData() {
        super.initData();
    }

}
