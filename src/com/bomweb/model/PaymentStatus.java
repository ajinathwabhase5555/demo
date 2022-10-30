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

import com.bomweb.bbps.xml.Fillers;

/**
 * @author SACHIN
 *
 */
@Entity
@Table(name = "paymentstatus_reqrsp")
public class PaymentStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYMENTSTATUS_SEQ")
	@SequenceGenerator(name = "PAYMENTSTATUS_SEQ", sequenceName = "PAYMENTSTATUS_SEQ", allocationSize = 0)
	@Column(name = "LOG_ID")
	private int id;
	@Column(name = "TRN_DATE")
	@Temporal(TemporalType.DATE)
	private Date currentDate;
	@Column(name = "REQDMP")
	private Blob requestMsg;
	@Column(name = "RSPDMP")
	private Blob responseMsg;
	@Column(name = "PROCESSINGCODE")
	private String processingCode;
	@Column(name = "TXNDATETIME")
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
	@Column(name = "BILLERID")
	private String billerID;
	@Column(name = "REQUESTID")
	private String requestID;

	@Column(name = "RESPONSECODE")
	private String responseCode;
	@Column(name = "RESPONSEDESC")
	private String responseDesc;
	@Column(name = "ERRORCODE")
	private String errCode;
	@Column(name = "ERRORDESC")
	private String errDesc;
	@Column(name = "RSPRRN")
	private String rspRRN;
	@Column(name = "RSPBBPSREFNO")
	private String bbpsReferenceNo;
	@Column(name = "RSPTIMESTAMP")
	private String timeStamp;
	@Column(name = "RSPTRANSACTIONID")
	private String transactionID;
	@Column(name = "RSPFILLER1")
	private String rspFiller1;
	@Column(name = "RSPFILLER2")
	private String rspFiller2;
	@Transient
	private List<Fillers> fillers;

	@Transient
	private byte[] billReq;

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
	 * @return the billerID
	 */
	public String getBillerID() {
		return billerID;
	}

	/**
	 * @param billerID
	 *            the billerID to set
	 */
	public void setBillerID(String billerID) {
		this.billerID = billerID;
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
	 * @return the errCode
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * @param errCode
	 *            the errCode to set
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * @return the errDesc
	 */
	public String getErrDesc() {
		return errDesc;
	}

	/**
	 * @param errDesc
	 *            the errDesc to set
	 */
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
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
	 * @return the bbpsReferenceNo
	 */
	public String getBbpsReferenceNo() {
		return bbpsReferenceNo;
	}

	/**
	 * @param bbpsReferenceNo
	 *            the bbpsReferenceNo to set
	 */
	public void setBbpsReferenceNo(String bbpsReferenceNo) {
		this.bbpsReferenceNo = bbpsReferenceNo;
	}

	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp
	 *            the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
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
	 * @return the rspFiller1
	 */
	public String getRspFiller1() {
		return rspFiller1;
	}

	/**
	 * @param rspFiller1
	 *            the rspFiller1 to set
	 */
	public void setRspFiller1(String rspFiller1) {
		this.rspFiller1 = rspFiller1;
	}

	/**
	 * @return the rspFiller2
	 */
	public String getRspFiller2() {
		return rspFiller2;
	}

	/**
	 * @param rspFiller2
	 *            the rspFiller2 to set
	 */
	public void setRspFiller2(String rspFiller2) {
		this.rspFiller2 = rspFiller2;
	}

	/**
	 * @return the fillers
	 */
	public List<Fillers> getFillers() {
		return fillers;
	}

	/**
	 * @param fillers
	 *            the fillers to set
	 */
	public void setFillers(List<Fillers> fillers) {
		this.fillers = fillers;
	}

	/**
	 * @return the billReq
	 */
	public byte[] getBillReq() {
		return billReq;
	}

	/**
	 * @param billReq
	 *            the billReq to set
	 */
	public void setBillReq(byte[] billReq) {
		this.billReq = billReq;
	}

}