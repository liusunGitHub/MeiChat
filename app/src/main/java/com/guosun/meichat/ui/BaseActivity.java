package com.guosun.meichat.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guosun.meichat.MCApplication;
import com.guosun.meichat.R;

import me.yokeyword.fragmentation.SupportActivity;


public abstract class BaseActivity extends SupportActivity {
    protected MCApplication application;
    private RelativeLayout mRootLayout;
    private TextView tv_header_title;
    private RelativeLayout titleLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        translucentStatusBar();
        setContentView(R.layout.layout_base);
        application = MCApplication.getInstance();
        mRootLayout = (RelativeLayout) findViewById(R.id.mRootLayout);
        titleLayout = (RelativeLayout) findViewById(R.id.titleLayout);
        tv_header_title = (TextView) findViewById(R.id.tv_header_title);
        tv_header_title.setText(getHeaderTitle());
        if (showHeader()) {
            titleLayout.setVisibility(View.VISIBLE);
        } else {
            titleLayout.setVisibility(View.GONE);
        }
        //这句话的意思就是将自定义的子布局加到mRootLayout上，true的意思表示添加上去
        if (getRootLayoutId() != 0) {
            LayoutInflater.from(this).inflate(getRootLayoutId(), mRootLayout, true);
        }
        initUI(mRootLayout);
        initData();
    }
    private void translucentStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }

    protected abstract void initUI(View view);

    protected void initData() {
    }

    protected abstract int getRootLayoutId();

    protected boolean showHeader() {
        return true;
    }

    ;

    protected String getHeaderTitle() {
        return this.getResources().getString(R.string.app_name);
    }

    ;

    public void setHeaderTitle(String title) {
        tv_header_title.setText(title);
    }


}
