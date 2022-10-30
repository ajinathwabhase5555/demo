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

/**
 * @author SACHIN
 *
 */
@Entity
@Table(name = "aadhaarlinkstatus_reqrsp")
public class AadhaarLinkStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AADHAARSTATUS_SEQ")
	@SequenceGenerator(name = "AADHAARSTATUS_SEQ", sequenceName = "AADHAARSTATUS_SEQ", allocationSize = 0)
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
	@Column(name = "TXNTIME")
	private String transactionTime;
	@Column(name = "RRN")
	private String rrn;
	@Column(name = "AGENTID")
	private String agentID;
	@Column(name = "RSPRRN")
	private String rspRrn;
	@Column(name = "RESPONSECODE")
	private String responseCode;
	@Column(name = "RESPONSEDESC")
	private String responseDesc;
	@Column(name = "BANKIIN")
	private String bankiin;
	@Column(name = "BANKNAME")
	private String bankName;
	@Column(name = "MAPPINGSTATUS")
	private String mappingStatus;

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

	/**
	 * @return the bankiin
	 */
	public String getBankiin() {
		return bankiin;
	}

	/**
	 * @param bankiin
	 *            the bankiin to set
	 */
	public void setBankiin(String bankiin) {
		this.bankiin = bankiin;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName
	 *            the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the mappingStatus
	 */
	public String getMappingStatus() {
		return mappingStatus;
	}

	/**
	 * @param mappingStatus
	 *            the mappingStatus to set
	 */
	public void setMappingStatus(String mappingStatus) {
		this.mappingStatus = mappingStatus;
	}

}
