package com.guosun.meichat.fragment;

import android.os.Bundle;
import android.view.View;

import com.guosun.meichat.R;

public class TabRecommendFragment extends BackHandFragment{

    public static TabRecommendFragment newInstance() {
        TabRecommendFragment recommendFragment = new TabRecommendFragment();
        Bundle bundle = new Bundle();
        recommendFragment.setArguments(bundle);
        return recommendFragment;
    }


    @Override
    protected int getRootLayoutId() {
        return R.layout.tab_fragment_recommend;
    }

    @Override
    protected void initUI(View view) {
        loadRootFragment(R.id.fl_recommend_container, RecommendFragment.newInstance());
    }

}
