package com.zgb.annotation.baseinfo;

import java.lang.reflect.Method;

/**
 * Created by admin on 2018/5/17.
 */
public class Demo2 {
    //注解处理器
    //第一步:反射该类的方法
    //第二步:通过方法得到注解的具体信息
    //第三步:将注解上的信息注入到方法上
    public static void main(String[] args)throws Exception{
        Class clazz = Demo.class;
        Method method = clazz.getMethod("add", String.class, int.class);

        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
        String username = myAnnotation.username();
        int age = myAnnotation.age();

        Object o = clazz.newInstance();
        method.invoke(o, username, age);
    }
}
