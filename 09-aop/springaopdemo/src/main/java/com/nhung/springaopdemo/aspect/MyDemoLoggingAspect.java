package com.nhung.springaopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(public void com.nhung.springaopdemo.dao.*.add*(..))")
    private void forDAOAspect() {}

    @Pointcut("execution(public * com.nhung.springaopdemo.dao.*.get*(..))")
    private void forGetMethod() {}

    @Pointcut("execution(public void com.nhung.springaopdemo.dao.*.set*(..))")
    private void forSetMethod() {}

    @Before("forDAOAspect() && forSetMethod() && forSetMethod()")
    public void beforeAddAccount() {
        System.out.println("Executing before all methods");
    }

//    @Before("forGetMethod()")
//    public void beforeGetMethod() {
//        System.out.println("Executing before getter");
//    }
//
//    @Before("forSetMethod() || forSetMethod()")
//    public void beforeSetMethod() {
//        System.out.println("Executing before getter or setter");
//    }
}
