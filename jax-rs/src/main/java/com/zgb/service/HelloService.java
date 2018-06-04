package com.zgb.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by admin on 2018/6/3.
 */
@Path("/hello")
public class HelloService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "hello jersey";
    }
}
