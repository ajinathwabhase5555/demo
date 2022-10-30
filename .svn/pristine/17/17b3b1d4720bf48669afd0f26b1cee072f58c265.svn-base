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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author SACHIN
 *
 */
@Entity
@Table(name = "logonservice_reqrsp")
public class Logon {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOGON_SEQ")
	@SequenceGenerator(name = "LOGON_SEQ", sequenceName = "LOGON_SEQ", allocationSize = 0)
	@Column(name = "LOG_ID")
	private int id;
	@Column(name = "TRN_DATE")
	@Temporal(TemporalType.DATE)
	private Date currentDate;
	@Column(name = "REQDMP")
	private Blob requestMsg;
	@Column(name = "RSPDMP")
	private Blob responseMsg;
	@Column(name = "PAN")
	private String pan;
	@Column(name = "PROCESSINGCODE")
	private String processingCode;
	@Column(name = "TRN_DATETIME")
	private String transactionDateTime;
	@Column(name = "POSENTRYMODE")
	private String posEntryMode;
	@Column(name = "POSCODE")
	private String posCode;
	@Column(name = "RRN")
	private String rrn;
	@Column(name = "TERMINALID")
	private String terminalID;
	@Column(name = "AGENTID")
	private String agentID;
	@Column(name = "TXNMODE")
	private String txnMode;
	@Column(name = "ACCOUNTNO")
	private String accountNo;
	@Column(name = "BRANCHCODE")
	private String branchCode;
	@Column(name = "CONSENT")
	private String consent;
	@Column(name = "REQCODE")
	private String reqCode;
	@Column(name = "RESPONSECODE")
	private String responseCode;
	@Column(name = "RESPONSEDESC")
	private String responseDesc;
	@Column(name = "RSPRRN")
	private String rspRRN;

	@Transient
	private byte[] logonReq;

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
	 * @return the rrn
	 */
	public String getRrn() {
		return rrn;
	}

	/**
	 * @param rrn
	 *            the rrn to set
	 */
	public void setRrn(String rrn) {
		this.rrn = rrn;
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
	 * @return the agentID
	 */
	public String getAgentID() {
		return agentID;
	}

	/**
	 * @param agentID
	 *            the agentID to set
	 */
	public void setAgentID(String agentID) {
		this.agentID = agentID;
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
	public void setTxnMode(String txnMode) {
		this.txnMode = txnMode;
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
	 * @return the responseDesc
	 */
	public String getResponseDesc() {
		return responseDesc;
	}

	/**
	 * @param responseDesc
	 *            the responseDesc to set
	 */
	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	/**
	 * @return the rspRRN
	 */
	public String getRspRRN() {
		return rspRRN;
	}

	/**
	 * @param rspRRN
	 *            the rspRRN to set
	 */
	public void setRspRRN(String rspRRN) {
		this.rspRRN = rspRRN;
	}

	/**
	 * @return the logonReq
	 */
	public byte[] getLogonReq() {
		return logonReq;
	}

	/**
	 * @param logonReq
	 *            the logonReq to set
	 */
	public void setLogonReq(byte[] logonReq) {
		this.logonReq = logonReq;
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
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * @param branchCode
	 *            the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * @return the consent
	 */
	public String getConsent() {
		return consent;
	}

	/**
	 * @param consent
	 *            the consent to set
	 */
	public void setConsent(String consent) {
		this.consent = consent;
	}

	/**
	 * @return the reqCode
	 */
	public String getReqCode() {
		return reqCode;
	}

	/**
	 * @param reqCode
	 *            the reqCode to set
	 */
	public void setReqCode(String reqCode) {
		this.reqCode = reqCode;
	}

}
