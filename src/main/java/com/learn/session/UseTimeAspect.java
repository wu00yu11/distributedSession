package com.learn.session;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author
 * @describe:
 * @create 2018-03-28 17:19
 **/
@Component
@Aspect
public class UseTimeAspect {

    private static final Logger LOG = LoggerFactory.getLogger(UseTimeAspect.class);

    /**
     * 定义一个切入点.
     * 解释下：
     *
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * ~ 第二个 * 定义在web包或者子包
     * ~ 第三个 * 任意方法
     * ~ .. 匹配任意数量的参数.
     */
    @Pointcut("execution(* com.learn.session.service..*.*(..)) || execution(* com.learn.session.controller..*.*(..)) ")
    public void logPointcut(){}
    @Around("logPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            LOG.info(joinPoint.getSignature().getDeclaringTypeName()+"#" +joinPoint.getSignature().getName()+ "()\tUse time : " + (end - start) + " ms!");
            return result;

        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            LOG.error(joinPoint.getSignature().getDeclaringTypeName()+"#" +joinPoint.getSignature().getName()+ "()\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
            throw e;
        }

    }
}
