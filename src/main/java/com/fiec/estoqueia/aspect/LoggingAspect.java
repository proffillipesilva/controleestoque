package com.fiec.estoqueia.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    // Define a Pointcut to specify which methods to intercept
    //@Pointcut("execution(*com.fiec.estoqueia.*.*(..))")
    @Pointcut("@annotation(com.fiec.estoqueia.aspect.ServiceMethod)")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        log.info("Entering method: {} in class: {}",
                joinPoint.getSignature().getName(),
                joinPoint.getTarget().getClass().getSimpleName());
        Object[] args = joinPoint.getArgs();

        if (args.length > 0) {
            log.debug("Arguments: {}", args);
        }
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfterServiceMethod(JoinPoint joinPoint, Object result) {
        log.info("Exiting method: {} in class: {} with result: {}",
                joinPoint.getSignature().getName(),
                joinPoint.getTarget().getClass().getSimpleName(),
                result);
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "e")
    public void logExceptionInServiceMethod(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in method: {} in class: {} - {}",
                joinPoint.getSignature().getName(),
                joinPoint.getTarget().getClass().getSimpleName(),
                e.getMessage(), e);
    }
}