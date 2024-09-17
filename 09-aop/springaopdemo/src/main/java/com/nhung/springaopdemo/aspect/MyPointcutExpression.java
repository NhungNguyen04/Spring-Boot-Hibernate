package com.nhung.springaopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyPointcutExpression {

    @Pointcut("execution(public * com.nhung.springaopdemo.dao.*.get*(..))")
    public void forGetMethod() {}

    @Pointcut("execution(public void com.nhung.springaopdemo.dao.*.set*(..))")
    public void forSetMethod() {}

    @Pointcut("execution(public void com.nhung.springaopdemo.dao.*.sendToCloud())")
    public void forCloudLog() {}

    @Pointcut("execution(public void com.nhung.springaopdemo.dao.*.sendApi())")
    public void forApiAnalytics() {}


}
