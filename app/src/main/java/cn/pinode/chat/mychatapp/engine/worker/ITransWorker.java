package cn.pinode.chat.mychatapp.engine.worker;

import cn.pinode.chat.mychatapp.engine.worker.enums.WorkerType;

/**
 * @date on 2018年11月1日13:31:45
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc  网络传输任务
 */
public abstract class ITransWorker implements Runnable {
    private WorkerType type = WorkerType.DO_NOTHING;
    private long createTime;
    private long id;
    public long getCreateTime() {
        return createTime;
    }

    public ITransWorker(){}

    public WorkerType getType() {
        return type;
    }

    // 广播失败信息 等待订阅信息的用户处理对应的错误
    public void notifyError(){

    }

    // 广播成功信息 等待订阅信息的用户处理对应的
    public void notifySuccess(){

    }

}
