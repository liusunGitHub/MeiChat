package com.guosun.meichat.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guosun.meichat.MCApplication;
import com.guosun.meichat.R;

import me.yokeyword.fragmentation.SupportActivity;


public abstract class BaseActivity extends SupportActivity {
    protected MCApplication application;
    private RelativeLayout mRootLayout;
    private TextView tv_header_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        application = MCApplication.getInstance();
        mRootLayout = (RelativeLayout) findViewById(R.id.mRootLayout);
        tv_header_title = (TextView) findViewById(R.id.tv_header_title);
        tv_header_title.setText(getHeaderTitle());
        if (showHeader()) {
            tv_header_title.setVisibility(View.VISIBLE);
        } else {
            tv_header_title.setVisibility(View.GONE);
        }
        View view = LayoutInflater.from(this)
                .inflate(getRootLayoutId(), null);
        mRootLayout.addView(view);
        initUI(mRootLayout);
        initData();
    }

    protected abstract void initUI(View view);

    protected void initData() {
    }

    protected abstract int getRootLayoutId();

    protected boolean showHeader(){
        return true;
    };

    protected String getHeaderTitle(){
        return this.getResources().getString(R.string.app_name);
    };

    public void setHeaderTitle(String title) {
        tv_header_title.setText(title);
    }


}
