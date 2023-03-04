package com.example.springboot1.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.springboot1.mapper.SysOperLogMapper;
import com.example.springboot1.model.SysOperLog;
import com.example.springboot1.service.SysOperLogService;
@Service
public class SysOperLogServiceImpl implements SysOperLogService{

    @Resource
    private SysOperLogMapper sysOperLogMapper;

    @Override
    public int deleteByPrimaryKey(Long operId) {
        return sysOperLogMapper.deleteByPrimaryKey(operId);
    }

    @Override
    public int insert(SysOperLog record) {
        return sysOperLogMapper.insert(record);
    }

    @Override
    public int insertSelective(SysOperLog record) {
        return sysOperLogMapper.insertSelective(record);
    }

    @Override
    public SysOperLog selectByPrimaryKey(Long operId) {
        return sysOperLogMapper.selectByPrimaryKey(operId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysOperLog record) {
        return sysOperLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysOperLog record) {
        return sysOperLogMapper.updateByPrimaryKey(record);
    }

}
