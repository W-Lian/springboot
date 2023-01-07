package com.example.springboot1.service;

import com.example.springboot1.common.api.CommonResult;
import com.example.springboot1.model.UmsAdmin;
import com.example.springboot1.model.UmsPermission;

import java.util.List;

public interface UmsAdminService {


    CommonResult register(UmsAdmin umsAdminParam);


    UmsAdmin getAdminByUsername(String username);

    CommonResult login(UmsAdmin umsAdminParam);

    List<UmsPermission> getPermissionList(Long id);
}
