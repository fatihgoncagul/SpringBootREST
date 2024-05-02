package com.example.springbootrest.aop;


// in here we can change the entered value for example
//user enters -4 and we can change it to 4 thinking the client's intention
// or we can check whether its valid input or not


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {


    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);


    @Around("execution(* com.example.springbootrest.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {



        if (postId <0){
            LOGGER.info("Post ID is negative, updating it");
            postId = -postId;
            LOGGER.info("new value: "+postId);
        }
        // we also need to pass the updated value
        Object obj = jp.proceed(new Object[]{postId});


        return obj;

    }



}
