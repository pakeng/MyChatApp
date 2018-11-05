package cn.pinode.chat.mychatapp.engine.builder;

import com.google.gson.Gson;

import cn.pinode.chat.mychatapp.engine.bean.ChatMessageBean;
import cn.pinode.chat.mychatapp.engine.bean.EngineUserInfo;
import cn.pinode.chat.mychatapp.engine.bean.TextMessageBean;

public class Builder {
    private static Gson gson = new Gson();
    public static String buildTextMessage(String message, String to_user_id){
        if (EngineUserInfo.getUserInfo()==null)
            return null;
        TextMessageBean textMessageBean = new TextMessageBean();
        textMessageBean.setContent(message);
        ChatMessageBean chatMessageBean = new ChatMessageBean();
        chatMessageBean.setCreateTime(System.currentTimeMillis());
        chatMessageBean.setFrom_user_id(EngineUserInfo.getUserInfo().getUid());
        chatMessageBean.setTo_user_id(to_user_id);
        chatMessageBean.setMessage_type(0);
        chatMessageBean.setMsg_content(gson.toJson(textMessageBean));
        return gson.toJson(chatMessageBean);
    }

    public static String buildTextMessage(String message, String to_user_id,int type){
        if (EngineUserInfo.getUserInfo()==null)
            return null;
        TextMessageBean textMessageBean = new TextMessageBean();
        textMessageBean.setContent(message);
        ChatMessageBean chatMessageBean = new ChatMessageBean();
        chatMessageBean.setCreateTime(System.currentTimeMillis());
        chatMessageBean.setFrom_user_id(EngineUserInfo.getUserInfo().getUid());
        chatMessageBean.setTo_user_id(to_user_id);
        // TODO
        chatMessageBean.setMessage_type(type);
        chatMessageBean.setMsg_content(gson.toJson(textMessageBean));
        return gson.toJson(chatMessageBean);
    }

}
