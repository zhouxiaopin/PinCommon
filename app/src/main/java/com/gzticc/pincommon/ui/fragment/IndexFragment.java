package com.gzticc.pincommon.ui.fragment;

import com.gzticc.pincommon.R;
import com.gzticc.pincommon.base.BaseFragment;
import com.gzticc.pincommon.utils.LogUtils;

/**
 * 首页
 */
public class IndexFragment extends BaseFragment {
    public IndexFragment() {
        LogUtils.d("new IndexFragment");
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
        return R.layout.fragment_index;
    }

    @Override
    protected void initData() {

    }

}
