/**
 * 
 */
package com.bomweb.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author SACHIN
 *
 */
@Entity
@Table(name = "ekyc_reqrsp")
public class EkycLog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EKYC_SEQ")
	@SequenceGenerator(name = "EKYC_SEQ", sequenceName = "EKYC_SEQ", allocationSize = 0)
	@Column(name = "LOG_ID")
	private int id;
	@Column(name = "TRN_DATE")
	private Date currentDate;
	@Column(name = "REQDMP")
	private Blob requestMsg;
	@Column(name = "RSPDMP")
	private Blob responseMsg;
	@Column(name = "REQ_DE2")
	private String accountNo;
	@Column(name = "REQ_DE3")
	private String processingCode;
	@Column(name = "REQ_DE7")
	private String transactionDateTime;
	@Column(name = "REQ_DE11")
	private String stan;
	@Column(name = "REQ_DE12")
	private String transactionTime;
	@Column(name = "REQ_DE13")
	private String transactionDate;
	@Column(name = "REQ_DE18")
	private String merchantType;
	@Column(name = "REQ_DE22")
	private String posEntryMode;
	@Column(name = "REQ_DE25")
	private String posConditionCode;
	@Column(name = "REQ_DE32")
	private String aiic;
	@Column(name = "REQ_DE37")
	private String rrnNo;
	@Column(name = "REQ_DE41")
	private String terminalID;
	@Column(name = "REQ_DE42")
	private String cardAcceptorID;
	@Column(name = "REQ_DE43")
	private String cardAcceptorName;
	@Column(name = "REQ_DE46")
	private String agentsInformation;
	@Column(name = "REQ_DE49")
	private String currencyCode;
	@Column(name = "REQ_DE73")
	private String datetime;
	@Column(name = "REQ_DE100")
	private String version;
	@Column(name = "REQ_DE111")
	private Blob xmlData;
	@Column(name = "RSP_DE2")
	private String rspAaccountNo;
	@Column(name = "RSP_DE3")
	private String rspProcessingCode;
	@Column(name = "RSP_DE7")
	private String rspTransactionDateTime;
	@Column(name = "RSP_DE11")
	private String rspStan;
	@Column(name = "RSP_DE12")
	private String rspTransactionTime;
	@Column(name = "RSP_DE13")
	private String rspTransactionDate;
	@Column(name = "RSP_DE37")
	private String rspRRNNo;
	@Column(name = "RSP_DE39")
	private String responseCode;
	@Column(name = "RSP_DE41")
	private String rspTerminalID;
	@Column(name = "RSP_DE42")
	private String rspCardAcceptorID;
	@Column(name = "RSP_DE43")
	private String rspCardAcceptorName;
	@Column(name = "RSP_DE112")
	private Blob kycXML;
	@Column(name = "RSP_DE127")
	private String additionalData;
	@Column(name = "CONSENT_TYPE")
	private String consentType;
	@Transient
	private byte[] ekycReq;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the currentDate
	 */
	public Date getCurrentDate() {
		return currentDate;
	}

	/**
	 * @param currentDate
	 *            the currentDate to set
	 */
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	/**
	 * @return the requestMsg
	 */
	public Blob getRequestMsg() {
		return requestMsg;
	}

	/**
	 * @param requestMsg
	 *            the requestMsg to set
	 */
	public void setRequestMsg(Blob requestMsg) {
		this.requestMsg = requestMsg;
	}

	/**
	 * @return the responseMsg
	 */
	public Blob getResponseMsg() {
		return responseMsg;
	}

	/**
	 * @param responseMsg
	 *            the responseMsg to set
	 */
	public void setResponseMsg(Blob responseMsg) {
		this.responseMsg = responseMsg;
	}

	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo
	 *            the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the processingCode
	 */
	public String getProcessingCode() {
		return processingCode;
	}

	/**
	 * @param processingCode
	 *            the processingCode to set
	 */
	public void setProcessingCode(String processingCode) {
		this.processingCode = processingCode;
	}

	/**
	 * @return the transactionDateTime
	 */
	public String getTransactionDateTime() {
		return transactionDateTime;
	}

	/**
	 * @param transactionDateTime
	 *            the transactionDateTime to set
	 */
	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	/**
	 * @return the stan
	 */
	public String getStan() {
		return stan;
	}

	/**
	 * @param stan
	 *            the stan to set
	 */
	public void setStan(String stan) {
		this.stan = stan;
	}

	/**
	 * @return the transactionTime
	 */
	public String getTransactionTime() {
		return transactionTime;
	}

	/**
	 * @param transactionTime
	 *            the transactionTime to set
	 */
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	/**
	 * @return the transactionDate
	 */
	public String getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate
	 *            the transactionDate to set
	 */
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the merchantType
	 */
	public String getMerchantType() {
		return merchantType;
	}

	/**
	 * @param merchantType
	 *            the merchantType to set
	 */
	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
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
	public void setPosEntryMode(String posEntryMode) {
		this.posEntryMode = posEntryMode;
	}

	/**
	 * @return the posConditionCode
	 */
	public String getPosConditionCode() {
		return posConditionCode;
	}

	/**
	 * @param posConditionCode
	 *            the posConditionCode to set
	 */
	public void setPosConditionCode(String posConditionCode) {
		this.posConditionCode = posConditionCode;
	}

	/**
	 * @return the aiic
	 */
	public String getAiic() {
		return aiic;
	}

	/**
	 * @param aiic
	 *            the aiic to set
	 */
	public void setAiic(String aiic) {
		this.aiic = aiic;
	}

	/**
	 * @return the rrnNo
	 */
	public String getRrnNo() {
		return rrnNo;
	}

	/**
	 * @param rrnNo
	 *            the rrnNo to set
	 */
	public void setRrnNo(String rrnNo) {
		this.rrnNo = rrnNo;
	}

	/**
	 * @return the terminalID
	 */
	public String getTerminalID() {
		return terminalID;
	}

	/**
	 * @param terminalID
	 *            the terminalID to set
	 */
	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}

	/**
	 * @return the cardAcceptorID
	 */
	public String getCardAcceptorID() {
		return cardAcceptorID;
	}

	/**
	 * @param cardAcceptorID
	 *            the cardAcceptorID to set
	 */
	public void setCardAcceptorID(String cardAcceptorID) {
		this.cardAcceptorID = cardAcceptorID;
	}

	/**
	 * @return the cardAcceptorName
	 */
	public String getCardAcceptorName() {
		return cardAcceptorName;
	}

	/**
	 * @param cardAcceptorName
	 *            the cardAcceptorName to set
	 */
	public void setCardAcceptorName(String cardAcceptorName) {
		this.cardAcceptorName = cardAcceptorName;
	}

	/**
	 * @return the agentsInformation
	 */
	public String getAgentsInformation() {
		return agentsInformation;
	}

	/**
	 * @param agentsInformation
	 *            the agentsInformation to set
	 */
	public void setAgentsInformation(String agentsInformation) {
		this.agentsInformation = agentsInformation;
	}

	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currencyCode
	 *            the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * @return the datetime
	 */
	public String getDatetime() {
		return datetime;
	}

	/**
	 * @param datetime
	 *            the datetime to set
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the xmlData
	 */
	public Blob getXmlData() {
		return xmlData;
	}

	/**
	 * @param xmlData
	 *            the xmlData to set
	 */
	public void setXmlData(Blob xmlData) {
		this.xmlData = xmlData;
	}

	/**
	 * @return the rspAaccountNo
	 */
	public String getRspAaccountNo() {
		return rspAaccountNo;
	}

	/**
	 * @param rspAaccountNo
	 *            the rspAaccountNo to set
	 */
	public void setRspAaccountNo(String rspAaccountNo) {
		this.rspAaccountNo = rspAaccountNo;
	}

	/**
	 * @return the rspProcessingCode
	 */
	public String getRspProcessingCode() {
		return rspProcessingCode;
	}

	/**
	 * @param rspProcessingCode
	 *            the rspProcessingCode to set
	 */
	public void setRspProcessingCode(String rspProcessingCode) {
		this.rspProcessingCode = rspProcessingCode;
	}

	/**
	 * @return the rspTransactionDateTime
	 */
	public String getRspTransactionDateTime() {
		return rspTransactionDateTime;
	}

	/**
	 * @param rspTransactionDateTime
	 *            the rspTransactionDateTime to set
	 */
	public void setRspTransactionDateTime(String rspTransactionDateTime) {
		this.rspTransactionDateTime = rspTransactionDateTime;
	}

	/**
	 * @return the rspStan
	 */
	public String getRspStan() {
		return rspStan;
	}

	/**
	 * @param rspStan
	 *            the rspStan to set
	 */
	public void setRspStan(String rspStan) {
		this.rspStan = rspStan;
	}

	/**
	 * @return the rspTransactionTime
	 */
	public String getRspTransactionTime() {
		return rspTransactionTime;
	}

	/**
	 * @param rspTransactionTime
	 *            the rspTransactionTime to set
	 */
	public void setRspTransactionTime(String rspTransactionTime) {
		this.rspTransactionTime = rspTransactionTime;
	}

	/**
	 * @return the rspTransactionDate
	 */
	public String getRspTransactionDate() {
		return rspTransactionDate;
	}

	/**
	 * @param rspTransactionDate
	 *            the rspTransactionDate to set
	 */
	public void setRspTransactionDate(String rspTransactionDate) {
		this.rspTransactionDate = rspTransactionDate;
	}

	/**
	 * @return the rspRRNNo
	 */
	public String getRspRRNNo() {
		return rspRRNNo;
	}

	/**
	 * @param rspRRNNo
	 *            the rspRRNNo to set
	 */
	public void setRspRRNNo(String rspRRNNo) {
		this.rspRRNNo = rspRRNNo;
	}

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode
	 *            the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the rspTerminalID
	 */
	public String getRspTerminalID() {
		return rspTerminalID;
	}

	/**
	 * @param rspTerminalID
	 *            the rspTerminalID to set
	 */
	public void setRspTerminalID(String rspTerminalID) {
		this.rspTerminalID = rspTerminalID;
	}

	/**
	 * @return the rspCardAcceptorID
	 */
	public String getRspCardAcceptorID() {
		return rspCardAcceptorID;
	}

	/**
	 * @param rspCardAcceptorID
	 *            the rspCardAcceptorID to set
	 */
	public void setRspCardAcceptorID(String rspCardAcceptorID) {
		this.rspCardAcceptorID = rspCardAcceptorID;
	}

	/**
	 * @return the rspCardAcceptorName
	 */
	public String getRspCardAcceptorName() {
		return rspCardAcceptorName;
	}

	/**
	 * @param rspCardAcceptorName
	 *            the rspCardAcceptorName to set
	 */
	public void setRspCardAcceptorName(String rspCardAcceptorName) {
		this.rspCardAcceptorName = rspCardAcceptorName;
	}

	/**
	 * @return the kycXML
	 */
	public Blob getKycXML() {
		return kycXML;
	}

	/**
	 * @param kycXML
	 *            the kycXML to set
	 */
	public void setKycXML(Blob kycXML) {
		this.kycXML = kycXML;
	}

	/**
	 * @return the additionalData
	 */
	public String getAdditionalData() {
		return additionalData;
	}

	/**
	 * @param additionalData
	 *            the additionalData to set
	 */
	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}

	public byte[] getEkycReq() {
		return ekycReq;
	}

	public void setEkycReq(byte[] ekycReq) {
		this.ekycReq = ekycReq;
	}

	public String getConsentType() {
		return consentType;
	}

	public void setConsentType(String consentType) {
		this.consentType = consentType;
	}
}
