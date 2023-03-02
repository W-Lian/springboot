package com.example.springboot1.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
    * 后台用户登录日志表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UmsAdminLoginLog {
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