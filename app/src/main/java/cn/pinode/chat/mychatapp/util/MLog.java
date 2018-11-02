package cn.pinode.chat.mychatapp.util;

import android.util.Log;
/**
 * @date on 2018年10月31日16:26:52
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 日志类
 */

// 需要添加上传网络功能

public class MLog {
    private static boolean debug = false;

    public static void e(String TAG, String msg){
        if (debug)
            Log.e(TAG, msg);
    }

    public static void d(String TAG, String msg){
        if (debug)
            Log.d(TAG, msg);
    }

    public static void i(String TAG, String msg){
        if (debug)
            Log.i(TAG, msg);
    }

    public static void w(String TAG, String msg){
        if (debug)
            Log.w(TAG, msg);
    }


    public static void setDebug(boolean isDebug) {
        debug = isDebug;
    }
}
