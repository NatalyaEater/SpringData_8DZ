package com.example.SpringData_5DZ.action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAR {
    @AfterReturning(pointcut = "@annotation(com.example.SpringData_5DZ.action.TrackUserAction)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        if (result == null) {
            System.out.println("Ошибка выполнения " + joinPoint.getSignature().getName());
        }

        System.out.println("Выполнен запрос " + joinPoint.getSignature().getName());
    }


}
