package com.zgb;

import com.zgb.resource.UserJsonResource;
import com.zgb.service.HelloService;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by admin on 2018/6/3.
 */
@ApplicationPath("/")
public class APIApplication extends ResourceConfig{
    public APIApplication(){
        register(UserJsonResource.class);
        register(JacksonJsonProvider.class);

    }
}
