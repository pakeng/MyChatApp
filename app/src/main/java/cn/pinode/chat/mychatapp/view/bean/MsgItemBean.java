package cn.pinode.chat.mychatapp.view.bean;

import android.graphics.Bitmap;

/**
 * @date on 2018年11月6日10:53:18
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 聊天消息类
 */
public class MsgItemBean {
    public static final int TEXT = 1;
    private String user_name;
    private String user_title;
    private String msg_content;
    private int type;  // 图片 文本， 视频， ……
    private int alignment;  // 左右
    private boolean isGroup;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_title() {
        return user_title;
    }

    public void setUser_title(String user_title) {
        this.user_title = user_title;
    }

    public String getMsg_content() {
        return msg_content;
    }

    public void setMsg_content(String msg_content) {
        this.msg_content = msg_content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAlignment() {
        return alignment;
    }

    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    // 通过 头像名称获取头像bitmap
    public Bitmap getUserHeaderBitmap() {
        // TODO

        return null;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    // 通过 TITLE名称获取头像bitmap
    public Bitmap getUserTitleBitmap() {
        return null;
    }
}
