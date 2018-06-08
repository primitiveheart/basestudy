package com.zgb.ws;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import javax.jws.WebService;

/**
 * Created by admin on 2018/6/4.
 */
@WebService
public class JaxWsPublishDemo3 {

    public String sayHello(String name){
        return name;
    }

    public static void main(String[] args){
        JaxWsServerFactoryBean jaxWsServerFactoryBean = new JaxWsServerFactoryBean();
        jaxWsServerFactoryBean.setAddress("http://localhost:8888/hello");
        jaxWsServerFactoryBean.setServiceClass(JaxWsPublishDemo3.class);
        jaxWsServerFactoryBean.setServiceBean(new JaxWsPublishDemo3());
        jaxWsServerFactoryBean.create();
        System.out.println("发布服务");
    }
}
