package cn.pinode.chat.mychatapp.engine.transmitter;

/**
 * @date on 2018年11月1日17:00:55
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc Sockets 工厂类 ，希望能实现socket的复用。
 */
public class SocketsFactory {
    private static SocketsFactory factory = null;

    private SocketsFactory(){}

    private static void initFactory(){
        if (factory==null){
            synchronized (SocketsFactory.class){
                if (factory==null){
                    factory = new SocketsFactory();
                }
            }
        }
    }

    public static MessageSendSocket getSocket(String serverIp, String serverPort){
        if (factory==null)
            initFactory();
        MessageSendSocket socket = new MessageSendSocket();
        socket.setConnect(socket.InitSocket(serverIp, serverPort));
        return socket;
    }

}
