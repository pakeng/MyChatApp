package cn.pinode.chat.mychatapp.engine.listeners;

public interface ILoginListener {
    void onSuccess(String user_json);
    void onError(int code, String msg);
    void onLogout();
}
