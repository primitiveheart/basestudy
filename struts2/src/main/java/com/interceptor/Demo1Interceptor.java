package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by admin on 2018/5/20.
 */
public class Demo1Interceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("Demo1Interceptor拦截之前");
        String value = actionInvocation.invoke();
        System.out.println("Demo1Interceptor拦截之后");

        return value;
    }
}
