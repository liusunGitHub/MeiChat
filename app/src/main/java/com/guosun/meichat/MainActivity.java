package com.guosun.meichat;

import android.os.Bundle;
import android.view.View;

import com.guosun.meichat.fragment.MainFragment;
import com.guosun.meichat.ui.BaseActivity;

import me.yokeyword.fragmentation.anim.DefaultNoAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance());
        }
    }

    @Override
    protected void initUI(View view) {

    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected boolean showHeader() {
        return false;
    }

    public void onBackPressedSupport() {
        // 对于 4个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
        super.onBackPressedSupport();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultNoAnimator();
    }


}
