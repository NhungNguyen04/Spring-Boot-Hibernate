package com.nhung.springaopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAspect {

    @Before("com.nhung.springaopdemo.aspect.MyPointcutExpression.forCloudLog()")
    public void beforeCloudLog() {
        System.out.println("Before Cloud Log");
    }
}
