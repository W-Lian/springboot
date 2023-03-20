package com.example.springboot1.factory.subscriber2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Express {

    /**
     * 快递id
     */
    private String id;

    /**
     * 收件人名称
     */
    private String recipientName;

    /**
     * 收件人打电话
     */
    private String recipientPhone;

    /**
     * 收件人地址
     */
    private String recipientAddress;

}
