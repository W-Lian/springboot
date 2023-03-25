package com.example.springboot1.aop_warning;

public interface AlarmWarnService {

    /**
     * 发送信息
     *
     * @param notifyMessage message
     */
    void send(NotifyMessage notifyMessage);
}
