package com.bosssoft.filter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 吴志鸿
 * @date 2020/7/26
 * @description
 */

public class ProcessInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
        httpServletResponse.setHeader("X-Powered-By", "Jetty");
        //重点！！！
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        String method = httpServletRequest.getMethod();
        if (method.equals("OPTIONS")) {
            httpServletResponse.setStatus(200);
            return false;
        }
        return true;
    }


}
