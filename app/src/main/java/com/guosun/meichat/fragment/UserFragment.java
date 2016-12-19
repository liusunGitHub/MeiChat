package com.guosun.meichat.fragment;

import android.os.Bundle;
import android.view.View;

import com.guosun.meichat.R;

public class UserFragment extends BaseFragment{



    public static UserFragment newInstance()
    {
        UserFragment userFragment = new UserFragment();
        Bundle bundle = new Bundle();
        userFragment.setArguments(bundle);
        return userFragment;
    }


    @Override
    protected boolean showHeader() {
        return false;
    }



    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initUI(View view) {

    }

}
