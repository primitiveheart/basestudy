package com.javase.dao;

import com.javase.entity.Device;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by admin on 2018/6/4.
 */
public class DeviceDao {
    private ConcurrentMap<String, Device> fakeDB = new ConcurrentHashMap<>();
    public DeviceDao() {
        fakeDB.put("10.11.58.163", new Device("10.11.58.163"));
        fakeDB.put("10.11.58.185", new Device("10.11.58.185"));
    }

    public Device getDevice(String deviceIp) {
        return fakeDB.get(deviceIp);
    }

    public Device updateDevice(Device device) {
        String ip = device.getDeviceIp();
        if (ip != null && fakeDB.containsKey(ip)) {
            fakeDB.put(ip, device);
        }
        return fakeDB.get(ip);
    }
}
