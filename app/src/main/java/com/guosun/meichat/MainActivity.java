package com.guosun.meichat;

import android.os.Bundle;
import android.view.View;

import com.guosun.meichat.fragment.BackHandFragment;
import com.guosun.meichat.fragment.TabCollectFragment;
import com.guosun.meichat.fragment.TabHomeFragment;
import com.guosun.meichat.fragment.TabRecommendFragment;
import com.guosun.meichat.fragment.TabUserFragment;
import com.guosun.meichat.ui.BaseActivity;
import com.guosun.meichat.view.BottomBar;
import com.guosun.meichat.view.BottomBarTab;

import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultNoAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class MainActivity extends BaseActivity implements BackHandFragment.OnBackToFirstListener{
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;
    private BottomBar mBottomBar;

    private SupportFragment[] mFragments = new SupportFragment[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            mFragments[FIRST] = TabHomeFragment.newInstance();
            mFragments[SECOND] = TabRecommendFragment.newInstance();
            mFragments[THIRD] = TabCollectFragment.newInstance();
            mFragments[FOURTH] = TabUserFragment.newInstance();

            loadMultipleRootFragment(R.id.ll_main_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findFragment(TabHomeFragment.class);
            mFragments[SECOND] = findFragment(TabRecommendFragment.class);
            mFragments[THIRD] = findFragment(TabCollectFragment.class);
            mFragments[FOURTH] = findFragment(TabUserFragment.class);
        }

//        if (savedInstanceState == null) {
//            loadRootFragment(R.id.fl_container, MainFragment.newInstance());
//        }
    }

    @Override
    protected void initUI(View view) {
        mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);

        mBottomBar
                .addItem(new BottomBarTab(this, R.mipmap.ic_menu_home, "首页"))
                .addItem(new BottomBarTab(this, R.mipmap.ic_menu_recommend, "推荐"))
                .addItem(new BottomBarTab(this, R.mipmap.ic_menu_collect, "收藏"))
                .addItem(new BottomBarTab(this, R.mipmap.ic_menu_user, "我的"));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
            }
        });

    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_main;
    }


    @Override
    protected boolean showHeader() {
        return false;
    }

    @Override
    public void onBackPressedSupport() {
        // 对于 4个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
        super.onBackPressedSupport();
    }

    @Override
    public void onBackToFirstFragment() {
        mBottomBar.setCurrentItem(0);
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultNoAnimator();
    }

//    @Override
//    protected FragmentAnimator onCreateFragmentAnimator() {
//        return super.onCreateFragmentAnimator();
//    }


}
