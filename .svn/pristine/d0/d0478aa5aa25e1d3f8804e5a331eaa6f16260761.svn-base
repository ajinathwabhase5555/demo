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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author SACHIN
 *
 */
@Entity
@Table(name = "tran_reqrsp_onus")
public class ONUSTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ONUSTRANSACTION_SEQ")
	@SequenceGenerator(name = "ONUSTRANSACTION_SEQ", sequenceName = "ONUSTRANSACTION_SEQ", allocationSize = 0)
	@Column(name = "LOG_ID")
	private int id;
	@Column(name = "TRN_DATE")
	@Temporal(TemporalType.DATE)
	private Date currentDate;
	@Column(name = "REQDMP")
	private Blob requestMsg;
	@Column(name = "RSPDMP")
	private Blob responseMsg;
	@Column(name = "REQ_DE2")
	private String uidNo;
	@Column(name = "REQ_DE3")
	private String processingCode;
	@Column(name = "REQ_DE4")
	private String transactionAmount;
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
	@Column(name = "REQ_DE90")
	private String reversalReqData;
	@Column(name = "REQ_DE100")
	private String version;
	@Column(name = "REQ_DE102")
	private String senderAccountNo;
	@Column(name = "REQ_DE103")
	private String accountNo;
	@Column(name = "REQ_DE120")
	private String additionalDataFT;
	@Column(name = "REQ_DE123")
	private String hmac;
	@Column(name = "REQ_DE126")
	private String additionalData1;
	@Column(name = "REQ_DE127", length = 500)
	private String additionalData2;
	@Column(name = "RSP_DE2")
	private String resaccountNo;
	@Column(name = "RSP_DE3")
	private String resprocessingCode;
	@Column(name = "RSP_DE7")
	private String restransactionDateTime;
	@Column(name = "RSP_DE11")
	private String resstan;
	@Column(name = "RSP_DE12")
	private String restransactionTime;
	@Column(name = "RSP_DE13")
	private String restransactionDate;
	@Column(name = "RSP_DE32")
	private String resaiic;
	@Column(name = "RSP_DE37")
	private String resrrnNo;
	@Column(name = "RSP_DE39")
	private String resresponseCode;
	@Column(name = "RSP_DE41")
	private String resterminalID;
	@Column(name = "RSP_DE42")
	private String rescardAcceptorID;
	@Column(name = "RSP_DE43")
	private String rescardAcceptorName;
	@Column(name = "RSP_DE46")
	private String resAgentsInformation;
	@Column(name = "RSP_DE49")
	private String rescurrencyCode;
	@Column(name = "RSP_DE54")
	private String balance;
	@Column(name = "RSP_DE62")
	private String authCode;
	@Column(name = "RSP_DE90")
	private String reversalRspData;
	@Column(name = "RSP_DE120")
	private String resAdditionalDataFT;
	@Column(name = "CONSENT_TYPE")
	private String consentType;
	@Transient
	private String transactionCount;
	@Transient
	private byte[] isoReq;

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
	 * @return the transactionAmount
	 */
	public String getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * @param transactionAmount
	 *            the transactionAmount to set
	 */
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
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
	 * @return the senderAccountNo
	 */
	public String getSenderAccountNo() {
		return senderAccountNo;
	}

	/**
	 * @param senderAccountNo
	 *            the senderAccountNo to set
	 */
	public void setSenderAccountNo(String senderAccountNo) {
		this.senderAccountNo = senderAccountNo;
	}

	/**
	 * @return the hmac
	 */
	public String getHmac() {
		return hmac;
	}

	/**
	 * @param hmac
	 *            the hmac to set
	 */
	public void setHmac(String hmac) {
		this.hmac = hmac;
	}

	/**
	 * @return the additionalData1
	 */
	public String getAdditionalData1() {
		return additionalData1;
	}

	/**
	 * @param additionalData1
	 *            the additionalData1 to set
	 */
	public void setAdditionalData1(String additionalData1) {
		this.additionalData1 = additionalData1;
	}

	/**
	 * @return the additionalData2
	 */
	public String getAdditionalData2() {
		return additionalData2;
	}

	/**
	 * @param additionalData2
	 *            the additionalData2 to set
	 */
	public void setAdditionalData2(String additionalData2) {
		this.additionalData2 = additionalData2;
	}

	public String getResaccountNo() {
		return resaccountNo;
	}

	public void setResaccountNo(String resaccountNo) {
		this.resaccountNo = resaccountNo;
	}

	public String getResprocessingCode() {
		return resprocessingCode;
	}

	public void setResprocessingCode(String resprocessingCode) {
		this.resprocessingCode = resprocessingCode;
	}

	public String getRestransactionDateTime() {
		return restransactionDateTime;
	}

	public void setRestransactionDateTime(String restransactionDateTime) {
		this.restransactionDateTime = restransactionDateTime;
	}

	public String getResstan() {
		return resstan;
	}

	public void setResstan(String resstan) {
		this.resstan = resstan;
	}

	public String getRestransactionTime() {
		return restransactionTime;
	}

	public void setRestransactionTime(String restransactionTime) {
		this.restransactionTime = restransactionTime;
	}

	public String getRestransactionDate() {
		return restransactionDate;
	}

	public void setRestransactionDate(String restransactionDate) {
		this.restransactionDate = restransactionDate;
	}

	public String getResaiic() {
		return resaiic;
	}

	public void setResaiic(String resaiic) {
		this.resaiic = resaiic;
	}

	public String getResrrnNo() {
		return resrrnNo;
	}

	public void setResrrnNo(String resrrnNo) {
		this.resrrnNo = resrrnNo;
	}

	public String getResresponseCode() {
		return resresponseCode;
	}

	public void setResresponseCode(String resresponseCode) {
		this.resresponseCode = resresponseCode;
	}

	public String getResterminalID() {
		return resterminalID;
	}

	public void setResterminalID(String resterminalID) {
		this.resterminalID = resterminalID;
	}

	public String getRescardAcceptorID() {
		return rescardAcceptorID;
	}

	public void setRescardAcceptorID(String rescardAcceptorID) {
		this.rescardAcceptorID = rescardAcceptorID;
	}

	public String getRescardAcceptorName() {
		return rescardAcceptorName;
	}

	public void setRescardAcceptorName(String rescardAcceptorName) {
		this.rescardAcceptorName = rescardAcceptorName;
	}

	public String getRescurrencyCode() {
		return rescurrencyCode;
	}

	public void setRescurrencyCode(String rescurrencyCode) {
		this.rescurrencyCode = rescurrencyCode;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public Blob getRequestMsg() {
		return requestMsg;
	}

	public void setRequestMsg(Blob requestMsg) {
		this.requestMsg = requestMsg;
	}

	public Blob getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(Blob responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getAdditionalDataFT() {
		return additionalDataFT;
	}

	public void setAdditionalDataFT(String additionalDataFT) {
		this.additionalDataFT = additionalDataFT;
	}

	public String getResAdditionalDataFT() {
		return resAdditionalDataFT;
	}

	public void setResAdditionalDataFT(String resAdditionalDataFT) {
		this.resAdditionalDataFT = resAdditionalDataFT;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getResAgentsInformation() {
		return resAgentsInformation;
	}

	public void setResAgentsInformation(String resAgentsInformation) {
		this.resAgentsInformation = resAgentsInformation;
	}

	public String getTransactionCount() {
		return transactionCount;
	}

	public void setTransactionCount(String transactionCount) {
		this.transactionCount = transactionCount;
	}

	public byte[] getIsoReq() {
		return isoReq;
	}

	public void setIsoReq(byte[] isoReq) {
		this.isoReq = isoReq;
	}

	public String getReversalReqData() {
		return reversalReqData;
	}

	public void setReversalReqData(String reversalReqData) {
		this.reversalReqData = reversalReqData;
	}

	public String getReversalRspData() {
		return reversalRspData;
	}

	public void setReversalRspData(String reversalRspData) {
		this.reversalRspData = reversalRspData;
	}

	public String getUidNo() {
		return uidNo;
	}

	public void setUidNo(String uidNo) {
		this.uidNo = uidNo;
	}

	public String getConsentType() {
		return consentType;
	}

	public void setConsentType(String consentType) {
		this.consentType = consentType;
	}

}
