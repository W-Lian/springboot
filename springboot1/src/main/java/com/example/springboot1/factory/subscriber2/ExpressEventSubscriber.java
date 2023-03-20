package com.example.springboot1.factory.subscriber2;

import com.example.springboot1.factory.subscriber2.entity.Express;


public abstract class ExpressEventSubscriber {

    /**
     * 快递到达
     *
     * @param express 快递
     */
    public abstract void arrive(Express express) ;
}
