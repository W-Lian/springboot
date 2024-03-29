package com.example.springboot5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
    * 后台用户表
    */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UmsAdminDO {
    private Long id;

    private String username;

    private String password;

    /**
    * 头像
    */
    private String icon;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 昵称
    */
    private String nickName;

    /**
    * 备注信息
    */
    private String note;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 最后登录时间
    */
    private Date loginTime;

    /**
    * 帐号启用状态：0->禁用；1->启用
    */
    private Integer status;
    
}