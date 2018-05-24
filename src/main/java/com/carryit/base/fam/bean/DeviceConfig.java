package com.carryit.base.fam.bean;

/**
 * Created by hlzou on 2018/2/27.
 */
public class DeviceConfig {

    private Integer id;

    private String appEui;

    private String devEui;

    private String createTime;

    private String deviceType;

    private String deviceName;

    private String deviceComment;

    private Integer parentId;

    private String devicePort;

    private String deviceLevel;

    public String getDeviceLevel() {
        return deviceLevel;
    }

    public void setDeviceLevel(String deviceLevel) {
        this.deviceLevel = deviceLevel;
    }

    public String getDevicePort() {
        return devicePort;
    }

    public void setDevicePort(String devicePort) {
        this.devicePort = devicePort;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceComment() {
        return deviceComment;
    }

    public void setDeviceComment(String deviceComment) {
        this.deviceComment = deviceComment;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    private Integer groupId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
