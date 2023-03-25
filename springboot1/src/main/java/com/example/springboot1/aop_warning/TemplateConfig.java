package com.example.springboot1.aop_warning;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix="spring.alarm.template")
public class TemplateConfig {
    
    private TemplateSource source;
    
//    private String PREFIX;
    
    private Map<String, AlarmTemplate> templates;
}
