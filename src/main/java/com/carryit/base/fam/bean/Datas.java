package com.carryit.base.fam.bean;

/**
 * Created by hlzou on 2018/2/27.
 */
public class Datas {

    private int id;

    private String appEui;

    private String devEui;

    private String jsonData;

    private String realData;

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

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public String getRealData() {
        return realData;
    }

    public void setRealData(String realData) {
        this.realData = realData;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Datas{" +
                "id=" + id +
                ", appEui='" + appEui + '\'' +
                ", devEui='" + devEui + '\'' +
                ", jsonData='" + jsonData + '\'' +
                ", realData='" + realData + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
