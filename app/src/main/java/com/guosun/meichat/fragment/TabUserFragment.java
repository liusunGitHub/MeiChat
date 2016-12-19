package com.guosun.meichat.fragment;

import android.os.Bundle;
import android.view.View;

import com.guosun.meichat.R;

public class TabUserFragment extends BackHandFragment {

    public static TabUserFragment newInstance() {
        TabUserFragment userFragment = new TabUserFragment();
        Bundle bundle = new Bundle();
        userFragment.setArguments(bundle);
        return userFragment;
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.tab_fragment_user;
    }

    @Override
    protected void initUI(View view) {
        loadRootFragment(R.id.fl_user_container, UserFragment.newInstance());
    }

}
