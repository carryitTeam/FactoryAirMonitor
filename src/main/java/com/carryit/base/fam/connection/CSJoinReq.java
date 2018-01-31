/**
 *
 */
package com.carryit.base.fam.connection;

import java.io.Serializable;

/**
 * The message of CS join request.
 *
 * @author 10028484
 * @version 0.0.1
 */
public class CSJoinReq extends Message implements Serializable {

    private String CMD = "JOIN";
    private int CmdSeq = Configure.DEFAULT_CMDSEQ;
    private String AppEUI = Configure.DEFAULT_APPEUI;
    private int AppNonce = Integer.parseInt(Configure.DEFAULT_NOPNCE);
    private String Challenge = null;

    /**
     * Default constructor
     */
    public CSJoinReq() {
        // TODO Auto-generated constructor stub
    }

    public String getCMD() {
        return CMD;
    }

    public void setCMD(String cMD) {
        CMD = cMD;
    }

    public int getCmdSeq() {
        return CmdSeq;
    }

    public void setCmdSeq(int cmdSeq) {
        CmdSeq = cmdSeq;
    }

    public String getAppEUI() {
        return AppEUI;
    }

    public void setAppEUI(String appEUI) {
        AppEUI = appEUI;
    }

    public int getAppNonce() {
        return AppNonce;
    }

    public void setAppNonce(int appNonce) {
        AppNonce = appNonce;
    }

    public String getChallenge() {
        return Challenge;
    }

    public void setChallenge(String challenge) {
        Challenge = challenge;
    }

}
