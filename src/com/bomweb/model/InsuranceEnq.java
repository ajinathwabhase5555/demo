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
@Table(name = "insurance_enq")
public class InsuranceEnq {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSURANCEENQ_SEQ")
	@SequenceGenerator(name = "INSURANCEENQ_SEQ", sequenceName = "INSURANCEENQ_SEQ", allocationSize = 0)
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
	@Column(name = "RSPRRN")
	private String rspRRN;
	@Column(name = "RSPCODE")
	private String rspCode;
	@Column(name = "RSPDESC")
	private String rspDesc;
	@Column(name = "CIF")
	private String cif;
	@Column(name = "ADDRESS1")
	private String address1;
	@Column(name = "ADDRESS2")
	private String address2;
	@Column(name = "BRANCHID")
	private String branchID;
	@Column(name = "CITY")
	private String city;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "CUSTOMERNAME")
	private String customerName;
	@Column(name = "DOB")
	private String dob;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "MOBILENO")
	private String mobileNo;
	@Column(name = "PANNO")
	private String panNo;
	@Column(name = "UIDNO")
	private String uidNo;
	@Transient
	private byte[] insuranceReq;

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

	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
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

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getUidNo() {
		return uidNo;
	}

	public void setUidNo(String uidNo) {
		this.uidNo = uidNo;
	}

	public byte[] getInsuranceReq() {
		return insuranceReq;
	}

	public void setInsuranceReq(byte[] insuranceReq) {
		this.insuranceReq = insuranceReq;
	}

}
