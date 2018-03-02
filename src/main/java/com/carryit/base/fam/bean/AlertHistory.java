package com.carryit.base.fam.bean;

/**
 * Created by hlzou on 2018/2/27.
 */
public class AlertHistory {

    private int id;

    private String userId;

    private String ruleId;

    private String appEui;

    private String devEui;

    private String isProcess;

    private String changeTime;

    private String createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
