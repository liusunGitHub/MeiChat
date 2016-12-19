package com.guosun.meichat.fragment;

import android.os.Bundle;
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
    protected int getRootLayoutId() {
        return R.layout.tab_fragment_collect;
    }

    @Override
    protected void initUI(View view) {
        loadRootFragment(R.id.fl_collect_container, CollectFragment.newInstance());
    }

}
