package com.guosun.meichat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
    protected void initLazyView(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            // ShopFragment是flow包里的
            loadRootFragment(R.id.fl_user_container, UserFragment.newInstance());
        } else { // 这里可能会出现该Fragment没被初始化时,就被强杀导致的没有load子Fragment
            if (findChildFragment(UserFragment.class) == null) {
                loadRootFragment(R.id.fl_user_container, UserFragment.newInstance());
            }
        }

    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.tab_fragment_user;
    }

    @Override
    protected void initUI(View view) {
    }

}
