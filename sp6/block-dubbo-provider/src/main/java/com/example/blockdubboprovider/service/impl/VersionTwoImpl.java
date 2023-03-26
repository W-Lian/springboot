package com.example.blockdubboprovider.service.impl;

import com.example.blockdubbocommon.service.VersionService;

public class VersionTwoImpl implements VersionService {
    @Override
    public String getVersion() {
        return "{当前版本：2.0.0}";
    }
}
