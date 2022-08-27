package com.example.springboot1.service;

import com.example.springboot1.model.UmsAdmin;
import com.example.springboot1.model.UmsPermission;

import java.util.List;

public interface UmsAdminService {

    UmsAdmin getAdminByUsername(String username);
    
    //List<UmsPermission> permissionList = adminService.getPermissionList(admin.getId());

    List<UmsPermission> getPermissionList(Long id);
}
