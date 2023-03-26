package com.example.blockdubboprovider.service.impl;

import com.example.blockdubbocommon.service.VersionService;

public class VersionOneImpl implements VersionService {
    @Override
    public String getVersion() {
        return "{当前版本：1.0.0}";
    }
}
