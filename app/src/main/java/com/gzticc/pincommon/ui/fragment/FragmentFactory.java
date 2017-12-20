package com.gzticc.pincommon.ui.fragment;

import com.gzticc.pincommon.base.BaseFragment;

import java.util.HashMap;

/**
 * @author pin
 * @Description:
 * @date 2017/12/19 14:49
 */

public class FragmentFactory {
    private static HashMap<Integer, BaseFragment> mFragmentMap = new HashMap<>();
    public static BaseFragment createFragment(int pos) {
        // 先从集合中取, 如果没有,才创建对象, 提高性能
        BaseFragment fragment = mFragmentMap.get(pos);

        if (fragment == null) {
            switch (pos) {
                case 0:
//                    fragment = new HomeFragment();
                    fragment = new IndexFragment();
//                    fragment = BlankFragment.newInstance("首页");
                    break;
                case 1:
                    fragment = new OrderFragment();
//                    fragment = BlankFragment.newInstance("订购");
                    break;
                case 2:
                    fragment = new RequireFragment();
//                    fragment = BlankFragment.newInstance("需求");
                    break;
                case 3:
                    fragment = new MyFragment();
//                    fragment = BlankFragment.newInstance("我的");
                    break;
                default:
                    break;
            }

            mFragmentMap.put(pos, fragment);// 将fragment保存在集合中
        }
        return fragment;
    }
}
