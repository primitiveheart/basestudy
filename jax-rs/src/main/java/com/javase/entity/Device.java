package com.javase.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by admin on 2018/6/4.
 */
@XmlRootElement
public class Device implements Serializable {
    private String deviceIp;
    private int deviceStatus;

    public Device(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public Device() {
    }

    @XmlAttribute
    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    @XmlAttribute
    public int getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(int deviceStatus) {
        this.deviceStatus = deviceStatus;
    }
}
