package com.my.fridademo;

import android.util.Log;

public class Util2 {

    private static String TAG = "10001";
    static int num = 0;

    //主动调用 静态方法
    static String active_static_call_func(String parma) {
        Log.e(TAG, "active_static_call_func ||| parma : " + parma);
        return "static主动调用失败! err:" + parma;
    }

    //主动调用 普通方法
    public String active_call_func(String parma) {
        Log.e(TAG, "active_call_func ||| parma : " + parma + " ----> " + num++);
        return "主动调用失败! err:" + parma;
    }

}
