package com.javase.api;

import com.javase.Main;
import com.javase.entity.Device;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/6/4.
 */
public class DeviceResourceTest {
    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp(){
        server = Main.startServer();
        Client client = ClientBuilder.newClient();
        target = client.target(Main.BASE_URI);
    }

    @After
    public void tearDown(){
        server.shutdownNow();
    }

    @Test
    public void testGetDevice(){
        final String testIp = "10.11.58.185";
        final Device device = target.path("device").queryParam("ip", testIp).request().get(Device.class);
        assertEquals(testIp, device.getDeviceIp());
    }
}