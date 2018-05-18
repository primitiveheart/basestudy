package com.zgb.genericity;

/**
 * Created by admin on 2018/5/17.
 */
public class InteImpl implements Inte<String>{
    @Override
    public void show(String s) {
        System.out.println(s);
    }
}
