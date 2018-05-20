package com.results;

import com.opensymphony.xwork2.ActionInvocation;
import org.apache.struts2.dispatcher.StrutsResultSupport;

/**
 * Created by admin on 2018/5/19.
 */
public class CaptchaResult extends StrutsResultSupport{
    private int width = 120;
    private int height = 20;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    protected void doExecute(String s, ActionInvocation actionInvocation) throws Exception {
        //生成验证
    }
}
