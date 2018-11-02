package cn.pinode.chat.mychatapp.engine.worker;

public interface IExecutorRejectCallback {
    void RejectRunnable(ITransWorker worker);
}
