/**
 * 
 */
package com.bomweb.transaction.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.transaction.xml.FIGWebReqSvc")
public class SvcHeaderRsp {

	private String txnId;
	private String tspVdrId;
	private String respCode;
	private String respDesc;
	private String msgFmtVer;
	private String appVersion;

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
	 * @return the respCode
	 */
	public String getRespCode() {
		return respCode;
	}

	/**
	 * @param respCode the respCode to set
	 */
	@XmlElement(name = "respCode")
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	/**
	 * @return the respDesc
	 */
	public String getRespDesc() {
		return respDesc;
	}

	/**
	 * @param respDesc the respDesc to set
	 */
	@XmlElement(name = "respDesc")
	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

}
