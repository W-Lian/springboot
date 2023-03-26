package com.example.blockdubbocommon.service;

import com.example.blockdubbocommon.module.UserEntity;

public interface DubboService {

    String getInfo(String param);

    UserEntity getUserInfo(UserEntity userEntity);

    String timeOut (Integer time) ;
}
