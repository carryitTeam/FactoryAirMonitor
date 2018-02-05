/**
 *
 */
package com.carryit.base.fam.connection;

import java.io.Serializable;

/**
 * The Message of CS send data to mot device.
 *
 * @author 10028484
 * @version 0.0.1
 */
public class CSData2Dev extends Message implements Serializable {


    private String CMD = "SENDTO";
    private String AppEUI = Configure.DEFAULT_APPEUI;
    private int CmdSeq = Configure.DEFAULT_CMDSEQ;
    private String DevEUI = Configure.DEFAULT_DEVEUI;
    private boolean Confirm = true;
    private String payload = Configure.DEFAULT_PAYLOAD;
    private int Port = Configure.DEFAULT_MESSAGE_PORT;

    /**
     * Default constructor
     */
    public CSData2Dev() {
        // TODO Auto-generated constructor stub
    }

    public String getCMD() {
        return CMD;
    }

    public void setCMD(String cMD) {
        CMD = cMD;
    }

    public String getAppEUI() {
        return AppEUI;
    }

    public void setAppEUI(String appEUI) {
        AppEUI = appEUI;
    }

    public int getCmdSeq() {
        return CmdSeq;
    }

    public void setCmdSeq(int cmdSeq) {
        CmdSeq = cmdSeq;
    }

    public String getDevEUI() {
        return DevEUI;
    }

    public void setDevEUI(String deveEUI) {
        DevEUI = deveEUI;
    }

    public boolean isConfirm() {
        return Confirm;
    }

    public void setConfirm(boolean confirm) {
        Confirm = confirm;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public int getPort() {
        return Port;
    }

    public void setPort(int Port) {
        this.Port = Port;
    }

}
