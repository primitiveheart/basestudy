package com.zgb.genericity;

/**
 * Created by admin on 2018/5/17.
 */
public class Demo {
    public static void main(String[] args){
        //泛型类
        ObjectTool<String> objectTool = new ObjectTool<>();
        objectTool.setObj(new String("是范德萨发"));
        System.out.println(objectTool.getObj());
        //泛型方法
        Demo2 demo2 = new Demo2();
        demo2.show("hello");
        //子类明确泛型类的类型参数变量
        InteImpl inte  = new InteImpl();
        inte.show("sfsfd");
        //当子类不明确泛型类的类型参数变量
        InteImpl2 inteImpl2 = new InteImpl2();
        inteImpl2.show("fdsfdsf");
    }
}
