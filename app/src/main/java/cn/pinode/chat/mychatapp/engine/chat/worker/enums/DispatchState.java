package cn.pinode.chat.mychatapp.engine.chat.worker.enums;

public enum DispatchState {
    NOP, // 未初始化
    RUNNING, // 正在运行
    WAITING, // 等待
    SHUTDOWN, // 关闭
    ABORT, // 异常
    STOP, // 停止
}
