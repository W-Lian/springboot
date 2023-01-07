package com.example.springboot1.service.impl;

import cn.hutool.json.JSONObject;
import com.example.springboot1.common.api.CommonResult;
import com.example.springboot1.common.utils.JwtTokenUtil;
import com.example.springboot1.mapper.UmsAdminMapper;
import com.example.springboot1.mapper.UmsAdminPermissionRelationMapper;
import com.example.springboot1.mapper.UmsPermissionMapper;
import com.example.springboot1.model.UmsAdmin;
import com.example.springboot1.model.UmsAdminPermissionRelation;
import com.example.springboot1.model.UmsPermission;
import com.example.springboot1.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UmsAdminServiceImpl implements UmsAdminService {
    
    @Autowired
    UmsAdminMapper umsAdminMapper;
    @Autowired
    UmsPermissionMapper umsPermissionMapper;
    @Autowired
    UmsAdminPermissionRelationMapper umsAdminPermissionRelationMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    String tokenHead;


    @Override
    public CommonResult register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        UmsAdmin ums = umsAdminMapper.selectByName(umsAdmin.getUsername());
        if(ums != null) {
            return CommonResult.failed("用户"+umsAdmin.getUsername()+"已存在");
        }
        String password = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(password);
        umsAdminMapper.insert(umsAdmin);
        return CommonResult.success(ums);
    }

    @Override
    public CommonResult login(UmsAdmin umsAdminParam) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(umsAdminParam.getUsername());
        if(!passwordEncoder.matches(umsAdminParam.getPassword(), userDetails.getPassword())){
            log.info("密码错误");
            return CommonResult.failed("密码错误");
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(userDetails);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", tokenHead+" "+token);
        jsonObject.put("tokenHead", "Authorization");

        return CommonResult.success(jsonObject);
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
