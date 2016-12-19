package com.guosun.meichat;

import android.os.Bundle;
import android.view.View;

import com.guosun.meichat.fragment.BaseFragment;
import com.guosun.meichat.fragment.CollectFragment;
import com.guosun.meichat.fragment.HomeFragment;
import com.guosun.meichat.fragment.MainFragment;
import com.guosun.meichat.fragment.RecommendFragment;
import com.guosun.meichat.fragment.UserFragment;
import com.guosun.meichat.ui.BaseActivity;
import com.guosun.meichat.view.BottomBar;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class MainActivity extends BaseActivity {
    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;
    private BottomBar mBottomBar;
    private BaseFragment mCurFragment;
    private HomeFragment mHomeFragment;
    private RecommendFragment mRecommendFragment;
    private CollectFragment mCollectFragment;
    private UserFragment mFragment04;

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
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();
    }


}
