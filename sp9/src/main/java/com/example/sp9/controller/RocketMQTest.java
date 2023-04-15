package com.example.sp9.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/rocket")
public class RocketMQTest {
    @Autowired
    private RocketMQTemplate template;

    @PostMapping("/test")
    public void send() throws InterruptedException {
        Date day=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("生产时间："+sdf.format(day));
        template.convertAndSend("sanyouTopic", "三友的java日记");
        Thread.sleep(6000);
    }


}
