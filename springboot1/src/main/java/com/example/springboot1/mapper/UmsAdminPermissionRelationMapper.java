package com.example.springboot1.mapper;

import com.example.springboot1.model.UmsAdminPermissionRelation;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface UmsAdminPermissionRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdminPermissionRelation record);

    int insertSelective(UmsAdminPermissionRelation record);

    UmsAdminPermissionRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdminPermissionRelation record);

    int updateByPrimaryKey(UmsAdminPermissionRelation record);

    List<UmsAdminPermissionRelation> selectPermissionIdByAdminId(Long adminId);
}