package com.example.springboot1.factory.subscriber2.component2;


import com.example.springboot1.factory.subscriber2.ExpressEventSubscriber;
import com.example.springboot1.factory.subscriber2.entity.Express;
import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ExpressEventPublisher2 {
//    List<ExpressEventSubscriber> expressEventSubscribers;
    
    EventBus eventBus = new EventBus();
    
    public void add(Map<String, ExpressEventSubscriber> map){
        map.values().forEach(value->{
            eventBus.register(value);
        });
    }
    
    public void remove(ExpressEventSubscriber sub){
        eventBus.unregister(sub);
    }
    
    public void notifyAll(Express express){
        eventBus.post(express);
    }
    
}
