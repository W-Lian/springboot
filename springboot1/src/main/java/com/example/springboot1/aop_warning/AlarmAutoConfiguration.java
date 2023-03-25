package com.example.springboot1.aop_warning;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
public class AlarmAutoConfiguration {

    @Autowired
    private List<AlarmWarnService> alarmWarnServiceList;
    
    // 邮件相关配置装载
//    @Configuration
//    @ConditionalOnProperty(prefix = MailConfig.PREFIX, name = "enabled", havingValue = "true")
//    @EnableConfigurationProperties(MailConfig.class)
//    static class MailWarnServiceMethod {
//
//        @Bean
//        @ConditionalOnMissingBean(MailWarnService.class)
//        public MailWarnService mailWarnService(final MailConfig mailConfig) {
//            MailWarnService mailWarnService = new MailWarnService(mailConfig.getSmtpHost(), mailConfig.getSmtpPort(), mailConfig.getTo(), mailConfig.getFrom(), mailConfig.getUsername(), mailConfig.getPassword());
//            mailWarnService.setSsl(mailConfig.getSsl());
//            mailWarnService.setDebug(mailConfig.getDebug());
//            AlarmFactoryExecute.addAlarmLogWarnService(mailWarnService);
//            return mailWarnService;
//        }
//    }

    // 消息模板配置装载
    @Configuration
//    @ConditionalOnProperty(prefix = TemplateConfig.PREFIX, name = "enabled", havingValue = "true")
    @ConditionalOnProperty(prefix = "spring.alarm.template", name = "enabled", havingValue = "true")
    @EnableConfigurationProperties(TemplateConfig.class)
    static class TemplateConfigServiceMethod {

        @Bean
        @ConditionalOnMissingBean
        public AlarmTemplateProvider alarmTemplateProvider(TemplateConfig templateConfig) {
            if (TemplateSource.FILE == templateConfig.getSource()) {
                return new YamlAlarmTemplateProvider(templateConfig);
            } else if (TemplateSource.JDBC == templateConfig.getSource()) {
                // 数据库（如mysql）读取文件，未实现，可自行扩展
//                return new JdbcAlarmTemplateProvider(templateId -> null);
            } else if (TemplateSource.MEMORY == templateConfig.getSource()) {
                // 内存（如redis，本地内存）读取文件，未实现，可自行扩展
//                return new MemoryAlarmTemplateProvider(templateId -> null);
            }
            return new YamlAlarmTemplateProvider(templateConfig);
        }


    }

    @Bean
    public AlarmAspect alarmAspect(@Autowired(required = false) AlarmTemplateProvider alarmTemplateProvider) {
        return new AlarmAspect(alarmTemplateProvider);
    }

    @Bean
    public AlarmFactoryExecute initAlarmFactory() {
        return new AlarmFactoryExecute(alarmWarnServiceList);
    }
}
