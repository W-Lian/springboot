package com.example.springboot1.factory.subscriber;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * 支付宝观察者
 *
 * @author 湘王
 */
public class AliPayObserver {
    // 标记当前订阅者是线程安全的，支持并发接收消息
    @AllowConcurrentEvents
    @Subscribe
    public void pay(Account account) {
        if (account.getName().equalsIgnoreCase("ALI")) {
            System.out.println("支付宝 >>>>>> 已付款");
            System.out.println(account.getMessage());
        }
    }

}
