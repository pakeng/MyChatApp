package cn.pinode.chat.mychatapp.engine.chat.worker;

public interface IExecutorRejectCallback {
    void RejectRunnable(ITransWorker worker);
}
