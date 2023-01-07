package com.example.springboot1.service.impl;

import com.example.springboot1.common.api.CommonResult;
import com.example.springboot1.mapper.UmsAdminMapper;
import com.example.springboot1.mapper.UmsAdminPermissionRelationMapper;
import com.example.springboot1.mapper.UmsPermissionMapper;
import com.example.springboot1.model.UmsAdmin;
import com.example.springboot1.model.UmsAdminPermissionRelation;
import com.example.springboot1.model.UmsPermission;
import com.example.springboot1.service.UmsAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    
    @Autowired
    UmsAdminMapper umsAdminMapper;
    @Autowired
    UmsPermissionMapper umsPermissionMapper;
    @Autowired
    UmsAdminPermissionRelationMapper umsAdminPermissionRelationMapper;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public CommonResult register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        UmsAdmin ums = umsAdminMapper.selectByName(umsAdmin.getUsername());
        if(ums != null) {
            return CommonResult.failed();
        }
        String password = passwordEncoder.encode(umsAdmin.getPassword());
        ums.setPassword(password);
        umsAdminMapper.insert(umsAdmin);
        return CommonResult.success(ums);
    }

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return umsAdminMapper.selectByName(username);
    }

    @Override
    public List<UmsPermission> getPermissionList(Long id) {

        List<UmsAdminPermissionRelation> relations = umsAdminPermissionRelationMapper.selectPermissionIdByAdminId(id);
        List<UmsPermission> permissions = new ArrayList<>();
        relations.forEach(relation->{

            permissions.add(umsPermissionMapper.selectByPrimaryKey(relation.getPermissionId()));
        });
        return permissions;
    }
}
