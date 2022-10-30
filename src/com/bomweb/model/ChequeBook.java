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

import com.bomweb.chequebook.Cheque;

/**
 * @author SACHIN
 *
 */
@Entity
@Table(name = "easebanking_reqrsp")
public class ChequeBook {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHEQUEBOOK_SEQ")
	@SequenceGenerator(name = "CHEQUEBOOK_SEQ", sequenceName = "CHEQUEBOOK_SEQ", allocationSize = 0)
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
	@Column(name = "PURPOSE")
	private String purpose;
	@Column(name = "NOOFCHEQUEBOOK")
	private String noOfChequeBook;
	@Column(name = "NOOFLEAVES")
	private String noOfLeaves;
	@Column(name = "STOPREASONCODE")
	private String stopReasonCode;
	@Column(name = "FROMCHEQUENO")
	private String fromChequeNo;
	@Column(name = "TOCHEQUENO")
	private String toChequeNo;
	@Column(name = "STOPCOMMENT")
	private String stopComment;
	@Column(name = "OPTIONDATA")
	private String Option;

	@Column(name = "RESPONSECODE")
	private String responseCode;
	@Column(name = "RESPONSEDESC")
	private String responseDesc;
	@Column(name = "RSPRRN")
	private String rspRRN;
	@Column(name = "RSPCHEQUE1")
	private String rspCheque1;
	@Column(name = "RSPCHEQUE2")
	private String rspCheque2;
	@Column(name = "RSPCHEQUE3")
	private String rspCheque3;
	@Column(name = "RSPCHEQUE4")
	private String rspCheque4;
	@Column(name = "RSPCHEQUE5")
	private String rspCheque5;

	@Transient
	private byte[] chequeReq;
	
	@Transient
	private List<Cheque> chequeList;

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
	 * @return the purpose
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * @param purpose
	 *            the purpose to set
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	/**
	 * @return the noOfChequeBook
	 */
	public String getNoOfChequeBook() {
		return noOfChequeBook;
	}

	/**
	 * @param noofchequebook
	 *            the noOfChequeBook to set
	 */
	public void setNoOfChequeBook(String noOfChequeBook) {
		this.noOfChequeBook = noOfChequeBook;
	}

	/**
	 * @return the noOfLeaves
	 */
	public String getNoOfLeaves() {
		return noOfLeaves;
	}

	/**
	 * @param noOfLeaves
	 *            the noOfLeaves to set
	 */
	public void setNoOfLeaves(String noOfLeaves) {
		this.noOfLeaves = noOfLeaves;
	}

	/**
	 * @return the stopReasonCode
	 */
	public String getStopReasonCode() {
		return stopReasonCode;
	}

	/**
	 * @param stopReasonCode
	 *            the stopReasonCode to set
	 */
	public void setStopReasonCode(String stopReasonCode) {
		this.stopReasonCode = stopReasonCode;
	}

	/**
	 * @return the fromChequeNo
	 */
	public String getFromChequeNo() {
		return fromChequeNo;
	}

	/**
	 * @param fromChequeNo
	 *            the fromChequeNo to set
	 */
	public void setFromChequeNo(String fromChequeNo) {
		this.fromChequeNo = fromChequeNo;
	}

	/**
	 * @return the toChequeNo
	 */
	public String getToChequeNo() {
		return toChequeNo;
	}

	/**
	 * @param toChequeNo
	 *            the toChequeNo to set
	 */
	public void setToChequeNo(String toChequeNo) {
		this.toChequeNo = toChequeNo;
	}

	/**
	 * @return the stopComment
	 */
	public String getStopComment() {
		return stopComment;
	}

	/**
	 * @param stopComment
	 *            the stopComment to set
	 */
	public void setStopComment(String stopComment) {
		this.stopComment = stopComment;
	}

	/**
	 * @return the option
	 */
	public String getOption() {
		return Option;
	}

	/**
	 * @param option
	 *            the option to set
	 */
	public void setOption(String option) {
		Option = option;
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
	 * @return the chequeReq
	 */
	public byte[] getChequeReq() {
		return chequeReq;
	}

	/**
	 * @param chequeReq
	 *            the chequeReq to set
	 */
	public void setChequeReq(byte[] chequeReq) {
		this.chequeReq = chequeReq;
	}

	/**
	 * @return the rspCheque1
	 */
	public String getRspCheque1() {
		return rspCheque1;
	}

	/**
	 * @param rspCheque1
	 *            the rspCheque1 to set
	 */
	public void setRspCheque1(String rspCheque1) {
		this.rspCheque1 = rspCheque1;
	}

	/**
	 * @return the rspCheque2
	 */
	public String getRspCheque2() {
		return rspCheque2;
	}

	/**
	 * @param rspCheque2
	 *            the rspCheque2 to set
	 */
	public void setRspCheque2(String rspCheque2) {
		this.rspCheque2 = rspCheque2;
	}

	/**
	 * @return the rspCheque3
	 */
	public String getRspCheque3() {
		return rspCheque3;
	}

	/**
	 * @param rspCheque3
	 *            the rspCheque3 to set
	 */
	public void setRspCheque3(String rspCheque3) {
		this.rspCheque3 = rspCheque3;
	}

	/**
	 * @return the rspCheque4
	 */
	public String getRspCheque4() {
		return rspCheque4;
	}

	/**
	 * @param rspCheque4
	 *            the rspCheque4 to set
	 */
	public void setRspCheque4(String rspCheque4) {
		this.rspCheque4 = rspCheque4;
	}

	/**
	 * @return the rspCheque5
	 */
	public String getRspCheque5() {
		return rspCheque5;
	}

	/**
	 * @param rspCheque5
	 *            the rspCheque5 to set
	 */
	public void setRspCheque5(String rspCheque5) {
		this.rspCheque5 = rspCheque5;
	}

	public List<Cheque> getChequeList() {
		return chequeList;
	}

	public void setChequeList(List<Cheque> chequeList) {
		this.chequeList = chequeList;
	}

}
