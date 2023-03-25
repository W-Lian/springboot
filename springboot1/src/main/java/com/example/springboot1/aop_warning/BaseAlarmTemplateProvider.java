package com.example.springboot1.aop_warning;

import org.springframework.util.StringUtils;

public abstract class BaseAlarmTemplateProvider implements AlarmTemplateProvider{
    @Override
    public AlarmTemplate loadingAlarmTemplate(String templateId) {

        if (StringUtils.isEmpty(templateId)) {
            throw new RuntimeException("告警模板配置id不能为空");
        }
        return getAlarmTemplate(templateId);
    }

    /**
     * 查询告警模板
     *
     * @param templateId 模板id
     * @return AlarmTemplate
     */
    abstract AlarmTemplate getAlarmTemplate(String templateId);
}
