package cn.pinode.chat.mychatapp.engine.worker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @date on 2018年11月1日11:09:55
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 执行器
 */
public class WorkerExecutor {
    private static WorkerExecutor instance = null;
    private ThreadPoolExecutor executor = null;

    private IExecutorRejectCallback rejectCallback = null;

    public static WorkerExecutor getInstance(){
        if (instance==null){
            synchronized (WorkerExecutor.class){
                if (instance==null){
                    instance = new WorkerExecutor();
                }
            }
        }
        return instance;
    }

    private WorkerExecutor(){
        executor = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                if (rejectCallback!=null){
                    rejectCallback.RejectRunnable((ITransWorker) r);
                }
            }
        });
    }


    public ThreadPoolExecutor getExecutor() {
        return executor;
    }


    public void setRejectCallback(IExecutorRejectCallback rejectCallback) {
        this.rejectCallback = rejectCallback;
    }
}
