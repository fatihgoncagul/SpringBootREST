package com.example.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {


    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);
    //@Around used for performance monitoring

    @Around("execution(* com.example.springbootrest.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp ) throws Throwable {


        // ProceedingJoinPoint needs to be implemented so that we can call the method using around
        // !!! we also need to return type Object so that the called method returns something or finish its job
        long start = System.currentTimeMillis();

        Object obj = jp.proceed();

        long end = System.currentTimeMillis();

        LOGGER.info("Time taken : "+jp.getSignature().getName() +" : "+ (end-start) + " ms");
        return obj;

    }


}
