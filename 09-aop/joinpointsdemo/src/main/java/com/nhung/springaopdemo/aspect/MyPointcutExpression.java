package com.nhung.springaopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyPointcutExpression {

    @Pointcut("execution(* com.nhung.springaopdemo.dao.*.findAccount())")
    public void afterFindAccounts() {}

}
