package com.zgb.annotation.objectinfo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by admin on 2018/5/17.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectPerson {
    String username();
    int age();
}
