package com.example.springboot1.mapper;

import com.example.springboot1.model.UmsPermission;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface UmsPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsPermission record);

    int insertSelective(UmsPermission record);

    UmsPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsPermission record);

    int updateByPrimaryKey(UmsPermission record);

    List<UmsPermission> selectPermissonList(Long id);
}