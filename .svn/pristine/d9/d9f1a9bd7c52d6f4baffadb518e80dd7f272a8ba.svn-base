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
@Table(name = "rupay_reqrsp_onus")
public class RupayTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RUPAYTRANSACTION_SEQ")
	@SequenceGenerator(name = "RUPAYTRANSACTION_SEQ", sequenceName = "RUPAYTRANSACTION_SEQ", allocationSize = 0)
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
	private String pan;
	@Column(name = "REQ_DE3")
	private String processingCode;
	@Column(name = "REQ_DE4")
	private String transactionAmount;
	@Column(name = "REQ_DE11")
	private String stan;
	@Column(name = "REQ_DE22")
	private String posEntryMode;
	@Column(name = "REQ_DE24")
	private String networkID;
	@Column(name = "REQ_DE25")
	private String posCode;
	@Column(name = "REQ_DE35")
	private String trackData;
	@Column(name = "REQ_DE41")
	private String terminalID;
	@Column(name = "REQ_DE42")
	private String cardAcceptorID;
	@Column(name = "REQ_DE49")
	private String currencyCode;
	@Column(name = "REQ_DE103")
	private String accountNo;

	@Column(name = "RSP_DE3")
	private String resprocessingCode;
	@Column(name = "RSP_DE11")
	private String resstan;
	@Column(name = "RSP_DE12")
	private String restransactionTime;
	@Column(name = "RSP_DE13")
	private String restransactionDate;
	@Column(name = "RSP_DE37")
	private String resrrnNo;
	@Column(name = "RSP_DE38")
	private String authNo;
	@Column(name = "RSP_DE39")
	private String resresponseCode;
	@Column(name = "RSP_DE54")
	private String balance;
	@Column(name = "RSP_DE62")
	private String tpk;

	@Transient
	private byte[] isoReq;

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
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}

	/**
	 * @param pan
	 *            the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
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
	 * @return the networkID
	 */
	public String getNetworkID() {
		return networkID;
	}

	/**
	 * @param networkID
	 *            the networkID to set
	 */
	public void setNetworkID(String networkID) {
		this.networkID = networkID;
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
	public void setPosCode(String posCode) {
		this.posCode = posCode;
	}

	/**
	 * @return the trackData
	 */
	public String getTrackData() {
		return trackData;
	}

	/**
	 * @param trackData
	 *            the trackData to set
	 */
	public void setTrackData(String trackData) {
		this.trackData = trackData;
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
	 * @return the resprocessingCode
	 */
	public String getResprocessingCode() {
		return resprocessingCode;
	}

	/**
	 * @param resprocessingCode
	 *            the resprocessingCode to set
	 */
	public void setResprocessingCode(String resprocessingCode) {
		this.resprocessingCode = resprocessingCode;
	}

	/**
	 * @return the resstan
	 */
	public String getResstan() {
		return resstan;
	}

	/**
	 * @param resstan
	 *            the resstan to set
	 */
	public void setResstan(String resstan) {
		this.resstan = resstan;
	}

	/**
	 * @return the restransactionTime
	 */
	public String getRestransactionTime() {
		return restransactionTime;
	}

	/**
	 * @param restransactionTime
	 *            the restransactionTime to set
	 */
	public void setRestransactionTime(String restransactionTime) {
		this.restransactionTime = restransactionTime;
	}

	/**
	 * @return the restransactionDate
	 */
	public String getRestransactionDate() {
		return restransactionDate;
	}

	/**
	 * @param restransactionDate
	 *            the restransactionDate to set
	 */
	public void setRestransactionDate(String restransactionDate) {
		this.restransactionDate = restransactionDate;
	}

	/**
	 * @return the resrrnNo
	 */
	public String getResrrnNo() {
		return resrrnNo;
	}

	/**
	 * @param resrrnNo
	 *            the resrrnNo to set
	 */
	public void setResrrnNo(String resrrnNo) {
		this.resrrnNo = resrrnNo;
	}

	/**
	 * @return the authNo
	 */
	public String getAuthNo() {
		return authNo;
	}

	/**
	 * @param authNo
	 *            the authNo to set
	 */
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}

	/**
	 * @return the resresponseCode
	 */
	public String getResresponseCode() {
		return resresponseCode;
	}

	/**
	 * @param resresponseCode
	 *            the resresponseCode to set
	 */
	public void setResresponseCode(String resresponseCode) {
		this.resresponseCode = resresponseCode;
	}

	/**
	 * @return the balance
	 */
	public String getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}

	/**
	 * @return the isoReq
	 */
	public byte[] getIsoReq() {
		return isoReq;
	}

	/**
	 * @param isoReq
	 *            the isoReq to set
	 */
	public void setIsoReq(byte[] isoReq) {
		this.isoReq = isoReq;
	}

	/**
	 * @return the tpk
	 */
	public String getTpk() {
		return tpk;
	}

	/**
	 * @param tpk
	 *            the tpk to set
	 */
	public void setTpk(String tpk) {
		this.tpk = tpk;
	}
}
