package com.example.jpa.aspect;

import com.alibaba.fastjson.JSONObject;
import com.example.jpa.annotation.LogRecord;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author : zhaojh
 * @date : 2019-07-27
 * @function :
 */

@Slf4j
@Aspect
@Component
public class SystemLogsAspect {

    /**
     * 切入点表达式
     *
     * 重点使用注解 @annotation
     */
    @Pointcut("@annotation(com.example.jpa.annotation.LogRecord)")
    public void logPointCut(){};


    /**
     *  环绕通知
     * @param proceedingJoinPoint  point
     * @return Object
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        Object object=null;
        try{
            //执行方法
            object = proceedingJoinPoint.proceed();
            //保存请求的日志
            saveRequestLog(proceedingJoinPoint);

        }catch (Exception e){

            // 保存异常日志
            saveExceptionLog(proceedingJoinPoint,e.getMessage());
            e.printStackTrace();
        }

        return object;
    }


    /**
     * 出现日常信息的报错调用该方法
     * @param point
     * @param exception
     */
    private void saveExceptionLog (ProceedingJoinPoint point,String exception){
        log.info("捕获异常:"+exception);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("请求的路径:"+request.getRequestURL());
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        log.info("请求方法:"+method.getName());
        // 获取方法上LogFilter注解
        LogRecord  logFilter = method.getAnnotation(LogRecord .class);
        String value = logFilter.value() ;
        log.info("模块描述:"+value);
        Object[] args = point.getArgs();
        log.info("请求参数:"+ JSONObject.toJSONString(args));
    }
    private void saveRequestLog (ProceedingJoinPoint point){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("请求路径:"+request.getRequestURL());
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        log.info("请求的方法:"+method.getName());
        // 获取方法上LogFilter注解
        LogRecord  logFilter = method.getAnnotation(LogRecord .class);
        String value = logFilter.value() ;
        log.info("模块描述:"+value);
        Object[] args = point.getArgs();
        log.info("请求参数:"+ JSONObject.toJSONString(args));
    }


}
