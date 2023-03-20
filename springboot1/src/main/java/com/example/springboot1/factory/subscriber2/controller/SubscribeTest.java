package com.example.springboot1.factory.subscriber2.controller;

import com.example.springboot1.factory.subscriber2.entity.Express;
import com.example.springboot1.factory.subscriber2.service.ExpressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sendExpress")
@Slf4j
public class SubscribeTest {
    
    @Resource
    ExpressService expressService;
    
    @PostMapping("test")
    public void test2(@RequestBody Express express) {
//        expressEventPublisher.subscribe(expressEventSubscriber);
        expressService.sendExpress2(express);
    }

}
