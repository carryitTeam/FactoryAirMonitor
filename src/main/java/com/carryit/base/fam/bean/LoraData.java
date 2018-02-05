package com.carryit.base.fam.bean;

/**
 * Created by hlzou on 2018/1/31.
 */
public class LoraData {

    private Integer dataLen;

    private String contentJson;

    private String careData;

    public String getCareData() {
        return careData;
    }

    public void setCareData(String careData) {
        this.careData = careData;
    }

    public Integer getDataLen() {
        return dataLen;
    }

    public void setDataLen(Integer dataLen) {
        this.dataLen = dataLen;
    }

    public String getContentJson() {
        return contentJson;
    }

    public void setContentJson(String contentJson) {
        this.contentJson = contentJson;
    }


    @Override
    public String toString() {
        return "LoraData{" +
                "dataLen=" + dataLen +
                ", contentJson='" + contentJson + '\'' +
                ", careData='" + careData + '\'' +
                '}';
    }
}
