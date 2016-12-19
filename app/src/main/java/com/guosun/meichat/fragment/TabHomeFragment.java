package com.guosun.meichat.fragment;

import android.os.Bundle;
import android.view.View;

import com.commonlib.log.ULog;
import com.guosun.meichat.R;

public class TabHomeFragment extends BackHandFragment {

    public static TabHomeFragment newInstance() {
        TabHomeFragment homeFragment = new TabHomeFragment();
        Bundle bundle = new Bundle();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.tab_fragment_home;
    }

    @Override
    protected void initUI(View view) {
        loadRootFragment(R.id.fl_home_container, HomeFragment.newInstance());
    }

    @Override
    protected void initData() {
        super.initData();
        ULog.i("initData()........", "1111111");

    }

}
