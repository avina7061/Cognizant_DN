package com.library.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

@Aspect
public class LoggingAspect {

    // Before advice
    @Before("execution(* com.library.service.*.*(..))")
    public void beforeMethod() {
        System.out.println("AOP BEFORE: Method execution started");
    }

    // After advice
    @After("execution(* com.library.service.*.*(..))")
    public void afterMethod() {
        System.out.println("AOP AFTER: Method execution finished");
    }
}