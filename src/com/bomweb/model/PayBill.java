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
@Table(name = "paybill_reqrsp")
public class PayBill {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYBILL_SEQ")
	@SequenceGenerator(name = "PAYBILL_SEQ", sequenceName = "PAYBILL_SEQ", allocationSize = 0)
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
	@Column(name = "FILLER1")
	private String filler1;
	@Column(name = "FILLER2")
	private String filler2;
	@Column(name = "FILLER3")
	private String filler3;
	@Column(name = "PAYMENTID")
	private String paymentID;
	@Column(name = "PAYMENTTYPE")
	private String paymentType;
	@Column(name = "PAYMENTAMOUNT")
	private String paymentAmount;
	@Column(name = "billerNo")
	private String BILLERNO;
	@Column(name = "BILLDATE")
	private String billDate;
	@Column(name = "BILLDUEDATE")
	private String billDueDate;
	@Column(name = "AUTH1")
	private String auth1;
	@Column(name = "AUTH2")
	private String auth2;
	@Column(name = "SHORTNAME")
	private String shortName;
	@Column(name = "BILLERACCOUNTID")
	private String billerAccountId;
	@Column(name = "CUSTOMERACCOUNTNO")
	private String costomerAccountNo;

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
	@Column(name = "RSPFILLER1")
	private String rspFiller1;
	@Column(name = "RSPFILLER2")
	private String rspFiller2;
	@Column(name = "RSPRequestID")
	private String rspRequestID;
	@Column(name = "RSPBBPSREFNO")
	private String bbpsReferenceNo;
	@Column(name = "RSPREASON")
	private String reason;
	@Column(name = "RSPTIMESTAMP")
	private String timeStamp;
	@Column(name = "RSPTRANSACTIONID")
	private String transactionID;
	@Column(name = "RSPVALID")
	private String valid;
	@Column(name = "advpayamt")
	private String advPayAmt;
	@Transient
	private byte[] billReq;
	@Transient
	private List<Fillers> fillers;

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
	 * @return the filler1
	 */
	public String getFiller1() {
		return filler1;
	}

	/**
	 * @param filler1
	 *            the filler1 to set
	 */
	public void setFiller1(String filler1) {
		this.filler1 = filler1;
	}

	/**
	 * @return the filler2
	 */
	public String getFiller2() {
		return filler2;
	}

	/**
	 * @param filler2
	 *            the filler2 to set
	 */
	public void setFiller2(String filler2) {
		this.filler2 = filler2;
	}

	/**
	 * @return the filler3
	 */
	public String getFiller3() {
		return filler3;
	}

	/**
	 * @param filler3
	 *            the filler3 to set
	 */
	public void setFiller3(String filler3) {
		this.filler3 = filler3;
	}

	/**
	 * @return the paymentID
	 */
	public String getPaymentID() {
		return paymentID;
	}

	/**
	 * @param paymentID
	 *            the paymentID to set
	 */
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType
	 *            the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return the paymentAmount
	 */
	public String getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @param paymentAmount
	 *            the paymentAmount to set
	 */
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * @return the bILLERNO
	 */
	public String getBILLERNO() {
		return BILLERNO;
	}

	/**
	 * @param bILLERNO
	 *            the bILLERNO to set
	 */
	public void setBILLERNO(String bILLERNO) {
		BILLERNO = bILLERNO;
	}

	/**
	 * @return the billDate
	 */
	public String getBillDate() {
		return billDate;
	}

	/**
	 * @param billDate
	 *            the billDate to set
	 */
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	/**
	 * @return the billDueDate
	 */
	public String getBillDueDate() {
		return billDueDate;
	}

	/**
	 * @param billDueDate
	 *            the billDueDate to set
	 */
	public void setBillDueDate(String billDueDate) {
		this.billDueDate = billDueDate;
	}

	/**
	 * @return the auth1
	 */
	public String getAuth1() {
		return auth1;
	}

	/**
	 * @param auth1
	 *            the auth1 to set
	 */
	public void setAuth1(String auth1) {
		this.auth1 = auth1;
	}

	/**
	 * @return the auth2
	 */
	public String getAuth2() {
		return auth2;
	}

	/**
	 * @param auth2
	 *            the auth2 to set
	 */
	public void setAuth2(String auth2) {
		this.auth2 = auth2;
	}

	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param shortName
	 *            the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * @return the billerAccountId
	 */
	public String getBillerAccountId() {
		return billerAccountId;
	}

	/**
	 * @param billerAccountId
	 *            the billerAccountId to set
	 */
	public void setBillerAccountId(String billerAccountId) {
		this.billerAccountId = billerAccountId;
	}

	/**
	 * @return the costomerAccountNo
	 */
	public String getCostomerAccountNo() {
		return costomerAccountNo;
	}

	/**
	 * @param costomerAccountNo
	 *            the costomerAccountNo to set
	 */
	public void setCostomerAccountNo(String costomerAccountNo) {
		this.costomerAccountNo = costomerAccountNo;
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
	 * @return the rspRequestID
	 */
	public String getRspRequestID() {
		return rspRequestID;
	}

	/**
	 * @param rspRequestID
	 *            the rspRequestID to set
	 */
	public void setRspRequestID(String rspRequestID) {
		this.rspRequestID = rspRequestID;
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
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
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
	 * @return the valid
	 */
	public String getValid() {
		return valid;
	}

	/**
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(String valid) {
		this.valid = valid;
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

	public String getAdvPayAmt() {
		return advPayAmt;
	}

	public void setAdvPayAmt(String advPayAmt) {
		this.advPayAmt = advPayAmt;
	}

}
