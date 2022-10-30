/**
 * 
 */
package com.bomweb.model;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

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
@Table(name = "AADHAARENQUIRY_REQRSP")
public class AadhaarEnquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AADHAARENQUIRY_SEQ")
	@SequenceGenerator(name = "AADHAARENQUIRY_SEQ", sequenceName = "AADHAARENQUIRY_SEQ", allocationSize = 0)
	@Column(name = "LOG_ID")
	private int id;
	@Column(name = "TRN_DATE")
	@Temporal(TemporalType.DATE)
	private Date currentDate;
	@Column(name = "REQDMP")
	private Blob requestMsg;
	@Column(name = "RSPDMP")
	private Blob responseMsg;
	@Column(name = "DATETIME")
	private String dateTime;
	@Column(name = "ACCOUNTNO")
	private String accountNo;
	@Column(name = "PROCESSINGCODE")
	private String processingCode;
	@Column(name = "RRN")
	private String rrn;
	@Column(name = "REQUESTID")
	private String requestID;
	@Column(name = "AGENTID")
	private String agentID;
	@Column(name = "TERMINALID")
	private String terminalID;
	@Column(name = "ACQUIRERID")
	private String acquirerID;
	@Column(name = "RSPRRN")
	private String rspRrn;
	@Column(name = "RESPONSECODE")
	private String responseCode;
	@Column(name = "RESPONSEDESC")
	private String responseDesc;
	@Column(name = "CUSTOMERNAMEANDCIF")
	private String customerNameAndCif;
	
	@Transient
	private List<String> customer;

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
	 * @return the transactionTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * @param transactionTime
	 *            the transactionTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
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
	 * @return the requestID
	 */
	public String getRequestID() {
		return requestID;
	}

	/**
	 * @param requestID
	 *            the requestID to set
	 */
	public void setRequestID(String requestID) {
		this.requestID = requestID;
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
	 * @return the rspRrn
	 */
	public String getRspRrn() {
		return rspRrn;
	}

	/**
	 * @param rspRrn
	 *            the rspRrn to set
	 */
	public void setRspRrn(String rspRrn) {
		this.rspRrn = rspRrn;
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

	public String getAcquirerID() {
		return acquirerID;
	}

	public void setAcquirerID(String acquirerID) {
		this.acquirerID = acquirerID;
	}

	public String getCustomerNameAndCif() {
		return customerNameAndCif;
	}

	public void setCustomerNameAndCif(String customerNameAndCif) {
		this.customerNameAndCif = customerNameAndCif;
	}

	public List<String> getCustomer() {
		return customer;
	}

	public void setCustomer(List<String> customer) {
		this.customer = customer;
	}

}
