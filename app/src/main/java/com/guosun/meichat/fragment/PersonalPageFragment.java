package com.guosun.meichat.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.guosun.meichat.R;

public class PersonalPageFragment extends BaseFragment implements View.OnClickListener {
    private RelativeLayout user_ic_layout;



    public static PersonalPageFragment newInstance()
    {
        PersonalPageFragment userFragment = new PersonalPageFragment();
        Bundle bundle = new Bundle();
        userFragment.setArguments(bundle);
        return userFragment;
    }


    @Override
    protected boolean showHeader() {
        return false;
    }

    @Override
    protected String getHeaderTitle() {
        return _mActivity.getResources().getString(R.string.title_user);
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_personal_page;
    }

    @Override
    protected void initUI(View view) {
        user_ic_layout = (RelativeLayout) view.findViewById(R.id.user_ic_layout);
        user_ic_layout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
//        if (v == user_ic_layout) {
//            TopMovieFragment topMovieFragment = TopMovieFragment.newInstance();
//            start(topMovieFragment);
//        }
    }

}
