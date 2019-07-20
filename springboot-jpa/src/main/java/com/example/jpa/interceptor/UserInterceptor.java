package com.example.jpa.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : zhaojh
 * @date : 2019-07-13
 * @function : 拦截器的使用
 *                  拦截器概念：在AOP（Aspect-Oriented Programming）中用于在某个方法或字段被访问之前，进行拦截，然后在之前或之后加上某些操作。拦截是AOP的一种实现策略。
 *                  作用：
 *                      1、日志记录：记录请求信息的日志，以便进行信息监控、信息统计、计算PV...
 *                      2、权限检查：认证或者授权等检查
 *                      3、性能监控：通过拦截器在进入处理器之前记录开始时间，处理完成后记录结束时间，得到请求处理时间。
 *                      4、通用行为：读取cookie得到用户信息并将用户对象放入请求头中，从而方便后续流程使用。
 *
 *                   实现： 实现接口 HandleInterceptor,重写里面的三个方法  preHandle、postHandle、afterCompletion
 *                      1、preHandler
 *                          方法将在请求处理之前进行调用。SpringMVC中的Interceptor同Filter一样都是链式调用。每个Interceptor的调用会依据它的声明顺序依次执行，
 *                       而且最先执行的都是Interceptor中的preHandle方法，
 *                       所以可以在这个方法中进行一些前置初始化操作或者是对当前请求的一个预处理，也可以在这个方法中进行一些判断来决定请求是否要继续进行下去。
 *                       该方法的返回值是布尔值Boolean 类型的，当它返回为false时，表示请求结束，后续的Interceptor和Controller都不会再执行；
 *                       当返回值为true时就会继续调用下一个Interceptor 的preHandle 方法，如果已经是最后一个Interceptor 的时候就会是调用当前请求的Controller 方法。
 *
 *                      2、postHandler
 *                          在当前请求进行处理之后，也就是Controller 方法调用之后执行，但是它会在DispatcherServlet 进行视图返回渲染之前被调用，
 *                       所以我们可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
 *
 *                      3、afterCompletion
 *                          该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。顾名思义，
 *                      该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。这个方法的主要作用是用于进行资源清理工作的。
 *
 */

@Component
@Slf4j
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
            log.info("在请求处理调用controller方法调用前执行.....");
            log.info("请求的方法 :"+request.getMethod()+"、请求的路径 ："+request.getContextPath()+"、请求的地址 ："+request.getRemoteAddr()+"、打印handel :"+handler.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {
        log.info("在请求资源处理之后，但是在视图被渲染之前，即在controller方法调用之后......");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
        log.info("在当前这个请求资源结束之后，也就是在DispatchServlet被渲染了对应的视图之后执行，主要用于资源清理工作......");
    }
}
