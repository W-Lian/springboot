//package com.example.springboot1.factory.subscriber2.component;
//
//
//import com.example.springboot1.factory.subscriber2.ExpressEventSubscriber;
//import com.example.springboot1.factory.subscriber2.entity.Express;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class ExpressEventPublisher {
//    List<ExpressEventSubscriber> expressEventSubscribers;
//    
//    public void add(Map<String, ExpressEventSubscriber> map){
//        map.values().forEach(value->{
//            expressEventSubscribers.add(value);
//        });
//    }
//    
//    public void remove(String key){
//        expressEventSubscribers.remove(key);
//    }
//    
//    public void notifyAll(Express express){
//        expressEventSubscribers.forEach(single->{
//            single.arrive(express);
//        });
//    }
//    
//}
