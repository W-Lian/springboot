package com.example.springboot4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private TokenStore jwtTokenStore;

    @Autowired
    JwtAccessTokenConverter jwtAccessTokenConverter;

    @Bean
    public TokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey("dev");
        accessTokenConverter.setVerifierKey("dev");
        return accessTokenConverter;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenStore(jwtTokenStore);
    }

    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/loign")
                .permitAll();
    }

}
