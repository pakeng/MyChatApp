package cn.pinode.chat.mychatapp.engine.listeners;

public interface IEngineStateListener {
    void onLoginExpired();
    void onUserInfoError();
}
