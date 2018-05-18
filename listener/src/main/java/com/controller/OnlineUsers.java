package com.controller;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/5/18.
 */
public class OnlineUsers {
    public static Map<String, HttpSession> online = new HashMap<>();

    public static Map<String, HttpSession> getOnline(){
        return online;
    }
}
