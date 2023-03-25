package com.example.springboot1.aop_warning;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlarmFactoryExecute {

    private static List<AlarmWarnService> serviceList = new ArrayList<>();

    public AlarmFactoryExecute(List<AlarmWarnService> alarmLogWarnServices) {
        serviceList = alarmLogWarnServices;
    }

    public static void addAlarmLogWarnService(AlarmWarnService alarmLogWarnService) {
        serviceList.add(alarmLogWarnService);
    }

    public static List<AlarmWarnService> getServiceList() {
        return serviceList;
    }

    public static void execute(NotifyMessage notifyMessage) {
        for (AlarmWarnService alarmWarnService : getServiceList()) {
            alarmWarnService.send(notifyMessage);
        }
    }
}
