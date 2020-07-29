package com.bosssoft.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Base64;

/**
 * @author 吴志鸿
 * @date 2020/7/29
 * @description
 */

public class AuthenticationSuccessHandler  {
//
//    @Override
//    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication){
//        ServerWebExchange exchange = webFilterExchange.getExchange();
//        ServerHttpResponse response = exchange.getResponse();
//        //设置headers
//        HttpHeaders httpHeaders = response.getHeaders();
//        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
//        httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
//        //设置body
//        byte[]   dataBytes={};
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            User user=(User)authentication.getPrincipal();
//            AuthUserDetails userDetails=buildUser(user);
//            byte[] authorization=(userDetails.getUsername()+":"+userDetails.getPassword()).getBytes();
//            String token= Base64.getEncoder().encodeToString(authorization);
//            httpHeaders.add(HttpHeaders.AUTHORIZATION, token);
//            wsResponse.setResult(userDetails);
//            dataBytes=mapper.writeValueAsBytes(wsResponse);
//        }
//        catch (Exception ex){
//            ex.printStackTrace();
//            JsonObject result = new JsonObject();
//            result.addProperty("status", MessageCode.COMMON_FAILURE.getCode());
//            result.addProperty("message", "授权异常");
//            dataBytes=result.toString().getBytes();
//        }
//        DataBuffer bodyDataBuffer = response.bufferFactory().wrap(dataBytes);
//        return response.writeWith(Mono.just(bodyDataBuffer));
//    }
}
