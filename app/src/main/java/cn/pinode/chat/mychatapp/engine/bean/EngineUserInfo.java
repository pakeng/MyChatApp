package cn.pinode.chat.mychatapp.engine.bean;

import cn.pinode.chat.mychatapp.engine.ChatEngine;
import cn.pinode.chat.mychatapp.engine.constant.EngineErrorCode;

/**
 * @date on 2018年11月2日14:19:31
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 用户信息 供引擎使用
 */
public class EngineUserInfo {
    public static final int LOGOUT = 1000;
    public static final int NOLOGIN = 1001;
    public static final int LOGIN = 1002;
    private static EngineUserInfo userInfo = null;
    private ChatEngine engine;
    private String uid;
    private int login_type; //登录类型
    private String token;
    private long lastTime;
    private long timeOut; // 登录超时时间
    private int state = NOLOGIN;
    public EngineUserInfo(){
        userInfo = this;
    }

    public static EngineUserInfo getUserInfo(){
        if (userInfo==null||userInfo.state==LOGOUT){
            ChatEngine.onError(EngineErrorCode.NEED_TO_LOG_IN);
            return null;
        }
        return userInfo;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getLogin_type() {
        return login_type;
    }

    public void setLogin_type(int login_type) {
        this.login_type = login_type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ChatEngine getEngine() {
        return engine;
    }

    public void setEngine(ChatEngine engine) {
        this.engine = engine;
    }
}
