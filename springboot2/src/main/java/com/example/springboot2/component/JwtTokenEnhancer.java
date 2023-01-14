package com.example.springboot2.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken var1, OAuth2Authentication var2){
        Map<String, Object> info = new HashMap<>();
        info.put("jwt-ext", "jwt扩展信息");
        ((DefaultOAuth2AccessToken)var1).setAdditionalInformation(info);
        return var1;
    }

}
