package cn.pinode.chat.mychatapp;

import android.app.Application;
import android.widget.Toast;

import cn.pinode.chat.mychatapp.db.MyObjectBox;
import cn.pinode.chat.mychatapp.engine.ChatEngine;
import cn.pinode.chat.mychatapp.engine.listeners.IEngineStateListener;
import io.objectbox.BoxStore;

/**
 * @date on 2018年10月31日15:27:40
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 启动App
 */


public class ChatApplication extends Application {
    private BoxStore boxStore;
    @Override
    public void onCreate() {
        super.onCreate();
        ChatEngine.InitEngine(this, new IEngineStateListener() {
            @Override
            public void onLoginExpired() {

            }

            @Override
            public void onUserInfoError() {
                Toast.makeText(ChatApplication.this, "尚未登录！", Toast.LENGTH_SHORT).show();
            }
        });
        boxStore = MyObjectBox.builder().androidContext(this).build();
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}
