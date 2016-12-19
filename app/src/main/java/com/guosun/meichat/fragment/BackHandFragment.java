package com.guosun.meichat.fragment;

import android.content.Context;
import android.view.View;

import com.guosun.meichat.listener.OnBackToFirstListener;

public class BackHandFragment extends BaseFragment {
    protected OnBackToFirstListener _mBackToFirstListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * 处理回退事件
     *
     * @return
     */
    @Override
    public boolean onBackPressedSupport() {

        if (getChildFragmentManager().getBackStackEntryCount() > 1) {
            popChild();
        } else {
            if (_mBackToFirstListener != null)
                _mBackToFirstListener.onBackToFirstFragment();
        }
        return true;
    }


    public void setBackToFirstListener(OnBackToFirstListener _mBackToFirstListener) {
        this._mBackToFirstListener = _mBackToFirstListener;
    }


    @Override
    protected int getRootLayoutId() {
        return 0;
    }

    @Override
    protected void initUI(View view) {

    }

    @Override
    protected boolean showHeader() {
        return false;
    }
}
