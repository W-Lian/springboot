package com.example.blockdubboconsume.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.blockdubbocommon.service.VersionService;

public class VersionServiceImpl implements VersionService {
    @Reference(version = "1.0.0")
    private VersionService versionService1 ;

    @Reference(version = "2.0.0")
    private VersionService versionService2 ;
    
    @Override
    public String getVersion() {
        return versionService1.getVersion();
    }

    public String version2 (){
        return versionService2.getVersion() ;
    }
}
