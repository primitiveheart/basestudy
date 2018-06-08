package com.javase.api;

import com.javase.dao.DeviceDao;
import com.javase.entity.Device;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by admin on 2018/6/4.
 */
@Path("device")
public class DeviceResource {
    private final DeviceDao deviceDao;

    public DeviceResource(DeviceDao deviceDao){
        this.deviceDao = deviceDao;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Device get(@QueryParam("ip") final String deviceIp){
        Device result = null;
        if(deviceIp != null){
            result = deviceDao.getDevice(deviceIp);
        }
        return result;
    }

}
