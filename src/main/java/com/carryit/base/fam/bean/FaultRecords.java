package com.carryit.base.fam.bean;

/**
 * Created by hlzou on 2018/2/27.
 */
public class FaultRecords {

    private int id;

    private String appEui;

    private String devEui;

    private String faultContent;

    private String createTime;

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

    public String getFaultContent() {
        return faultContent;
    }

    public void setFaultContent(String faultContent) {
        this.faultContent = faultContent;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FaultRecords{" +
                "id=" + id +
                ", appEui='" + appEui + '\'' +
                ", devEui='" + devEui + '\'' +
                ", faultContent='" + faultContent + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
