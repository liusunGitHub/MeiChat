//package com.guosun.meichat.fragment;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.view.View;
//
//import com.commonlib.log.ULog;
//import com.commonlib.utils.ToastUtils;
//import com.guosun.meichat.R;
//import com.guosun.meichat.listener.OnBackToFirstListener;
//import com.guosun.meichat.view.BottomBar;
//import com.guosun.meichat.view.BottomBarTab;
//
//public class MainFragment extends BackHandFragment implements OnBackToFirstListener {
//
//
//    // 再点一次退出程序时间设置
//    private static final long WAIT_TIME = 2000L;
//    private long TOUCH_TIME = 0;
//    private BottomBar mBottomBar;
//    private BackHandFragment mCurFragment;
//    private TabHomeFragment mHomeFragment;
//    private TabRecommendFragment mRecommendFragment;
//    private TabCollectFragment mCollectFragment;
//    private TabUserFragment mFragment04;
//
//    public static MainFragment newInstance() {
//
//        Bundle args = new Bundle();
//
//        MainFragment fragment = new MainFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        setBackToFirstListener(this);
//
//    }
//
//    @Override
//    protected void initUI(View view) {
//        super.initUI(view);
//        mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);
//
//        mBottomBar
//                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_menu_home, "首页"))
//                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_menu_recommend, "推荐"))
//                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_menu_collect, "收藏"))
//                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_menu_user, "我的"));
//
//        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(int position, int prePosition) {
//                switch (position) {
//                    case 0:
//                        if (mHomeFragment == null)
//                            mHomeFragment = TabHomeFragment.newInstance();
//                        checkFragment(mHomeFragment);
//                        break;
//                    case 1:
//                        if (mRecommendFragment == null)
//                            mRecommendFragment = TabRecommendFragment.newInstance();
//                        checkFragment(mRecommendFragment);
//                        break;
//                    case 2:
//                        if (mCollectFragment == null)
//                            mCollectFragment = TabCollectFragment.newInstance();
//                        checkFragment(mCollectFragment);
//                        break;
//                    case 3:
//                        if (mFragment04 == null)
//                            mFragment04 = TabUserFragment.newInstance();
//                        checkFragment(mFragment04);
//                        break;
//                }
//            }
//
//            @Override
//            public void onTabUnselected(int position) {
//
//            }
//
//            @Override
//            public void onTabReselected(int position) {
//            }
//        });
//
//        mBottomBar.setCurrentItem(0);//设置第一个
//
//
//    }
//
//
//    @Override
//    protected int getRootLayoutId() {
//        return R.layout.fragment_main;
//    }
//
//    //切换片段的方法
//    private void checkFragment(BackHandFragment fragment) {
//        //第一次加载片段
//        if (mCurFragment == null) {
//            getFragmentManager().beginTransaction().replace(R.id.ll_main_container, fragment).commitAllowingStateLoss();
//            mCurFragment = fragment;
//            mCurFragment.setBackToFirstListener(this);
//            return;
//        }
//
//        //相同的tab不做操作
//        if (mCurFragment == fragment) {
//            return;
//        } else {
//            if (fragment.isAdded())
//                getFragmentManager().beginTransaction()
//                        .hide(mCurFragment).show(fragment).commitAllowingStateLoss();
//            else
//                getFragmentManager().beginTransaction()
//                        .hide(mCurFragment).add(R.id.ll_main_container, fragment).commitAllowingStateLoss();
//            mCurFragment = fragment;
//            mCurFragment.setBackToFirstListener(this);
//        }
//    }
//
//    @Override
//    protected boolean showHeader() {
//        return false;
//    }
//
//    @Override
//    public void onBackToFirstFragment() {
//        ULog.i("cccccccc343434", mCurFragment + " 450 " + mHomeFragment);
//
//        if (mCurFragment == null || !mCurFragment.onBackPressed()) {
//
//            if (mCurFragment != mHomeFragment) {
//                mBottomBar.setCurrentItem(0);//设置第一个
//            } else {
////            moveTaskToBack(true);
//                if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
//                    getActivity().finish();
//                } else {
//                    TOUCH_TIME = System.currentTimeMillis();
//                    ToastUtils.showShortMsg(getActivity(), "再按一次退出");
//                }
//            }
//        }
//    }
//
//
//}
