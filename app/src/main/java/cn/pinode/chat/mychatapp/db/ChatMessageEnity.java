package cn.pinode.chat.mychatapp.db;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * @date on 2018年11月2日13:19:42
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 聊天消息
 */
@Entity
public class ChatMessageEnity {
    @Id public long id;
    private int message_type; // 消息类型 系统 ， 普通， 群组 ……
    private long createTime;
    private String from_user_id;
    private String to_user_id;
    private String msg_content; // 消息内容 json保存

    private int state; // 发送状态 成功 失败，正在发送中

    public int getMessage_type() {
        return message_type;
    }

    public void setMessage_type(int message_type) {
        this.message_type = message_type;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(String from_user_id) {
        this.from_user_id = from_user_id;
    }

    public String getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(String to_user_id) {
        this.to_user_id = to_user_id;
    }

    public String getMsg_content() {
        return msg_content;
    }

    public void setMsg_content(String msg_content) {
        this.msg_content = msg_content;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
