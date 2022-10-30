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
@XmlRootElement(name = "com.bomweb.transaction.xml.FIGWebResSvc")
public class TxnInfoRsp {

	private String funcCode;
	private String pan;
	private String procCode;
	private String txnDateTime;
	private String rrn;
	private String terminalId;
	private String agentId;
	private String serviceChrg;
	private String txnMode;
	private String narration;
	private String txnHmac;
	private String gatewayRRN;
	private String track2Data;

	/**
	 * @return the funcCode
	 */
	public String getFuncCode() {
		return funcCode;
	}

	/**
	 * @param funcCode
	 *            the funcCode to set
	 */
	@XmlElement(name = "funcCode")
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}

	/**
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}

	/**
	 * @param pan
	 *            the pan to set
	 */
	@XmlElement(name = "pan")
	public void setPan(String pan) {
		this.pan = pan;
	}

	/**
	 * @return the procCode
	 */
	public String getProcCode() {
		return procCode;
	}

	/**
	 * @param procCode
	 *            the procCode to set
	 */
	@XmlElement(name = "procCode")
	public void setProcCode(String procCode) {
		this.procCode = procCode;
	}

	/**
	 * @return the txnDateTime
	 */
	public String getTxnDateTime() {
		return txnDateTime;
	}

	/**
	 * @param txnDateTime
	 *            the txnDateTime to set
	 */
	@XmlElement(name = "txnDateTime")
	public void setTxnDateTime(String txnDateTime) {
		this.txnDateTime = txnDateTime;
	}

	/**
	 * @return the track2Data
	 */
	public String getTrack2Data() {
		return track2Data;
	}

	/**
	 * @param track2Data
	 *            the track2Data to set
	 */
	@XmlElement(name = "track2Data")
	public void setTrack2Data(String track2Data) {
		this.track2Data = track2Data;
	}

	/**
	 * @return the rrn
	 */
	public String getRrn() {
		return rrn;
	}

	/**
	 * @param rrn
	 *            the rrn to set
	 */
	@XmlElement(name = "rrn")
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	/**
	 * @return the terminalId
	 */
	public String getTerminalId() {
		return terminalId;
	}

	/**
	 * @param terminalId
	 *            the terminalId to set
	 */
	@XmlElement(name = "terminalId")
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * @return the agentId
	 */
	public String getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId
	 *            the agentId to set
	 */
	@XmlElement(name = "agentId")
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the txnMode
	 */
	public String getTxnMode() {
		return txnMode;
	}

	/**
	 * @param txnMode
	 *            the txnMode to set
	 */
	@XmlElement(name = "txnMode")
	public void setTxnMode(String txnMode) {
		this.txnMode = txnMode;
	}

	/**
	 * @return the narration
	 */
	public String getNarration() {
		return narration;
	}

	/**
	 * @param narration
	 *            the narration to set
	 */
	@XmlElement(name = "narration")
	public void setNarration(String narration) {
		this.narration = narration;
	}

	/**
	 * @return the txnHmac
	 */
	public String getTxnHmac() {
		return txnHmac;
	}

	/**
	 * @param txnHmac
	 *            the txnHmac to set
	 */
	@XmlElement(name = "txnHmac")
	public void setTxnHmac(String txnHmac) {
		this.txnHmac = txnHmac;
	}

	/**
	 * @return the serviceChrg
	 */
	public String getServiceChrg() {
		return serviceChrg;
	}

	/**
	 * @param serviceChrg the serviceChrg to set
	 */
	@XmlElement(name = "serviceChrg")
	public void setServiceChrg(String serviceChrg) {
		this.serviceChrg = serviceChrg;
	}

	/**
	 * @return the gatewayRRN
	 */
	public String getGatewayRRN() {
		return gatewayRRN;
	}

	/**
	 * @param gatewayRRN the gatewayRRN to set
	 */
	@XmlElement(name = "gatewayRRN")
	public void setGatewayRRN(String gatewayRRN) {
		this.gatewayRRN = gatewayRRN;
	}
	
}
