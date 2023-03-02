package com.example.springboot1.control.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UmsAdminLoginLogVO {
    
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