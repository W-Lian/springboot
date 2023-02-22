package com.example.springboot2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //BCryptPasswordEncoder是一个密码加密工具类，可以实现不可逆的加密
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //AuthenticationManager是为了实现OAuth2的Password模式必须要指定的授权管理Bean
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/client-authcode/login") .permitAll(); //注册放开;
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        //获取登录用户信息
//        return username -> {
//            log.info("username:"+ username);
//            if(!username.equals("admin")){
//                throw new UsernameNotFoundException("用户未发现");
//            }
//            //生产从数据库中获取
//            String role = "ROLE_ADMIN";
//            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority(role));
//            String password = passwordEncoder().encode("123456");
//            return new org.springframework.security.core.userdetails.User(username, password, authorities);
//        };
//    }
}
