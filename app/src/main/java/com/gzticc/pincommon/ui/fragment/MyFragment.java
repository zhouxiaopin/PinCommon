package com.gzticc.pincommon.ui.fragment;

import com.gzticc.pincommon.R;
import com.gzticc.pincommon.base.BaseFragment;
import com.gzticc.pincommon.utils.LogUtils;

/**
 * 我的
 */
public class MyFragment extends BaseFragment {

    public MyFragment() {
        LogUtils.d("new MyFragment");
    }


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        if (getArguments() != null) {
////            mParam1 = getArguments().getString(ARG_PARAM1);
////            mParam2 = getArguments().getString(ARG_PARAM2);
////        }
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initData() {

    }
}
