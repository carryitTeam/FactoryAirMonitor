package com.carryit.base.fam.bean;

/**
 * Created by hlzou on 2018/2/27.
 */
public class LogOps {

    private int id;

    private String userId;

    private String logContent;

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

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LogOps{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", logContent='" + logContent + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
