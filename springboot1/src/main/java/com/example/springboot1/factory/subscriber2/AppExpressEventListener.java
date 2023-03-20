package com.example.springboot1.factory.subscriber2;

import com.example.springboot1.factory.subscriber2.entity.Express;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppExpressEventListener extends ExpressEventSubscriber{
    @Override
    public void arrive(Express express) {
        log.info("App通知，快递到达，快递编号{}", express.getId());
    }
}
