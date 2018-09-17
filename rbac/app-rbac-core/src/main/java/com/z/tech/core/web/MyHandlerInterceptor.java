package com.z.tech.core.web;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author H
 */

public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.err.println("已经进入 MyHandlerInterceptor 拦截器");
        String requestURI = request.getRequestURI();
        String requestURL = request.getRequestURL().toString();
        System.out.println("requestURI:" + requestURI);
        System.out.println("requestURL:" + requestURL);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.err.println("已经进入 MyHandlerInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.err.println("已经进入 MyHandlerInterceptor afterCompletion");
    }
}
