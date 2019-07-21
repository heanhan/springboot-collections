package com.example.interceptor.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author : zhaojh
 * @date : 2019-07-21
 * @function :
 */

@Slf4j
public class UserFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter------->初始化 init......");
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        log.info("filter------->进行过滤 doFilter......");
        chain.doFilter(request,response);
    }

    public void destroy() {
        log.info("filter------->销毁 destory ......");
    }
}
