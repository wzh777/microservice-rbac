package com.bosssoft.config;

import com.bosssoft.handle.AuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

/**
 * @author 吴志鸿
 * @date 2020/7/29
 * @description
 */
@Configuration

public class SecurityConfig {
//
//    @Autowired
//    AuthenticationSuccessHandler authenticationSuccessHandler;
//
//    @Autowired
//    AuthenticationFailureHandler authenticationFailureHandler;
//
//    @Autowired
//    CustomHttpBasicServerAuthenticationEntryPoint customHttpBasicServerAuthenticationEntryPoint;
//
//
//    //security的鉴权排除的url列表
//    private static final String[] excludedAuthPages = {
//            "/user/login",
//    };
//
//    @Bean
//    SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception {
//        http
//                .authorizeExchange()
//                .pathMatchers(excludedAuthPages).permitAll()  //无需进行权限过滤的请求路径
//                .pathMatchers(HttpMethod.OPTIONS).permitAll() //option 请求默认放行
//                .anyExchange().authenticated()
//                .and()
//                .httpBasic()
//                .and()
//                .formLogin().loginPage("/user/login")
//                .authenticationSuccessHandler(authenticationSuccessHandler) //认证成功
//                .authenticationFailureHandler(authenticationFaillHandler) //登陆验证失败
//                .and().exceptionHandling().authenticationEntryPoint(customHttpBasicServerAuthenticationEntryPoint)  //基于http的接口请求鉴权失败
//                .and() .csrf().disable()//必须支持跨域
//                .logout().disable();
//
//        return http.build();
//    }


}
