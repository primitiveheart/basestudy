package com.zgb.ws;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by admin on 2018/6/4.
 */
@WebService
public class PublishDemo {
    public String sayHello(String name){
        return name;
    }

    public static void main(String[] args){
        String address = "http://localhost:8080/hello";
        Object implementor = new PublishDemo();
        Endpoint.publish(address, implementor);
    }
}
