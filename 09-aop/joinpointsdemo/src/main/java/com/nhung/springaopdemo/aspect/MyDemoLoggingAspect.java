package com.nhung.springaopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(100)
public class MyDemoLoggingAspect {

    @Before("com.nhung.springaopdemo.aspect.MyPointcutExpression.forGetMethod()")
    public void beforeGetMethod(JoinPoint joinPoint) {

        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println("Executing before getter");
    }

    @Before("com.nhung.springaopdemo.aspect.MyPointcutExpression.forSetMethod()")
    public void beforeSetMethod(JoinPoint joinPoint) {

        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println("Executing before setter");
    }
//
//    @Before("forSetMethod() || forSetMethod()")
//    public void beforeSetMethod() {
//        System.out.println("Executing before getter or setter");
//    }
}
