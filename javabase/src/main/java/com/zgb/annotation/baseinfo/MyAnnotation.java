package com.zgb.annotation.baseinfo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by admin on 2018/5/17.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String username();
    int age();
}
