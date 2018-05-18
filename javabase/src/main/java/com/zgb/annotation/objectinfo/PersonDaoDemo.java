package com.zgb.annotation.objectinfo;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by admin on 2018/5/17.
 */
public class PersonDaoDemo {
    public static void main(String[] args)throws Exception{
        //第一步:得到类中想要注入的属性
        PropertyDescriptor descriptor = new PropertyDescriptor("person", PersonDao.class);
        //第二步:得到属性的对象
        Person person = (Person) descriptor.getPropertyType().newInstance();
        //第三步:得到属性对应的写的方法
        Method method = descriptor.getWriteMethod();
        //第四步:通过写的方法得到注解
        InjectPerson injectPerson = method.getAnnotation(InjectPerson.class);
        //第五步:获取注解的详细信息
        Method[] methods = injectPerson.getClass().getMethods();
        //第六步:将注解的信息注入到对象中
        for(Method m : methods){
            String name = m.getName();
            try{
                PropertyDescriptor descriptor1 = new PropertyDescriptor(name, Person.class);
                Method method1= descriptor1.getWriteMethod();
                Object o = m.invoke(injectPerson, null);
                method1.invoke(person, o);
            }catch (Exception e){
                continue;
            }
        }
        //第七步:调用属性写的方法，将已有数据的对象注入到方法中
        PersonDao personDao = new PersonDao();
        method.invoke(personDao, person);

        System.out.println(personDao.getPerson().getUsername());
        System.out.println(personDao.getPerson().getAge());
    }
}
