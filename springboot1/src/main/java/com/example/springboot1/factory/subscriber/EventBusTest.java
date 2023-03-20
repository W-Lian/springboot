package com.example.springboot1.factory.subscriber;

import com.google.common.eventbus.EventBus;

import java.util.Date;

public class EventBusTest {

    // 回调通知
    public static void notifyObserver() {
        EventBus bus = new EventBus();
        AliPayObserver ali = new AliPayObserver();
        WeixinObserver weixin = new WeixinObserver();
        YuePayObserver yue = new YuePayObserver();
        bus.register(ali);
        bus.register(weixin);
        bus.register(yue);

        Account account1 = new Account("ALI", 1.6, new Date());
        bus.post(account1);
        Account account2 = new Account("WEIXIN", 2.2, new Date());
        bus.post(account2);
        Account account3 = new Account("YUE", 3, new Date());
        bus.post(account3);
    }

    public static void main(String[] args) throws InterruptedException {
        notifyObserver();
    }
}
