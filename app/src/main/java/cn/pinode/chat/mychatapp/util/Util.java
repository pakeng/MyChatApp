package cn.pinode.chat.mychatapp.util;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @date on 2018年10月31日15:22:17
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 工具类
 */

public class Util {


    /**
     * 获取当前进程的名字，一般就是当前app的包名
     * @param context 当前上下文
     * @return 返回进程的名字
     */
    public static String getProcessName(Context context)
    {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        List<ActivityManager.RunningAppProcessInfo> list = new ArrayList<>();
        if (activityManager != null){
             list = activityManager.getRunningAppProcesses();
            Log.e("Util", "getRunningAppProcesses == null ");
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo info: list)
        {
            try
            {
                if (info.pid == pid)
                {
                    // 根据进程的信息获取当前进程的名字
                    return info.processName;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        // 没有匹配的项，返回为null
        return null;
    }

    /**
     * 判断是否是主进程
     * return
     */
    public static boolean isMainProcess(Context context){
        if (context!=null){
            return context.getApplicationInfo().packageName.equalsIgnoreCase(getProcessName(context));
        }else {
            Log.e("Util", "isMainProcess context = null");
            return false;
        }

    }

}
