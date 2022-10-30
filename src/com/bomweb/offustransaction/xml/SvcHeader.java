/**
 * 
 */
package com.bomweb.offustransaction.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.transaction.FIGWebReqSvc")
public class SvcHeader {

	private String txnId;
	private String tspVdrId;
	private String txnOrigin;
	private String msgFmtVer;
	private String appVersion;
	private String tspAuth;

	@XmlElement(name = "txnId")
	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	@XmlElement(name = "tspVdrId")
	public String getTspVdrId() {
		return tspVdrId;
	}

	public void setTspVdrId(String tspVdrId) {
		this.tspVdrId = tspVdrId;
	}

	/**
	 * @return the txnOrigin
	 */
	@XmlElement(name = "txnOrigin")
	public String getTxnOrigin() {
		return txnOrigin;
	}

	/**
	 * @param txnOrigin the txnOrigin to set
	 */
	public void setTxnOrigin(String txnOrigin) {
		this.txnOrigin = txnOrigin;
	}

	/**
	 * @return the msgFmtVer
	 */
	@XmlElement(name = "msgFmtVer")
	public String getMsgFmtVer() {
		return msgFmtVer;
	}

	/**
	 * @param msgFmtVer the msgFmtVer to set
	 */
	public void setMsgFmtVer(String msgFmtVer) {
		this.msgFmtVer = msgFmtVer;
	}

	/**
	 * @return the appVersion
	 */
	@XmlElement(name = "appVersion")
	public String getAppVersion() {
		return appVersion;
	}

	/**
	 * @param appVersion the appVersion to set
	 */
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	/**
	 * @return the tspAuth
	 */
	@XmlElement(name = "tspAuth")
	public String getTspAuth() {
		return tspAuth;
	}

	/**
	 * @param tspAuth the tspAuth to set
	 */
	public void setTspAuth(String tspAuth) {
		this.tspAuth = tspAuth;
	}

}
