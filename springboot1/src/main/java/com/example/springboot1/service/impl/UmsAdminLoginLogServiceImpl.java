package com.example.springboot1.service.impl;

import com.example.springboot1.mapper.UmsAdminLoginLogMapper;
import com.example.springboot1.model.UmsAdminLoginLog;
import com.example.springboot1.service.UmsAdminLoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UmsAdminLoginLogServiceImpl implements UmsAdminLoginLogService {
    
    @Resource
    UmsAdminLoginLogMapper umsAdminLoginLogMapper;
    
    @Override
    public UmsAdminLoginLog getAdminLoginLogById(Long id) {

        return umsAdminLoginLogMapper.selectByPrimaryKey(id);
    }
}
