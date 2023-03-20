package com.example.springboot1.factory.subscriber2.service.impl;

//import com.example.springboot1.factory.subscriber2.component.SubscribeComponent;
import com.example.springboot1.factory.subscriber2.component2.ExpressEventPublisher2;
import com.example.springboot1.factory.subscriber2.component2.SubscribeComponent2;
import com.example.springboot1.factory.subscriber2.entity.Express;
//import com.example.springboot1.factory.subscriber2.component.ExpressEventPublisher;
import com.example.springboot1.factory.subscriber2.service.ExpressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExpressServiceImpl implements ExpressService {
    
//    @Autowired
//    ExpressEventPublisher expressEventPublisher;
//    
//    @Autowired
//    SubscribeComponent subscribeComponent;
//    
//    @Autowired
//    SubscribeComponent subscribe;
    
//    @Override
//    public void sendExpress(Express express) {
//        log.info("快递已接件");
////        expressEventPublisher.subscribe(expressEventSubscriber);
//        subscribe.initSubscriber();
//        expressEventPublisher.notifyAll(express);
//        
//    }
    
    @Autowired
    SubscribeComponent2 sc2;
    
    @Autowired
    ExpressEventPublisher2 ep2;

    @Override
    public void sendExpress2(Express express) {
        log.info("快递已接件");
        sc2.initSubscriber();
        ep2.notifyAll(express);

    }


    
}
