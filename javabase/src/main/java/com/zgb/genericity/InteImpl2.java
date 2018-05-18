package com.zgb.genericity;

/**
 * Created by admin on 2018/5/17.
 */
public class InteImpl2<T> implements Inte<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
