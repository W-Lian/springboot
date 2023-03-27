package com.example.sp7.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
//@Component
@ConfigurationProperties(prefix = "spring.redis.sentinel")
public class RedisParam {

    private String nodes ;
    private String master ;
    private Integer maxTotal ;
    private Integer minIdle ;
    private Integer maxWaitMillis ;
    private Integer timeBetweenEvictionRunsMillis ;
    private boolean testWhileIdle ;
    private boolean testOnBorrow ;
    private boolean testOnReturn ;
}
