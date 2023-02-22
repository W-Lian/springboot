package com.example.springboot1.factory.chain.case1.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 处理器配置类
 */
@AllArgsConstructor
@Data
public class ProductCheckHandlerConfig {
    /**
     * 处理器Bean名称
     */
    private String handler;
    /**
     * 下一个处理器
     */
    private ProductCheckHandlerConfig next;
    /**
     * 是否降级
     */
    private Boolean down = Boolean.FALSE;
}
