package com.ub.webtechnologies.aspects;

import com.ub.webtechnologies.model.Profile;
import com.ub.webtechnologies.model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfileServiceAspect {

    // around will always have a parameter of type ProceedingJoinPoint
    // ProceedingJoinPoint represents the intercepted method
    @Around("execution(* com.ub.webtechnologies.service.ProfileService.createProfile(..))")
    public Object around(ProceedingJoinPoint joinPoint) {
        System.out.println("I will return something else!");

        Profile.ProfileBuilder profileBuilder = new Profile.ProfileBuilder();

        return profileBuilder
                .user(new User.UserBuilder()
                        .name("OtherUser")
                        .build())
                .points(1233)
                .build();
    }


//    @Around("execution(* com.ub.webtechnologies.service.ProfileService.createProfile(..))")
//    public Object around(ProceedingJoinPoint joinPoint) {
//        System.out.println("I will return something else!");
//        Object result = null;
//        try {
//            result = joinPoint.proceed();
//            return result;
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        return result;
//    }
}
