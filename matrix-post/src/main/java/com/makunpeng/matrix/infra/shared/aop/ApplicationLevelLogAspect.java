package com.makunpeng.matrix.infra.shared.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 请求日志切面 <br>
 * 切面顺序为 Ordered.LOWEST_PRECEDENCE - 1，目的是为保证该切面执行顺序在 @Cacheable 注解之前，
 * 因为 @Cacheable 的默认 order 属性也是 Ordered.LOWEST_PRECEDENCE
 *
 * @author Aaron Ma
 * @since 1.0
 */
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE - 1)
@Component
public class ApplicationLevelLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationLevelLogAspect.class);

    @Pointcut("execution(* com.makunpeng.matrix.application..*.*(..))")
    private void pointCut() {

    };

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long elapsed = System.currentTimeMillis() - start;
        logger.info("切面生效");
        return result;
    }
}
