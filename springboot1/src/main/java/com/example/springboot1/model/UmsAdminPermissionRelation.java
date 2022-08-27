package com.example.springboot1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsAdminPermissionRelation {
    private Long id;

    private Long adminId;

    private Long permissionId;

    private Integer type;
}