package com.gzticc.pincommon.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gzticc.pincommon.ui.fragment.FragmentFactory;
import com.gzticc.pincommon.utils.LogUtils;

import java.util.List;

/**
 * Created by user on 2017/8/18.
 */

public class MyAdapter extends FragmentPagerAdapter {

    List<String> list;

    public MyAdapter(FragmentManager fm,List<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
//        return BlankFragment.newInstance(list.get(position));
        LogUtils.e("getItem----------"+position);
        return FragmentFactory.createFragment(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
