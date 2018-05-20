package com.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;

/**
 * Created by admin on 2018/5/19.
 */
public class RegistAction extends ActionSupport {
    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void validate() {
        if(StringUtils.isBlank(username)){
            addFieldError("username", "用户名不能为空");
        }
    }

    public String regist(){
        System.out.println(username);
        return SUCCESS;
    }
}
