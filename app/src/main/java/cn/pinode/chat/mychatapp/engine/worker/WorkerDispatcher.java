package cn.pinode.chat.mychatapp.engine.worker;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import cn.pinode.chat.mychatapp.engine.worker.enums.DispatchState;

/**
 * @date on 2018年11月1日14:48:16
 * @author vito
 * @org vito
 * @email dai625125312@gmail.com
 * @desc 任务调度器
 */
public class WorkerDispatcher {
    private static final int WORKER_MAX = 20; // 最大有20个消息等待执行
    private static final String DISPATCHER_THREAD = "dispatcher_thread";
    private Thread thread = null;
    private LinkedBlockingQueue<ITransWorker> workers = null;
    private DispatchState state = DispatchState.NOP;
    private MRunnable runnable;
    private static WorkerDispatcher instance = null;

    public static WorkerDispatcher getInstance(){
        if (instance==null){
            synchronized (WorkerDispatcher.class){
                if (instance == null) {
                    instance = new WorkerDispatcher();
                }
            }
        }
        return instance;
    }

    private WorkerDispatcher(){};

    /**
     * @param transWorker 任务
     * @return false  任务满了，需要等待 true 任务进栈成功
     */
    public boolean pushTask(ITransWorker transWorker){
        switch (state){
            case NOP:
            case ABORT:
                initThread();
                break;
        }
        try {
            workers.offer(transWorker, 200, TimeUnit.MILLISECONDS);
            state = DispatchState.WAITING;
        } catch (InterruptedException e) {
            e.printStackTrace();
            // 由 transWorker的发布者处理错误信息
            transWorker.notifyError();
            return false;
        }
        return true;
    }

    private void initThread() {
        if (workers==null)
            workers = new LinkedBlockingQueue<>(WORKER_MAX);
        runnable = new MRunnable();
        thread = new Thread(runnable);
        thread.start();
        thread.setName(DISPATCHER_THREAD);
        WorkerExecutor.getInstance().setRejectCallback(new IExecutorRejectCallback() {
            @Override
            public void RejectRunnable(ITransWorker worker) {
                pushTask(worker);
            }
        });
    }


    private class MRunnable implements Runnable {
        @Override
        public void run() {
            while (state!=DispatchState.SHUTDOWN||state!=DispatchState.STOP||state!=DispatchState.ABORT){
                switch (state){
                    case NOP:
                        break;
                    case WAITING:
                        // TODO
                        state = DispatchState.RUNNING;
                        break;
                    case RUNNING:
                        try {
                            if (workers.isEmpty()){
                                state = DispatchState.WAITING;
                                continue;
                            }
                            ITransWorker worker = workers.poll(200,TimeUnit.MILLISECONDS);
                            if (worker==null){
                                continue;
                            }
                            WorkerExecutor.getInstance().getExecutor().execute(worker);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            state = DispatchState.ABORT;
                        }
                        break;
                }
            }
        }
    };


}
