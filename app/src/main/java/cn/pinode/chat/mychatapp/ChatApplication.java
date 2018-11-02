package cn.pinode.chat.mychatapp;

import android.app.Application;

import cn.pinode.chat.mychatapp.engine.ChatEngine;
import cn.pinode.chat.mychatapp.util.MLog;

/**
 * @date on 2018年10月31日15:27:40
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 启动App
 */


public class ChatApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MLog.setDebug(true);
        ChatEngine.InitEngine(this);
    }
}
