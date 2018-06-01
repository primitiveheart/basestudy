package com.aop.demo6;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by admin on 2018/5/24.
 */
@Aspect
public class MyAspect {
    @Before("execution(* com.aop.demo5.*(..))")
    public void before(){
        System.out.println("前置增强");
    }
}
