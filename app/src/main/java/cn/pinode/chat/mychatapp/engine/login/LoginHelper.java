package cn.pinode.chat.mychatapp.engine.login;

import android.util.Log;

import cn.pinode.chat.mychatapp.engine.ChatEngine;
import cn.pinode.chat.mychatapp.engine.bean.EngineUserInfo;
import cn.pinode.chat.mychatapp.engine.listeners.ILoginListener;

public class LoginHelper {

    public void login(String account, String password, int type, ILoginListener listener){
        // TODO login
        if (listener == null){
            Log.e("LOGIN", "please set LoginListener");
            return;
        }
        // TODO
        String result = "{\"uid\":\"vito\",\"token\":\"123123123\",\"type\":1}";
        listener.onSuccess(result);
        bindUser("vito", 1, "123123123", 24*60*60*1000L);

    }

    public void logout(){
        if (EngineUserInfo.getUserInfo()!=null){
            EngineUserInfo.getUserInfo().setState(EngineUserInfo.LOGOUT);
        }

    }

    private void bindUser(String uid, int login_type, String token, long timeOut){
        EngineUserInfo userInfo = new EngineUserInfo();
        userInfo.setTimeOut(timeOut);
        userInfo.setLastTime(System.currentTimeMillis());
        userInfo.setUid(uid);
        userInfo.setLogin_type(login_type);
        userInfo.setToken(token);
        userInfo.setEngine(ChatEngine.getInstance(null));
    }
}
