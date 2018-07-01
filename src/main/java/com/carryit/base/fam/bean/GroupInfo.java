package com.carryit.base.fam.bean;

public class GroupInfo {

    private Integer id;
    private String groupName;
    private String groupLocation;
    private String groupComment;
    private String createTime;
    private String changeTime;
    private String contactUserName;
    private String contactTelephoneNumber;
    private String factoryDiagramPath;

    public String getFactoryDiagramPath() {
        return factoryDiagramPath;
    }

    public void setFactoryDiagramPath(String factoryDiagramPath) {
        this.factoryDiagramPath = factoryDiagramPath;
    }

    public String getContactTelephoneNumber() {
        return contactTelephoneNumber;
    }

    public void setContactTelephoneNumber(String contactTelephoneNumber) {
        this.contactTelephoneNumber = contactTelephoneNumber;
    }

    public String getContactUserName() {
        return contactUserName;
    }

    public void setContactUserName(String contactUserName) {
        this.contactUserName = contactUserName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupLocation() {
        return groupLocation;
    }

    public void setGroupLocation(String groupLocation) {
        this.groupLocation = groupLocation;
    }

    public String getGroupComment() {
        return groupComment;
    }

    public void setGroupComment(String groupComment) {
        this.groupComment = groupComment;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }
}
