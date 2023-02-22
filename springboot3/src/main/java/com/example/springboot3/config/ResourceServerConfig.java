package com.example.springboot3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private RemoteTokenServices remoteTokenServices;
//    @Autowired
//    private RemoteTokenServices tokenServices;

    @Value("${security.oauth2.client.cid}")
    private String clientId;
    @Value("${security.oauth2.client.csecret}")
    private String secret;
    @Value("${security.oauth2.authorization.check-token-access}")
    private String checkTokenEndpointUrl;


    @Bean
    public TokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey("dev");
        accessTokenConverter.setVerifierKey("dev");
        return accessTokenConverter;
    }

    @Bean
    public RemoteTokenServices tokenServices(){
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId(clientId);
        tokenServices.setClientSecret(secret);
        tokenServices.setCheckTokenEndpointUrl(checkTokenEndpointUrl);
//        tokenServices.setClientId("user-client");
//        tokenServices.setClientSecret("user-secret-8888");
//        tokenServices.setCheckTokenEndpointUrl("http://localhost:6001/oauth/check_token");
        return tokenServices;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        //redis存储方式
//        resources.tokenServices(tokenServices());

        //jwt存储方式
        resources.tokenStore(jwtTokenStore());
    }
}
