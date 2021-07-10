package com.cloud.Aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志切面
 * @author Administrator
 */
@Component
@Aspect
public class LogAspect {

    /**
     * 定义该包下面所有类以及所有方法为切入点
     */
    @Pointcut("execution(public * com.cloud.controller..*.*(..))")
    public void webLog(){};


    /**
     * 在切点之前执行方法
     */
    @Before("webLog()")
    public void before(JoinPoint joinPoint)throws Throwable{
        System.out.println("在切点之前执行的方法-----");
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes != null;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        System.out.println("请求的路径-----"+request.getRequestURI());
        System.out.println("执行的方法-----"+request.getMethod());
        System.out.println("请求的参数-----"+ JSON.toJSONString(joinPoint.getArgs()));
    }

    /**
     *在切点之后执行方法
     */
    @After("webLog()")
    public void after(JoinPoint joinPoint) throws Throwable{
        System.out.println("在切点之后执行的方法----");
    }

//    /**
//     * 在切点执行之前与之后执行方法
//     */
//    @Around("webLog()")
//    public void around(JoinPoint joinPoint) throws Throwable{
//        System.out.println("在切点around执行的方法----");
//    }
}
