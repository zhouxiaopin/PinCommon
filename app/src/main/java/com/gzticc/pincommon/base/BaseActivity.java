package com.gzticc.pincommon.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gzticc.pincommon.R;
import com.gzticc.pincommon.global.PinCommonApplication;
import com.gzticc.pincommon.utils.UIUtils;

import butterknife.ButterKnife;
import cn.gzticc.baselibrary.utils.StatusBarUtil;

/**
 * @author pin
 * @Description:
 * @date 2017/12/20 8:44
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        setStatusBar();

    }
    protected void setStatusBar() {
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorAccent));
        StatusBarUtil.setColor(this, UIUtils.getColor(R.color.colorPrimary));
    }
    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
    }
    protected void openActivity(Class<?> clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);

    }
    protected void openActivity(Class<?> clazz, Bundle bundle){
        Intent intent = new Intent(this,clazz);
        if(null != bundle){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    protected void openActivityForResult(Class<?> clazz, int requesCode){
        Intent intent = new Intent(this,clazz);
        startActivityForResult(intent,requesCode);
    }
    protected void openActivityForResult(Class<?> clazz, int requesCode, Bundle bundle){
        Intent intent = new Intent(this,clazz);
        if(null != bundle){
            intent.putExtras(bundle);
        }
        startActivityForResult(intent,requesCode);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //出栈并且结束activity
        PinCommonApplication.finishActivity();
    }

}
