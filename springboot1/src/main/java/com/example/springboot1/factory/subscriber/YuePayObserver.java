package com.example.springboot1.factory.subscriber;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * 余额支付观察者
 *
 * @author 湘王
 */
public class YuePayObserver {

    // 标记当前订阅者是线程安全的，支持并发接收消息
    @AllowConcurrentEvents
    @Subscribe
    public void pay(Account account) {
        if (account.getName().equalsIgnoreCase("YUE")) {
            System.out.println("余额 >>>>>> 已付款");
            System.out.println(account.getMessage());
        }
    }

}
