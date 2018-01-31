/**
 * 
 */
package com.carryit.base.fam.connection;

import java.io.Serializable;

/**
 * CS message of quit
 * @author 10028484
 * @version 0.0.1
 */
public class CSQuit extends Message implements Serializable {

	private String CMD="QUIT";
	private String AppEUI = Configure.DEFAULT_APPEUI;
	private int CmdSeq = Configure.DEFAULT_CMDSEQ;
	
	/**
	 * 
	 */
	public CSQuit() {
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

}
