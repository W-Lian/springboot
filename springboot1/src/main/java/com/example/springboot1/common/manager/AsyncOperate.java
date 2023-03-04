package com.example.springboot1.common.manager;

import com.example.springboot1.mapper.SysOperLogMapper;
import com.example.springboot1.model.SysOperLog;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Async
@Component
public class AsyncOperate {
    @Resource
    SysOperLogMapper sysOperLogMapper;
    
    public void saveLog(SysOperLog sysOperLog){
        sysOperLogMapper.insert(sysOperLog);
    }
}
