package cn.pinode.chat.mychatapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/**
 * @date on 2018年10月31日15:25:46
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 核心服务
 */
public class ChatCoreService extends Service {
    public ChatCoreService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
