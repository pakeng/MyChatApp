package cn.pinode.chat.mychatapp.engine;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import cn.pinode.chat.mychatapp.util.Util;

/**
 * @date on 2018年10月31日15:45:58
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 聊天引擎单例
 */
public class ChatEngine {
    // 全局上下文
    private static Context app = null;

    private ChatEngine(Context context){
        if (context==null){
            if (app!=null){
                // TODO
            }else {
                Log.e("CHATENGINE", "getInstance context not be null");
            }
        }
//        throw new ExceptionInInitializerError("please use getInstance(Context context)");
    }

    private static ChatEngine instance = null;

    public ChatEngine getInstance(Context context){
        if (instance == null){
            synchronized (ChatEngine.class){
                if (instance == null){
                    instance = new ChatEngine(context);
                }
            }
        }

        return instance;
    }

    /**
     * 初始化方法
     * @param application 应用Application
     */
    public static void InitEngine(Application application){

        if (Util.isMainProcess(application.getApplicationContext())){
            app = application;
        }
    }



}
