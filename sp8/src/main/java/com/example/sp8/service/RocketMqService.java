package com.example.sp8.service;

import org.apache.rocketmq.client.producer.SendResult;

public interface RocketMqService {

    SendResult openAccountMsg (String msgInfo) ;
}
