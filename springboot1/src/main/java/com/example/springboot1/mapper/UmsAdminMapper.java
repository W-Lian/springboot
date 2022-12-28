package com.example.springboot1.mapper;

import com.example.springboot1.model.UmsAdmin;
import org.springframework.stereotype.Repository;

//@Repository
public interface UmsAdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdmin record);

    int insertSelective(UmsAdmin record);

    UmsAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdmin record);

    int updateByPrimaryKey(UmsAdmin record);

    UmsAdmin selectByName(String name);
}