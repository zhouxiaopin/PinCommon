package com.gzticc.pincommon.ui.activity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.gzticc.pincommon.R;
import com.gzticc.pincommon.base.BaseActivity;
import com.gzticc.pincommon.ui.adapter.MyAdapter;
import com.gzticc.pincommon.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import cn.gzticc.baselibrary.utils.StatusBarUtil;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.tab)
    TabLayout tab;
    @Bind(R.id.pager)
    ViewPager pager;
    @Bind(R.id.navigationView)
    NavigationView navigationView;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;

    private boolean isDrawer=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();

        title.setText("学习");

//        channelInfo();
    }

    private void initEvent() {
        // 设置 NavigationIcon 点击事件
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(toolbar,"点击了navigation btn",Snackbar.LENGTH_LONG).show();
//            }
//        });
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(isDrawer){
                    return coordinatorLayout.dispatchTouchEvent(motionEvent);
                }else{
                    return false;
                }
            }
        });
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                isDrawer=true;
                //获取屏幕的宽高
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
                coordinatorLayout.layout(navigationView.getRight(), 0, navigationView.getRight() + display.getWidth(), display.getHeight());
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                /*TextView textView = (TextView) drawerView.findViewById(R
                .id.tvSearch);
                Log.e("onDrawerOpened", textView.getText().toString());
                Log.e("onDrawerOpened", drawerView.getHeight()+"");*/
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                isDrawer=false;
            }
            @Override
            public void onDrawerStateChanged(int newState) {}
        });

    }

    private void initView() {
        //将actionBar替换成toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        //同步状态
        drawerToggle.syncState();


        List<String> list = new ArrayList<>();
//        for (int i=0;i<10;i++){
//            list.add(String.format(Locale.CHINA,"第%02d页",i));
//        }
        list.add("首页");
        list.add("订购");
        list.add("需求");
        list.add("我的");
        pager.setAdapter(new MyAdapter(getSupportFragmentManager(),list));
        tab.setupWithViewPager(pager);

        //指定Tab的位置
        one = tab.getTabAt(0);
        two = tab.getTabAt(1);
        three = tab.getTabAt(2);
        four = tab.getTabAt(3);

        //设置Tab的图标，假如不需要则把下面的代码删去
        one.setIcon(UIUtils.getDrawable(R.drawable.tab_icon_select));
        two.setIcon(UIUtils.getDrawable(R.drawable.tab_icon_select));
        three.setIcon(UIUtils.getDrawable(R.drawable.tab_icon_select));
        four.setIcon(UIUtils.getDrawable(R.drawable.tab_icon_select));
    }

    //渠道打包
    public void channelInfo(){
        ApplicationInfo appInfo = null;
        try {
            appInfo = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String channel = appInfo.metaData.getString("UMENG_CHANNEL");
        Snackbar.make(pager,channel,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_name:
                Snackbar.make(navigationView,item.getTitle(),Snackbar.LENGTH_LONG).show();
            break;
            default:
                break;
        }
        return false;
    }

    @Override
    protected void setStatusBar() {
        int  mStatusBarColor = getResources().getColor(R.color.colorAccent);
        StatusBarUtil.setColorForDrawerLayout(this, drawerLayout, mStatusBarColor, 30);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
