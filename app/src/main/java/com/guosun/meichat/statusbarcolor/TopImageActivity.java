package com.guosun.meichat.statusbarcolor;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.guosun.meichat.ui.BaseActivity;

import com.guosun.meichat.R;

public class TopImageActivity extends BaseActivity {
    private TextView change_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_image);
    }

    @Override
    protected void initUI(View view) {

    }

    @Override
    protected int getRootLayoutId() {
        return 0;
    }
}
