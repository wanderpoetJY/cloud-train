package com.wander.eurekaserver.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 配置Eureka的csrf
 *
 * @author admin 2020/12/30/ 16:20
 */
@EnableWebSecurity
public class EurekaCRSFConfig extends WebSecurityConfigurerAdapter {


    //方案一：保留csrf，放行指定请求

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //保证Eureka的控制台和/actuator时做安全认证
        super.configure(http);

        //忽略/eureka/**的所有请求
        http.csrf().ignoringAntMatchers("/eureka/**");
    }


    //方案二：直接禁用csrf

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable().authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }

}