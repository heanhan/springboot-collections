package com.example.crossorigin.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : zhaojh
 * @date : 2019-07-18
 * @function :  如果使用此类进行解决跨域问题，请务必关掉  config 下CorssOriginConfig的使用
 */
@Component

public class CorssOriginFilter  implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        /**
         * 实现步骤：
         *  1.将ServletResponse 转换成 HttpServletResponses对象，
         *  2.通过HttpServletResponse 添加访问头信息
         */
        HttpServletResponse resp=(HttpServletResponse)response;
        resp.addHeader("Access-Control-Allow-Credentials", "true");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type,X-CAF-Authorization-Token,sessionToken,X-TOKEN");
        if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
            //判断请求方法  是否为 OPTIONS 如果是进行拦截，拒绝放问
            return;
        }
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        System.out.println();
    }
}
