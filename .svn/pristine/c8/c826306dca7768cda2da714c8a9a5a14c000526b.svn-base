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
@Table(name = "insurance_req")
public class InsuranceRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSURANCREQ_SEQ")
	@SequenceGenerator(name = "INSURANCREQ_SEQ", sequenceName = "INSURANCREQ_SEQ", allocationSize = 0)
	@Column(name = "LOG_ID")
	private int id;
	@Column(name = "TRN_DATE")
	@Temporal(TemporalType.DATE)
	private Date currentDate;
	@Column(name = "REQDMP")
	private Blob requestMsg;
	@Column(name = "RSPDMP")
	private Blob responseMsg;
	@Column(name = "RRN")
	private String rrn;
	@Column(name = "ACCOUNTNO")
	private String accountNo;
	@Column(name = "PROCESSINGCODE")
	private String processingCode;
	@Column(name = "TXNDATETIME")
	private String transactionDateTime;
	@Column(name = "TERMINALID")
	private String terminalID;
	@Column(name = "AGENTID")
	private String agentID;
	@Column(name = "SCHEMECODE")
	private String schemeCode;
	@Column(name = "CUSTOMERNAME")
	private String customerName;
	@Column(name = "RSPRRN")
	private String rspRRN;
	@Column(name = "RSPCODE")
	private String rspCode;
	@Column(name = "RSPDESC")
	private String rspDesc;
	@Column(name = "DATETIME")
	private String dateTime;
	@Column(name = "CUSTID")
	private String custID;
	@Column(name = "SCHEMEENDDATE")
	private String schemeEndDate;
	@Column(name = "SCHEMESTARTDATE")
	private String schemeStartDate;
	@Column(name = "TRANSACTIONDATE")
	private String transactionDate;
	@Column(name = "TRANSACTIONID")
	private String transactionID;
	@Column(name = "TRANSACTIONTIME")
	private String transactionTime;
	@Transient
	private byte[] insuranceReq;

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
	 * @return the schemeCode
	 */
	public String getSchemeCode() {
		return schemeCode;
	}

	/**
	 * @param schemeCode
	 *            the schemeCode to set
	 */
	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	 * @return the rspCode
	 */
	public String getRspCode() {
		return rspCode;
	}

	/**
	 * @param rspCode
	 *            the rspCode to set
	 */
	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}

	/**
	 * @return the rspDesc
	 */
	public String getRspDesc() {
		return rspDesc;
	}

	/**
	 * @param rspDesc
	 *            the rspDesc to set
	 */
	public void setRspDesc(String rspDesc) {
		this.rspDesc = rspDesc;
	}

	/**
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime
	 *            the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the custID
	 */
	public String getCustID() {
		return custID;
	}

	/**
	 * @param custID
	 *            the custID to set
	 */
	public void setCustID(String custID) {
		this.custID = custID;
	}

	/**
	 * @return the schemeEndDate
	 */
	public String getSchemeEndDate() {
		return schemeEndDate;
	}

	/**
	 * @param schemeEndDate
	 *            the schemeEndDate to set
	 */
	public void setSchemeEndDate(String schemeEndDate) {
		this.schemeEndDate = schemeEndDate;
	}

	/**
	 * @return the schemeStartDate
	 */
	public String getSchemeStartDate() {
		return schemeStartDate;
	}

	/**
	 * @param schemeStartDate
	 *            the schemeStartDate to set
	 */
	public void setSchemeStartDate(String schemeStartDate) {
		this.schemeStartDate = schemeStartDate;
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
	 * @return the transactionID
	 */
	public String getTransactionID() {
		return transactionID;
	}

	/**
	 * @param transactionID
	 *            the transactionID to set
	 */
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
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

	public byte[] getInsuranceReq() {
		return insuranceReq;
	}

	public void setInsuranceReq(byte[] insuranceReq) {
		this.insuranceReq = insuranceReq;
	}

}
