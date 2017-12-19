package com.gzticc.pincommon.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.gzticc.pincommon.global.PinCommonApplication;

/**
 * @author pin
 * @Description: UI工具
 * @date 2017/12/4 16:59
 */

public class UIUtils {
    /**
     *
     * @Title: getContext
     * @Description:  获取全局上下文
     * @author pin
     * @date 2017-2-24 下午2:14:07
     * @return Context
     */
    public static Context getContext() {
        return PinCommonApplication.getContext();
    }

    /**
     *
     * @Title: getContext
     * @Description:  获取全局消息处理者
     * @author pin
     * @date 2017-2-24 下午2:14:07
     * @return Handler
     */
    public static Handler getHandler() {
        return PinCommonApplication.getHandler();
    }


    /**
     *
     * @Title: getContext
     * @Description:  获取主线程id
     * @author pin
     * @date 2017-2-24 下午2:14:07
     * @return int
     */
    public static int getMainThreadId() {
        return PinCommonApplication.getMainThreadId();
    }

    /**
     *
     * @Title: showToast
     * @Description: 显示提示
     * @author pin
     * @date 2017-2-24 下午2:17:20
     * @param msg	要提示的信息
     * @param type	0为Toast.LENGTH_SHORT，1为Toast.LENGTH_LONG
     * @return void
     */
    public static void showToast(String msg, int type) {
        if(type == 0){
            Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
        }
    }

    // /////////////////加载布局文件//////////////////////////
    public static View inflate(int id) {
        return View.inflate(getContext(), id, null);
    }

    // /////////////////判断是否运行在主线程//////////////////////////
    public static boolean isRunOnUIThread() {
        // 获取当前线程id, 如果当前线程id和主线程id相同, 那么当前就是主线程
        int myTid = android.os.Process.myTid();
        if (myTid == getMainThreadId()) {
            return true;
        }

        return false;
    }

    // 运行在主线程
    public static void runOnUIThread(Runnable r) {
        if (isRunOnUIThread()) {
            // 已经是主线程, 直接运行
            r.run();
        } else {
            // 如果是子线程, 借助handler让其运行在主线程
            getHandler().post(r);
        }
    }

    // /////////////////加载资源文件 ///////////////////////////

    // 获取字符串
    public static String getString(int id) {
        return getContext().getResources().getString(id);
    }
    // 获取字符串
    public static Drawable getDrawable(int id) {
        return getContext().getResources().getDrawable(id);
    }

}
