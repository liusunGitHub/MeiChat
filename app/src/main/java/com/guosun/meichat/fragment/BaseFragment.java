package com.guosun.meichat.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guosun.meichat.MCApplication;
import com.guosun.meichat.R;

import me.yokeyword.fragmentation.SupportFragment;

public abstract class BaseFragment extends SupportFragment {

    protected MCApplication application;
    private View mLayout;
    private RelativeLayout mRootLayout;
    private TextView tv_header_title;
    private RelativeLayout titleLayout;

    /**
     * 所有继承BackHandledFragment的子类都将在这个方法中实现物理Back键按下后的逻辑
     */
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mLayout == null)
            mLayout = inflater.inflate(R.layout.layout_base, container, false);

        application = MCApplication.getInstance();
        mRootLayout = (RelativeLayout) mLayout.findViewById(R.id.mRootLayout);
        titleLayout = (RelativeLayout) mLayout.findViewById(R.id.titleLayout);
        tv_header_title = (TextView) mLayout.findViewById(R.id.tv_header_title);
        tv_header_title.setText(getHeaderTitle());
        if (showHeader()) {
            titleLayout.setVisibility(View.VISIBLE);
        } else {
            titleLayout.setVisibility(View.GONE);
        }
        //这句话的意思就是将自定义的子布局加到mRootLayout上，true的意思表示添加上去
        LayoutInflater.from(getActivity()).inflate(getRootLayoutId(), mRootLayout, true);
        initUI(mRootLayout);
        initData();
        return mLayout;
    }



    protected String getHeaderTitle() {
        return getActivity().getResources().getString(R.string.app_name);
    }


    public void setHeaderTitle(String title) {
        tv_header_title.setText(title);
    }

    protected abstract boolean showHeader();

    protected abstract int getRootLayoutId();

    protected abstract void initUI(View view);

    protected void initData() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
