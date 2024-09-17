package com.nhung.springaopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(100)
public class MyDemoLoggingAspect {

    @Before("com.nhung.springaopdemo.aspect.MyPointcutExpression.forGetMethod()")
    public void beforeGetMethod() {
        System.out.println("Executing before getter");
    }

    @Before("com.nhung.springaopdemo.aspect.MyPointcutExpression.forSetMethod()")
    public void beforeSetMethod() {
        System.out.println("Executing before setter");
    }
//
//    @Before("forSetMethod() || forSetMethod()")
//    public void beforeSetMethod() {
//        System.out.println("Executing before getter or setter");
//    }
}
