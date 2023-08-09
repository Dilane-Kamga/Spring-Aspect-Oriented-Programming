package com.aop.springaopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class ExecutionTimeAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Around("execution(* com.aop.springaopdemo..*.*(..))")
    // check the execution time with our annotation
    @Around("execution(* com.aop.springaopdemo.aspect.JoinPointConfig.measureTimeAnnotation())")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        // start time
        long startTime = System.currentTimeMillis();

        // allow call method to execute
        Object returnValue = proceedingJoinPoint.proceed();

        // time taken = end time - start time
        long timeTaken = System.currentTimeMillis() - startTime;

        logger.info("Time taken by {} to complete the execution is: {}", proceedingJoinPoint, timeTaken);
        return returnValue;
    }
}
