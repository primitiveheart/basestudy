package com.zgb.ws;

import org.apache.cxf.frontend.ServerFactoryBean;

/**
 * Created by admin on 2018/6/4.
 */
public class ServerPublishdemo2 {
    public String sayHello(String name){
        return name;
    }
    public static void main(String[] args){
        ServerFactoryBean serverFactoryBean = new ServerFactoryBean();
        serverFactoryBean.setAddress("http://localhost:8888/serverpublish");
        serverFactoryBean.setServiceClass(ServerPublishdemo2.class);
        serverFactoryBean.setServiceBean(new ServerPublishdemo2());
        serverFactoryBean.create();
        System.out.println("发布服务");

    }
}
