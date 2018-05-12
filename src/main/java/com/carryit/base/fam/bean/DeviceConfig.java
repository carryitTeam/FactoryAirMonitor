package com.carryit.base.fam.bean;

/**
 * Created by hlzou on 2018/2/27.
 */
public class DeviceConfig {

    private int id;

    private String appEui;

    private String devEui;

    private String createTime;

    private String deviceType;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    private int groupId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppEui() {
        return appEui;
    }

    public void setAppEui(String appEui) {
        this.appEui = appEui;
    }

    public String getDevEui() {
        return devEui;
    }

    public void setDevEui(String devEui) {
        this.devEui = devEui;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DeviceConfig{" +
                "id=" + id +
                ", appEui='" + appEui + '\'' +
                ", devEui='" + devEui + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
