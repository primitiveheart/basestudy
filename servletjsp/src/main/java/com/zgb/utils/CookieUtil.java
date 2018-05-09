package com.zgb.utils;

import javax.servlet.http.Cookie;

/**
 * Created by admin on 2018/5/9.
 */
public class CookieUtil {
    public static Cookie getCookieByName(Cookie[] cookies, String cookieName) {
        if(cookies == null){
            return null;
        }else{
            for(Cookie c : cookies){
                if(c.getName().equals(cookieName)){
                    return c;
                }
            }
        }

        return null;
    }
}
