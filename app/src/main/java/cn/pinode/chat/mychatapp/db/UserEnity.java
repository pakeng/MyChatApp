package cn.pinode.chat.mychatapp.db;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.annotation.Unique;

/**
 * @date on 2018年11月2日13:19:55
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 请添加描述
 */

@Entity
public class UserEnity {
    @Id public long id;
    @Unique @Index private String uid;   // 用户id
    @Unique @Index private String account_name; // 登录账号
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
