package com.gzticc.pincommon.ui.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gzticc.pincommon.R;
import com.gzticc.pincommon.base.BaseFragment;
import com.gzticc.pincommon.ui.activity.CollapsingToolbarLayoutActivity;
import com.gzticc.pincommon.ui.activity.GlideActivity;
import com.gzticc.pincommon.ui.adapter.IndexLvAdapter;
import com.gzticc.pincommon.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 首页
 */
public class IndexFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    @Bind(R.id.lvMenu)
    ListView lvMenu;
    private IndexLvAdapter indexLvAdapter;
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
    protected void initEvent() {
        lvMenu.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {
        List<String> menuData = new ArrayList<>();
        menuData.add("glide");
        menuData.add("CollapsingToolbarLayout");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        menuData.add("3");
        indexLvAdapter = new IndexLvAdapter(menuData,mActivity);
        lvMenu.setAdapter(indexLvAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
//                UIUtils.showToast("glide",0);
                openActivity(GlideActivity.class);
            break;
            case 1:
//                UIUtils.showToast("glide",0);
                openActivity(CollapsingToolbarLayoutActivity .class);
            break;
            default:
                break;
        }
    }
}
