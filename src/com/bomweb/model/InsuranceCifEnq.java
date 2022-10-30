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

import com.bomweb.insurance.JoinAccount;

/**
 * @author SACHIN
 *
 */
@Entity
@Table(name = "insurance_cif_enq")
public class InsuranceCifEnq {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CIFENQ_SEQ")
	@SequenceGenerator(name = "CIFENQ_SEQ", sequenceName = "CIFENQ_SEQ", allocationSize = 0)
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
	@Column(name = "RSPRRN")
	private String rspRRN;
	@Column(name = "RSPCODE")
	private String rspCode;
	@Column(name = "RSPDESC")
	private String rspDesc;
	@Column(name = "CUSTNAME")
	private String custName;
	@Column(name = "ACCOUNTBALANCE")
	private String accountBalance;
	@Column(name = "CUSTID")
	private String custID;
	@Transient
	private byte[] insuranceReq;
	@Transient
	private List<JoinAccount> accountList;

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

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getProcessingCode() {
		return processingCode;
	}

	public void setProcessingCode(String processingCode) {
		this.processingCode = processingCode;
	}

	public String getTransactionDateTime() {
		return transactionDateTime;
	}

	public byte[] getInsuranceReq() {
		return insuranceReq;
	}

	public void setInsuranceReq(byte[] insuranceReq) {
		this.insuranceReq = insuranceReq;
	}

	public String getRspRRN() {
		return rspRRN;
	}

	public void setRspRRN(String rspRRN) {
		this.rspRRN = rspRRN;
	}

	public String getRspCode() {
		return rspCode;
	}

	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}

	public String getRspDesc() {
		return rspDesc;
	}

	public void setRspDesc(String rspDesc) {
		this.rspDesc = rspDesc;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getTerminalID() {
		return terminalID;
	}

	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}

	public List<JoinAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<JoinAccount> accountList) {
		this.accountList = accountList;
	}

}
