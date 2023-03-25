package com.example.springboot1.aop_warning;

import cn.hutool.extra.mail.MailUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.concurrent.CompletableFuture;

@Slf4j
public abstract class BaseWarnService implements AlarmWarnService {
    @Override
    public void send(NotifyMessage notifyMessage) {
        if (notifyMessage.getMessageTye().equals(MessageTye.TEXT)) {
            CompletableFuture.runAsync(() -> {
                try {
                    doSendText(notifyMessage.getMessage());
                } catch (Exception e) {
                    log.error("send text warn message error", e);
                }
            });
        } else if (notifyMessage.getMessageTye().equals(MessageTye.MARKDOWN)) {
//            CompletableFuture.runAsync(() -> {
                try {
//                    doSendMarkdown(notifyMessage.getTitle(), notifyMessage.getMessage());
                   log.info("aaaa");
                    MailUtil.send("1553279148@qq.com", "title", "message", true, new File("D:\\gt_project\\ydtb\\日志\\20220328\\pic.html"));

                    log.info("end");
                } catch (Exception e) {
                    log.error("send markdown warn message error", e);
                }
//            });
        }
    }

    /**
     * 发送Markdown消息
     *
     * @param title   Markdown标题
     * @param message Markdown消息
     * @throws Exception 异常
     */
    protected abstract void doSendMarkdown(String title, String message) throws Exception;

    /**
     * 发送文本消息
     *
     * @param message 文本消息
     * @throws Exception 异常
     */
    protected abstract void doSendText(String message) throws Exception;
    
}
