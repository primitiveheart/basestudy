package com.javase;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Created by admin on 2018/6/4.
 */
public class Main {
    public static final String BASE_URI = "http://localhost:8080/jax/";

    public static HttpServer startServer(){
        //配置扫描包
        final ResourceConfig rc = new ResourceConfig().packages("com.javase.api");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args)throws IOException{
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        System.out.println("finish");
        server.shutdownNow();
    }
}
