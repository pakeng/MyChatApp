package cn.pinode.chat.mychatapp.model;

public class UserInfo {
    private String uid;   // 用户id
    private String account_name; // 登录账号
    private String password;  // 密码 MD5 加密
    private String token; // 登录token
    private int login_type; // 登录类型


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getLogin_type() {
        return login_type;
    }

    public void setLogin_type(int login_type) {
        this.login_type = login_type;
    }

}
