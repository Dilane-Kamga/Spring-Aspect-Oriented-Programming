package com.aop.springaopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;

@Aspect
@Configuration
public class AccessCheckAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // check user access
    @Before("execution(* com.aop.springaopdemo.service.*.*(..))")
    private void userAccess(JoinPoint jointPoint){
        logger.info("Intercepted Call before execution of : {}", jointPoint);
    }
}
