/**
 * 
 */
package com.bomweb.bbps.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.bbps.BBPSPayResponse")
public class PayTxnInfo {

	private String acqId;
	private String agentId;
	private String appVersion;
	private String bankCode;
	private String billerId;
	private String caId;
	private String ca_ta;
	private String channelId;
	private String channelName;
	private String ip;
	private String mac;
	private String msgId;
	private String posCode;
	private String posEntryMode;
	private String procCode;
	private String refId;
	private String rrn;
	private String terminalData;
	private String terminalId;
	private String ts;
	private String txnDateTime;

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
	@XmlElement(name="procCode")
	public void setProcCode(String procCode) {
		this.procCode = procCode;
	}

	/**
	 * @return the appVersion
	 */
	public String getAppVersion() {
		return appVersion;
	}

	/**
	 * @param appVersion
	 *            the appVersion to set
	 */
	@XmlElement(name="appVersion")
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
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
	@XmlElement(name="txnDateTime")
	public void setTxnDateTime(String txnDateTime) {
		this.txnDateTime = txnDateTime;
	}

	/**
	 * @return the posEntryMode
	 */
	public String getPosEntryMode() {
		return posEntryMode;
	}

	/**
	 * @param posEntryMode
	 *            the posEntryMode to set
	 */
	@XmlElement(name="posEntryMode")
	public void setPosEntryMode(String posEntryMode) {
		this.posEntryMode = posEntryMode;
	}

	/**
	 * @return the posCode
	 */
	public String getPosCode() {
		return posCode;
	}

	/**
	 * @param posCode
	 *            the posCode to set
	 */
	@XmlElement(name="posCode")
	public void setPosCode(String posCode) {
		this.posCode = posCode;
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
	@XmlElement(name="rrn")
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
	@XmlElement(name="terminalId")
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * @return the acqId
	 */
	public String getAcqId() {
		return acqId;
	}

	/**
	 * @param acqId
	 *            the acqId to set
	 */
	@XmlElement(name="acqId")
	public void setAcqId(String acqId) {
		this.acqId = acqId;
	}

	/**
	 * @return the ca_ta
	 */
	public String getCa_ta() {
		return ca_ta;
	}

	/**
	 * @param ca_ta
	 *            the ca_ta to set
	 */
	@XmlElement(name="ca_ta")
	public void setCa_ta(String ca_ta) {
		this.ca_ta = ca_ta;
	}

	/**
	 * @return the caId
	 */
	public String getCaId() {
		return caId;
	}

	/**
	 * @param caId
	 *            the caId to set
	 */
	@XmlElement(name="caId")
	public void setCaId(String caId) {
		this.caId = caId;
	}

	/**
	 * @return the bankCode
	 */
	public String getBankCode() {
		return bankCode;
	}

	/**
	 * @param bankCode
	 *            the bankCode to set
	 */
	@XmlElement(name="bankCode")
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * @return the terminalData
	 */
	public String getTerminalData() {
		return terminalData;
	}

	/**
	 * @param terminalData
	 *            the terminalData to set
	 */
	@XmlElement(name="terminalData")
	public void setTerminalData(String terminalData) {
		this.terminalData = terminalData;
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
	@XmlElement(name="agentId")
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId
	 *            the channelId to set
	 */
	@XmlElement(name="channelId")
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the channelName
	 */
	public String getChannelName() {
		return channelName;
	}

	/**
	 * @param channelName
	 *            the channelName to set
	 */
	@XmlElement(name="channelName")
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 *            the ip to set
	 */
	@XmlElement(name="ip")
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the mac
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * @param mac
	 *            the mac to set
	 */
	@XmlElement(name="mac")
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId
	 *            the msgId to set
	 */
	@XmlElement(name="msgId")
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * @return the refId
	 */
	public String getRefId() {
		return refId;
	}

	/**
	 * @param refId
	 *            the refId to set
	 */
	@XmlElement(name="refId")
	public void setRefId(String refId) {
		this.refId = refId;
	}

	/**
	 * @return the ts
	 */
	public String getTs() {
		return ts;
	}

	/**
	 * @param ts
	 *            the ts to set
	 */
	@XmlElement(name="ts")
	public void setTs(String ts) {
		this.ts = ts;
	}

	/**
	 * @return the billerId
	 */
	public String getBillerId() {
		return billerId;
	}

	/**
	 * @param billerId
	 *            the billerId to set
	 */
	@XmlElement(name="billerId")
	public void setBillerId(String billerId) {
		this.billerId = billerId;
	}

}
