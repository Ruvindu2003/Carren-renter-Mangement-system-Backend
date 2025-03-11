package org.example.configuration;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsefilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response1 =(HttpServletResponse) response;
        HttpServletRequest request1=(HttpServletRequest) request;
        Map<String,String>map=new HashMap<>();
        String originHeader= request1.getHeader("origin");
        response1.setHeader("Assess-control-Allow-origin",originHeader);
        response1.setHeader("Assess-control=Allow-Method","POST GET ,DELETE,PUT,OPTIONS");
        response1.setHeader("Assess-control-Allow-Headers","*");
        if ("OPTIONS".equalsIgnoreCase(request1.getMethod())){
            response1.setStatus(HttpServletResponse.SC_OK);
        }else{
            chain.doFilter(request, response);
        }


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
