package com.carryit.base.fam.bean;
//联动表实体类
public class Alarm {
    private int id;

    private String devEui;

    //一级报警/二级报警
    private String level;

    private String devEuiRelate;

    private String relateNames;

    private String status;

    private String changeTime;

    private String createTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevEui() {
        return devEui;
    }

    public void setDevEui(String devEui) {
        this.devEui = devEui;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDevEuiRelate() {
        return devEuiRelate;
    }

    public void setDevEuiRelate(String devEuiRelate) {
        this.devEuiRelate = devEuiRelate;
    }

    public String getRelateNames() {
        return relateNames;
    }

    public void setRelateNames(String relateNames) {
        this.relateNames = relateNames;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
