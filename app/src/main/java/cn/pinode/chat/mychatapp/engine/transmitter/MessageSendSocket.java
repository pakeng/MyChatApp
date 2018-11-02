package cn.pinode.chat.mychatapp.engine.transmitter;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import cn.pinode.chat.mychatapp.constants.Config;
import cn.pinode.chat.mychatapp.util.MLog;

/**
 * @date on 2018年10月31日16:11:11
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 消息的发送socket
 */
public class MessageSendSocket implements ISender{
    private Socket socket;
    private OutputStream outputStream;
    private boolean isConnect = false;

    public boolean InitSocket(String ip, String port){
        try{
            socket = new Socket(ip, Integer.parseInt(port));
            outputStream = socket.getOutputStream();
        }catch (IOException e){
            e.printStackTrace();
            socket = null;
            return false;
        }
        return true;
    }

    @Override
    public boolean sendMessage(byte[] msg) {
        MLog.e("MessageSendSocket", "isBound" + socket.isBound() + " isConnected" + socket.isConnected());
        if(socket!=null&&outputStream!=null){
            try {
                outputStream.write(msg);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            MLog.e(Config.C_TAG, "please init MessageSendSocket !");
            return false;
        }
        return true;
    }

    /**
     * 关闭连接
     */
    public void close() {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket.isInputShutdown()) { //判断输入流是否为打开状态
            try {
                socket.shutdownInput();  //关闭输入流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket.isOutputShutdown()) {  //判断输出流是否为打开状态
            try {
                socket.shutdownOutput(); //关闭输出流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket.isConnected()) {  //判断是否为连接状态
            try {
                socket.close();  //关闭socket
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean isConnect() {
        return isConnect;
    }

    public void setConnect(boolean connect) {
        isConnect = connect;
    }
}
