package com.carryit.base.fam.bean;

/**
 * Created by hlzou on 2018/2/27.
 */
public class AlertRules {

    private int id;

    private String ruleId;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    private String appEui;

    private String devEui;

    private String ruleContent;

    private String changeTime;

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

    public String getRuleContent() {
        return ruleContent;
    }

    public void setRuleContent(String ruleContent) {
        this.ruleContent = ruleContent;
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
        return "AlertRules{" +
                "id=" + id +
                ", ruleId='" + ruleId + '\'' +
                ", appEui='" + appEui + '\'' +
                ", devEui='" + devEui + '\'' +
                ", ruleContent='" + ruleContent + '\'' +
                ", changeTime='" + changeTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
