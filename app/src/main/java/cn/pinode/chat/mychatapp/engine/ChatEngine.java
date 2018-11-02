package cn.pinode.chat.mychatapp.engine;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import cn.pinode.chat.mychatapp.engine.bean.EngineUserInfo;
import cn.pinode.chat.mychatapp.engine.constant.EngineErrorCode;
import cn.pinode.chat.mychatapp.engine.listeners.IEngineStateListener;
import cn.pinode.chat.mychatapp.engine.listeners.ILoginListener;
import cn.pinode.chat.mychatapp.engine.login.LoginHelper;
import cn.pinode.chat.mychatapp.util.MLog;
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
    private static IEngineStateListener iEngineStateListener;
    private int login_state = EngineUserInfo.NOLOGIN;

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

    public static ChatEngine getInstance(Context context){
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
    public static void InitEngine(Application application, IEngineStateListener listener){

        if (Util.isMainProcess(application.getApplicationContext())){
            app = application;
            iEngineStateListener = listener;
        }
    }

    public void setDebug(boolean isDebug){
        MLog.setDebug(isDebug);
    }

    public static void onError(EngineErrorCode code){
        if (iEngineStateListener!=null){
            switch (code){
                case NEED_TO_LOG_IN:
                    iEngineStateListener.onUserInfoError();
                    break;
                case INIT_ERROR:
                    break;

            }
        }
    }

    public void login(String account, String password, int type, ILoginListener listener){
        LoginHelper loginHelper = new LoginHelper();
        loginHelper.login(account, password, 0, listener);
    }

}
