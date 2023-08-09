package com.aop.springaopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class JoinPointConfig {

    @Pointcut("execution(* com.aop.springaopdemo.repository.*.*(..))")
    public void repositoryLayerPointcut() {}

    @Pointcut("execution(* com.aop.springaopdemo.service.*.*(..))")
    public void serviceLayerPointcut() {}

    //to intercept method calls for both layers:
    @Pointcut("com.aop.springaopdemo.aspect.JoinPointConfig.repositoryLayerPointcut() || "
            + "com.aop.springaopdemo.aspect.JoinPointConfig.repositoryLayerPointcut()")
    public void allLayersPointcut() {}

    //for a particular bean
    @Pointcut("bean(book*)")
    public void bookBeanPointcut() {}

    //custom aspect annotation
    @Pointcut("@annotation(com.aop.springaopdemo.aspect.MeasureTime)")
    public void measureTimeAnnotation() {}
}
