package com.example.springboot1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
    * 后台用户登录日志表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsAdminLoginLogDTO {
    private Long id;

    private Long adminId;

    private Date createTime;

    private String ip;

    private String address;

    /**
    * 浏览器登录类型
    */
    private String userAgent;
}