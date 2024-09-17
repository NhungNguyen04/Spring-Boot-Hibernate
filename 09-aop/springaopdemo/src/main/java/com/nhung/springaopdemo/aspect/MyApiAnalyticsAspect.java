package com.nhung.springaopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-40)
public class MyApiAnalyticsAspect {

    @Before("com.nhung.springaopdemo.aspect.MyPointcutExpression.forApiAnalytics()")
    public void beforeApi() {
        System.out.println("Before api");
    }
}
