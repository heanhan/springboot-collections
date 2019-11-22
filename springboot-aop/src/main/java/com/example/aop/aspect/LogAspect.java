package com.example.aop.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.example.aop.annotation.Log;
import com.example.aop.entity.pojo.SysLog;
import com.example.aop.utils.HttpContextUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {


	@Pointcut("@annotation(com.example.aop.annotation.Log)")
	public void pointcut() {
	}

	@Around("pointcut()")
	public void around(ProceedingJoinPoint point) {
		long beginTime = System.currentTimeMillis();
		try {
			// 执行方法
			point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// 执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;
		// 保存日志
		saveLog(point, time);
	}

	private void saveLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SysLog sysLog = new SysLog();
		Log logAnnotation = method.getAnnotation(Log.class);
		if (logAnnotation != null) {
			// 注解上的描述
			sysLog.setOperation(logAnnotation.value());
		}
		// 请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");
		// 请求的方法参数值
		Object[] args = joinPoint.getArgs();
		// 请求的方法参数名称
		LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
		String[] paramNames = u.getParameterNames(method);
		if (args != null && paramNames != null) {
			String params = "";
			for (int i = 0; i < args.length; i++) {
				params += "  " + paramNames[i] + ": " + args[i];
			}
			sysLog.setParams(params);
		}
		// 获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		// 设置IP地址
		// 模拟一个用户名
		sysLog.setUsername("zhaojh");
		sysLog.setTime((int) time);
		Date date = new Date();
		sysLog.setCreateTime(date);
		// 保存系统日志
		//此处写自己的保存方案
	}

	@AfterReturning(value = "pointcut()",returning="returnValue")
	public void ddd(JoinPoint point, Object returnValue){

		System.out.println("@AfterReturning：模拟日志记录功能...");
		System.out.println("@AfterReturning：目标方法为：" +
				point.getSignature().getDeclaringTypeName() +
				"." + point.getSignature().getName());
		System.out.println("@AfterReturning：参数为：" +
				Arrays.toString(point.getArgs()));
		System.out.println("@AfterReturning：返回值为：" + returnValue);
		System.out.println("@AfterReturning：被织入的目标对象为：" + point.getTarget());

	}

}
