package com.example.springboot1.aop_warning;

public interface AlarmTemplateProvider {

    /**
     * 加载告警模板
     *
     * @param templateId 模板id
     * @return AlarmTemplate
     */
    AlarmTemplate loadingAlarmTemplate(String templateId);
}
