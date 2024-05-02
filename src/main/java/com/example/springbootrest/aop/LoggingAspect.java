package com.example.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    //any method getting called we want to keep log(lets do it for console instead of file now)

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type, class name, method name, args
    // before is advice, in the bracket of before is pointcut
    //if we want to have info about targeted method we use JoinPoint in parameter of logmethod

    @Before("execution(* com.example.springbootrest.service.JobService.getJob(..)) || execution(* com.example.springbootrest.service.JobService.addJob(..)) ") // instead of getJob we can put *(..)
    public void logMethodCalled(JoinPoint jp) {

        LOGGER.info("Method called" + jp.getSignature().getName());
    }

    //@After means, it will run anyway after execution occurs or we got an exception
    @After("execution(* com.example.springbootrest.service.JobService.getJob(..)) || execution(* com.example.springbootrest.service.JobService.addJob(..)) ") // instead of getJob we can put *(..)
    public void logMethodExecuted(JoinPoint jp) {

        LOGGER.info("Method Executed" + jp.getSignature().getName());
    }

    //@AfterThrowing, (its kinda finally)this will be called only if there is an exception thrown
    @AfterThrowing("execution(* com.example.springbootrest.service.JobService.getJob(..)) || execution(* com.example.springbootrest.service.JobService.addJob(..)) ") // instead of getJob we can put *(..)
    public void logMethodCrash(JoinPoint jp) {

        LOGGER.info("Method has some issues" + jp.getSignature().getName());
    }

    //@AfterReturning will be executed when method returns something and no exceptions
    @AfterReturning("execution(* com.example.springbootrest.service.JobService.getJob(..)) || execution(* com.example.springbootrest.service.JobService.addJob(..)) ") // instead of getJob we can put *(..)
    public void logMethodExecutedSuccess(JoinPoint jp) {

        LOGGER.info("Method Executed Succesfully" + jp.getSignature().getName());
    }





}
