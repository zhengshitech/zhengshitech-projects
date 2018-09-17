package com.z.tech.core.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author H
 */
//@WebFilter(filterName="MyFilter",urlPatterns = "/webapi/tenant/*")
//@WebFilter(filterName = "MyFilter", urlPatterns = "/tenant/*")
//public class MyFilter extends OncePerRequestFilter {
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        String testValue = filterConfig.getInitParameter("test");
        System.out.println("FilterConfig init param value:" + testValue);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        System.err.println("just tenant api urls!!! current:" + servletRequest.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        System.err.println("just tenant api urls!!! current:" + request.getRequestURI());
//        filterChain.doFilter(request,response);
//    }
}
