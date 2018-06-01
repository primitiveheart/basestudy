package com.aop.demo3;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * Created by admin on 2018/5/24.
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        System.out.println("前置通知");
    }
}
