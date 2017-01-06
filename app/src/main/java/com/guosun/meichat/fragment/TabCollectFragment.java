package com.guosun.meichat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.guosun.meichat.R;

public class TabCollectFragment extends BackHandFragment {

    public static TabCollectFragment newInstance() {
        TabCollectFragment collectFragment = new TabCollectFragment();
        Bundle bundle = new Bundle();
        collectFragment.setArguments(bundle);
        return collectFragment;
    }

    @Override
    protected void initLazyView(@Nullable Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            // ShopFragment是flow包里的
            loadRootFragment(R.id.fl_collect_container, CollectFragment.newInstance());
        } else { // 这里可能会出现该Fragment没被初始化时,就被强杀导致的没有load子Fragment
            if (findChildFragment(CollectFragment.class) == null) {
                loadRootFragment(R.id.fl_collect_container, CollectFragment.newInstance());
            }
        }

    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.tab_fragment_collect;
    }

    @Override
    protected void initUI(View view) {
    }

}
