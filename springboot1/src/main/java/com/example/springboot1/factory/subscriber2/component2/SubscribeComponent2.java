package com.example.springboot1.factory.subscriber2.component2;


import com.example.springboot1.factory.subscriber2.ExpressEventSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
@Slf4j
public class SubscribeComponent2 {

    @Resource
    private Map<String, ExpressEventSubscriber> subscribeMap;
    
    @Resource
    ExpressEventPublisher2 expressEventPublisher;
    
    //初始化所有的订阅者
    public void initSubscriber(){

        log.info("subscribeMap:{}", subscribeMap);
        expressEventPublisher.add(subscribeMap);
        

    }

    public ExpressEventSubscriber getSubscriber(String name){
        return subscribeMap.get(name);
    }
}
