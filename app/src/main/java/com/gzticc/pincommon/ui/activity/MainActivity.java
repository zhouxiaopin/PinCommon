package com.gzticc.pincommon.ui.activity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.gzticc.pincommon.R;
import com.gzticc.pincommon.ui.adapter.MyAdapter;
import com.gzticc.pincommon.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        initEvent();

//        channelInfo();
    }

    private void initEvent() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initView() {
        //将actionBar替换成toolbar
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
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
}
