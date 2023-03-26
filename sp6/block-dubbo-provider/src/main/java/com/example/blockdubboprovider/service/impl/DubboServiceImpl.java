package com.example.blockdubboprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.blockdubbocommon.module.UserEntity;
import com.example.blockdubbocommon.service.DubboService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Service
@Component
@Slf4j
public class DubboServiceImpl implements DubboService {
    @Override
    public String getInfo(String param) {
        log.info("入参：{}"+param);
        return "Hello WL";
    }

    @Override
    public UserEntity getUserInfo(UserEntity userEntity) {
        log.info("入参：{}"+userEntity);
        return userEntity;
    }

    @Override
    public String timeOut(Integer time) {
        log.info("timeOut入参：{}"+time);
        try{
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
            return "超时了..." ;
        }
        return "SUCCESS";
    }
}
