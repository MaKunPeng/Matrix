package com.dust.dms.user.infrastructure.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 测试Spring切面功能
 */
@Aspect
@Component
@Order(1)
public class TestAspect {

    @Pointcut("execution(public * com.dust.dms.user.interfaces.facade.*.*(..))")
    public void restAccess() {}

    @Before("restAccess()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature() + ": Before...");
    }

    @AfterReturning(value = "restAccess()", returning = "ret")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
        System.out.println(joinPoint.getSignature() + ": After...");
    }
}
