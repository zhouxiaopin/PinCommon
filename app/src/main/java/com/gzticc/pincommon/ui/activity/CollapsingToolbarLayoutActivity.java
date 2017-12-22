package com.gzticc.pincommon.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.gzticc.pincommon.R;
import com.gzticc.pincommon.base.BaseActivity;

import butterknife.Bind;
import cn.gzticc.baselibrary.utils.StatusBarUtil;

public class CollapsingToolbarLayoutActivity extends BaseActivity {
    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.backdrop)
    ImageView backdrop;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar_layout);
        initView();
    }

    private void initView() {

    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForCoordinatorLayout(this,0);
    }
}
