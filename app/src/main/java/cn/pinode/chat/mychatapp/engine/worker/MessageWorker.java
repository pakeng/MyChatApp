package cn.pinode.chat.mychatapp.engine.worker;

import cn.pinode.chat.mychatapp.constants.Config;
import cn.pinode.chat.mychatapp.engine.transmitter.MessageSendSocket;
import cn.pinode.chat.mychatapp.engine.transmitter.SocketsFactory;
import cn.pinode.chat.mychatapp.engine.worker.enums.WorkerType;

/**
 * @date on 2018年11月1日11:06:25
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 发送任务
 */
public class MessageWorker extends ITransWorker {
    private String msg;
    private WorkerType type = WorkerType.SENT_MESSAGE;

    public MessageWorker(String msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        MessageSendSocket messageSendSocket = SocketsFactory.getSocket(Config.SERVER_IP, Config.SERVER_PORT);
        if (messageSendSocket.isConnect()&&messageSendSocket.sendMessage(msg.getBytes())) {
            notifySuccess();
            return;
        }
        notifyError();
    }
}
