package com.example.springboot1.aop_warning;

//import cn.hutool.extra.template.TemplateConfig;

import lombok.RequiredArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.util.Map;

@RequiredArgsConstructor
public class YamlAlarmTemplateProvider extends BaseAlarmTemplateProvider{
    private final TemplateConfig templateConfig;
    

    @Override
    AlarmTemplate getAlarmTemplate(String templateId) {
        Map<String, AlarmTemplate> configTemplates = templateConfig.getTemplates();
        AlarmTemplate alarmTemplate = configTemplates.get(templateId);
        if (ObjectUtils.isEmpty(alarmTemplate)) {
            throw new RuntimeException("未发现告警配置模板");
        }
        return alarmTemplate;
    }
}
