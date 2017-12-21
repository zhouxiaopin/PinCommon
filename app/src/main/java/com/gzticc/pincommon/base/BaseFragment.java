package com.gzticc.pincommon.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * @author pin
 * @Description:
 * @date 2017/12/20 9:50
 */

public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;

    /**
     * 获得全局的，防止使用getActivity()为空
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity)context;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState) {

        View view = LayoutInflater.from(mActivity)
                .inflate(getLayoutId(), container, false);
//        View view = UIUtils.inflate(getLayoutId());
        initView(view, savedInstanceState);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEvent();
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    protected void openActivity(Class<?> clazz){
        Intent intent = new Intent(mActivity,clazz);
        startActivity(intent);

    }
    protected void openActivity(Class<?> clazz, Bundle bundle){
        Intent intent = new Intent(mActivity,clazz);
        if(null != bundle){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    protected void openActivityForResult(Class<?> clazz, int requesCode){
        Intent intent = new Intent(mActivity,clazz);
        startActivityForResult(intent,requesCode);
    }
    protected void openActivityForResult(Class<?> clazz, int requesCode, Bundle bundle){
        Intent intent = new Intent(mActivity,clazz);
        if(null != bundle){
            intent.putExtras(bundle);
        }
        startActivityForResult(intent,requesCode);
    }

    /**
     * 该抽象方法就是 onCreateView中需要的layoutID
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 该抽象方法就是 初始化view
     * @param view
     * @param savedInstanceState
     */
    protected void initView(View view, Bundle savedInstanceState){}

    /**
     * 执行数据的加载
     */
    protected abstract void initData();

    /**
     * 初始化Event
     */
    protected void initEvent(){}

}
