package com.aop.springaopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(value = "execution(* com.aop.springaopdemo.service.*.*(..))",
                     returning = "result")
    public void logAfterExecution(JoinPoint joinPoint, Object result){
        logger.info("{} returned with: {}", joinPoint, result);
    }

    @AfterThrowing(value = "execution(* com.aop.springaopdemo.service.*.*(..))",
                   throwing = "exception")
    public void logAfterException(JoinPoint joinPoint, Object exception){
        logger.info("Exception in {} returned with: {}", joinPoint, exception);
    }

    @After(value = "execution(* com.aop.springaopdemo.service.*.*(..))")
    public void logAfterMethod(JoinPoint joinPoint){
        logger.info("After {} ", joinPoint);
    }
}
