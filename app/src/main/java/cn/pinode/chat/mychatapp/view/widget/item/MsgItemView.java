package cn.pinode.chat.mychatapp.view.widget.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.pinode.chat.mychatapp.R;
import cn.pinode.chat.mychatapp.view.bean.MsgItemBean;

/**
 * @date on 2018年11月6日10:58:47
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 聊天界面的消息View
 */
public class MsgItemView extends RelativeLayout {

    private ImageView header;
    private ImageView user_title; // 群组聊天的时候用
    private TextView user_name;
    private TextView text_msg_content; // 文字聊天 内容
    private ImageView img_msg_content; // 图片聊天 内容
    private int msg_alignment; // 对齐方式
    private int msg_type;


    public MsgItemView(Context context) {
        super(context);
    }

    public MsgItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MsgItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MsgItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        // 初始化界面
        user_name = findViewById(R.id.user_name);
        user_title = findViewById(R.id.user_title);
        header = findViewById(R.id.user_header_img);
        img_msg_content = findViewById(R.id.msg_img_content);
        text_msg_content = findViewById(R.id.msg_text_content);
    }

    private void initWithData(MsgItemBean msgItemBean){
        user_name.setText(msgItemBean.getUser_name());
        header.setImageBitmap(msgItemBean.getUserHeaderBitmap());
        user_title.setImageBitmap(msgItemBean.getUserTitleBitmap());

        if(msgItemBean.getType() == MsgItemBean.TEXT){
            img_msg_content.setVisibility(View.GONE);
            text_msg_content.setText(msgItemBean.getMsg_content());
        }

        // 刷新显示
        invalidate();
    }


}
