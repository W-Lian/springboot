package com.example.springboot1.mapper;

import com.example.springboot1.model.UmsAdminPermissionRelation;

import java.util.List;

public interface UmsAdminPermissionRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdminPermissionRelation record);

    int insertSelective(UmsAdminPermissionRelation record);

    UmsAdminPermissionRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdminPermissionRelation record);

    int updateByPrimaryKey(UmsAdminPermissionRelation record);

    List<UmsAdminPermissionRelation> selectPermissionIdByAdminId(Long adminId);
}