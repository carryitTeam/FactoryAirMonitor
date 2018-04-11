package com.carryit.base.fam.bean;

/**
 * Created by hlzou on 2018/2/27.
 */
public class AlertHistory {

    private int id;

    private String historyId;

    private String jsonData;

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    private String userId;

    private String ruleId;

    private String appEui;

    private String devEui;

    private String isProcess;

    private String changeTime;

    private String createTime;
    //40006  故障码
    private String faultContect;

    public String getFaultContect() {
        return faultContect;
    }

    public void setFaultContect(String faultContect) {
        this.faultContect = faultContect;
    }

    //40003和40004+40007 气体浓度值
    private String gasConcentration;

    public String getGasConcentration() {
        return gasConcentration;
    }

    public void setGasConcentration(String gasConcentration) {
        this.gasConcentration = gasConcentration;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
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

    public String getIsProcess() {
        return isProcess;
    }

    public void setIsProcess(String isProcess) {
        this.isProcess = isProcess;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AlertHistory{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", ruleId='" + ruleId + '\'' +
                ", appEui='" + appEui + '\'' +
                ", devEui='" + devEui + '\'' +
                ", isProcess='" + isProcess + '\'' +
                ", changeTime='" + changeTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
