package com.guosun.meichat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
    protected void initLazyView(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            // ShopFragment是flow包里的
            loadRootFragment(R.id.fl_recommend_container, RecommendFragment.newInstance());
        } else { // 这里可能会出现该Fragment没被初始化时,就被强杀导致的没有load子Fragment
            if (findChildFragment(RecommendFragment.class) == null) {
                loadRootFragment(R.id.fl_recommend_container, RecommendFragment.newInstance());
            }
        }

    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.tab_fragment_recommend;
    }

    @Override
    protected void initUI(View view) {
    }

}
