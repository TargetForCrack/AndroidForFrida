package com.my.fridademo;

import android.util.Log;

public class Util2 {

    private static String TAG = "10001";
    private static int num = 0;
    public static boolean static_bool_var = false;
    private boolean bool_var = false;

    //主动调用 静态方法
    public static String active_static_call_func(String parma) {
        Log.e(TAG, "active_static_call_func ||| parma : " + parma + "  属性static_bool_var : " + static_bool_var + " ----> " + num++);
        return "static 在log日志里查看效果! err:" + parma;
    }

    //主动调用 普通方法
    public String active_call_func(String parma) {
        Log.e(TAG, "active_call_func ||| parma : " + parma + "  属性bool_var : " + bool_var + " ----> " + num++);
        return "在log日志里查看效果! err:" + parma;
    }

}
