package com.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by admin on 2018/5/20.
 */
public class InterceptorAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        System.out.println("InterceptorAction执行了");
        return SUCCESS;
    }
}
