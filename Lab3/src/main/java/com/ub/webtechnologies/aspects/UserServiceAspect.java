package com.ub.webtechnologies.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAspect {

    // intercept the method createUser form UserService and do something before the execution
    // @Before annotation is the joint point that specifies that what I will define as a pointcut (group of methods for each this aspect applies)
    // will be executed before the execution of the methods that are matched by this pointcut
    @Before("execution(* com.ub.webtechnologies.service.UserService.createUser(..))")
    public void before() {
        System.out.println("Request to create users:");
    }

    @Before("execution(* com.ub.webtechnologies.service.UserService.createUser(..)) && args(name, ..)")
    public void before(String name) {
        System.out.println(String.format("Request to create user %s", name));
    }

    @After("execution(* com.ub.webtechnologies.service.UserService.createUser(..))")
    public void after() {
        System.out.println("Create users flow finished.");
    }

    // Executed only if the method doesn't throw an exception
    @AfterReturning("execution(* com.ub.webtechnologies.service.UserService.createUser(..))")
    public void afterReturning() {
        System.out.println("Create users flow finished successfully.");
    }

    // Executed only if the method throws an exception
    @AfterThrowing("execution(* com.ub.webtechnologies.service.UserService.createUser(..))")
    public void afterThrowing() {
        System.out.println("Create users flow finished but error was thrown.");
    }
}

