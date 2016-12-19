package com.guosun.meichat.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.guosun.meichat.R;

public class RecommendFragment extends BaseFragment implements View.OnClickListener {
    private TextView change_type;

    public static RecommendFragment newInstance() {
        RecommendFragment recommendFragment = new RecommendFragment();
        Bundle bundle = new Bundle();
        recommendFragment.setArguments(bundle);
        return recommendFragment;
    }


    @Override
    protected boolean showHeader() {
        return false;
    }

    @Override
    protected String getHeaderTitle() {
        return "热门推荐";
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_recommend;
    }


    @Override
    protected void initUI(View view) {

        change_type = (TextView) view.findViewById(R.id.change_type);
        change_type.setOnClickListener(this);
        change_type.setText("top250");

    }

    @Override
    protected void initData() {
        super.initData();

    }


    @Override
    public void onClick(View v) {
        if (v == change_type) {
            TopMovieFragment topMovieFragment = TopMovieFragment.newInstance();
            start(topMovieFragment);
        }
    }

}
