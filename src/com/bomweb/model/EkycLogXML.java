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
import javax.persistence.Transient;

/**
 * @author SACHIN
 *
 */
@Entity
@Table(name = "ekyc_reqrsp_xml")

public class EkycLogXML {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EKYC_SEQ")
	@SequenceGenerator(name = "EKYC_SEQ", sequenceName = "EKYC_SEQ", allocationSize = 0)
	@Column(name = "LOG_ID")
	private int id;
	@Column(name = "TRN_DATE")
	private Date currentDate;
	@Column(name = "REQDMP")
	private Blob requestMsg;
	@Column(name = "RSPDMP")
	private Blob responseMsg;
	@Column(name = "REQ_uniqueNo")
	private String REQ_uniqueNo;
	@Column(name = "REQ_binUid")
	private String REQ_binUid;	
	@Column(name = "REQ_procCode")
	private String REQ_procCode;
	@Column(name = "REQ_txnDateTime")
	private String REQ_txnDateTime;
	@Column(name = "REQ_rrn")
	private String REQ_rrn;
	@Column(name = "REQ_frmBankCode")
	private String REQ_frmBankCode;	
	@Column(name = "REQ_txnTime")
	private String REQ_txnTime;
	@Column(name = "REQ_txnDate")
	private String REQ_txnDate;
	@Column(name = "REQ_CaptureDate")
	private String REQ_txnCaptureDate;
	@Column(name = "REQ_posEntryMode")
	private String REQ_posEntryMode;
	@Column(name = "REQ_posConditionCode")
	private String REQ_posConditionCode;
	@Column(name = "REQ_terminalID")
	private String REQ_terminalID;
	@Column(name = "REQ_cardAcceptorID")
	private String REQ_cardAcceptorID;
	@Column(name = "REQ_agentsInformation")
	private String REQ_agentsInformation;
	@Column(name = "REQ_terminalInfo")
	private String REQ_terminalInfo;		
	@Column(name = "REQ_datetime")
	private String REQ_datetime;
	@Column(name = "REQ_xmlData")
	private Blob REQ_xmlData;
	
	@Column(name = "RESresponseCode")
	private String responseCode;
	@Column(name = "RES_uniqueNo")
	private String RES_uniqueNo;
	@Column(name = "RES_binUid")
	private String RES_binUid;	
	@Column(name = "RES_procCode")
	private String RES_procCode;
	@Column(name = "RES_txnDateTime")
	private String RES_txnDateTime; 
	@Column(name = "RES_rrn")
	private String RES_rrn;
	@Column(name = "RES_frmBankCode")
	private String RES_frmBankCode;	
	@Column(name = "RES_txnTime")
	private String RES_txnTime;
	@Column(name = "RES_txnDate")
	private String RES_txnDate;
	@Column(name = "RES_posEntryMode")
	private String RES_posEntryMode;
	@Column(name = "RES_posConditionCode")
	private String RES_posConditionCode;
	@Column(name = "RES_terminalID")
	private String RES_terminalID;
	@Column(name = "RES_cardAcceptorID")
	private String RES_cardAcceptorID;
	@Column(name = "RES_agentsInformation")
	private String RES_agentsInformation; 
	@Column(name = "RES_terminalInfo")
	private String RES_terminalInfo; 	
	@Column(name = "RES_datetime")
	private String RES_datetime;	
	@Column(name = "RES_xmlData")
	private Blob RES_xmlData;
	@Transient
	private byte[] ekycReq;

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
	public byte[] getEkycReq() {
		return ekycReq;
	}

	public void setEkycReq(byte[] ekycReq) {
		this.ekycReq = ekycReq;
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
	 * @return the REQ_uniqueNo
	 */
	public String getREQ_uniqueNo() {
		return REQ_uniqueNo;
	}

	/**
	 * @param rEQ_uniqueNo
	 *            the rEQ_uniqueNo to set
	 */
	public void setREQ_uniqueNo(String rEQ_uniqueNo) {
		REQ_uniqueNo = rEQ_uniqueNo;
	}

	/**
	 * @return the REQ_binUid
	 */
	public String getREQ_binUid() {
		return REQ_binUid;
	}

	/**
	 * @param rEQ_binUid
	 *            the rEQ_binUid to set
	 */
	public void setREQ_binUid(String rEQ_binUid) {
		REQ_binUid = rEQ_binUid;
	}


	/**
	 * @return the REQ_procCode
	 */
	public String getREQ_procCode() {
		return REQ_procCode;
	}

	/**
	 * @param rEQ_procCode
	 *            the rEQ_procCode to set
	 */
	public void setREQ_procCode(String rEQ_procCode) {
		REQ_procCode = rEQ_procCode;
	}

	/**
	 * @return the REQ_txnDateTime
	 */
	public String getREQ_txnDateTime() {
		return REQ_txnDateTime;
	}

	/**
	 * @param rEQ_txnDateTime
	 *            the rEQ_txnDateTime to set
	 */
	public void setREQ_txnDateTime(String rEQ_txnDateTime) {
		REQ_txnDateTime = rEQ_txnDateTime;
	}

	/**
	 * @return the REQ_rrn
	 */
	public String getREQ_rrn() {
		return REQ_rrn;
	}

	/**
	 * @param rEQ_rrn
	 *            the rEQ_rrn to set
	 */
	public void setREQ_rrn(String rEQ_rrn) {
		REQ_rrn = rEQ_rrn;
	}

	/**
	 * @return the REQ_frmBankCode
	 */
	public String getREQ_frmBankCode() {
		return REQ_frmBankCode;
	}

	/**
	 * @param rEQ_frmBankCode
	 *            the rEQ_frmBankCode to set
	 */
	public void setREQ_frmBankCode(String rEQ_frmBankCode) {
		REQ_frmBankCode = rEQ_frmBankCode;
	}
	
	/**
	 * @return the REQ_txnTime
	 */
	public String getREQ_txnTime() {
		return REQ_txnTime;
	}

	/**
	 * @param rEQ_txnTime
	 *            the rEQ_txnTime to set
	 */
	public void setREQ_txnTime(String rEQ_txnTime) {
		REQ_txnTime = rEQ_txnTime;
	}

	/**
	 * @return the REQ_txnDate
	 */
	public String getREQ_txnDate() {
		return REQ_txnDate;
	}

	/**
	 * @param rEQ_txnDate
	 *            the rEQ_txnDate to set
	 */
	public void setREQ_txnDate(String rEQ_txnDate) {
		REQ_txnDate = rEQ_txnDate;
	}
	
	
	/**
	 * @return the REQ_posEntryMode
	 */
	public String getREQ_posEntryMode() {
		return REQ_posEntryMode;
	}

	/**
	 * @param rEQ_posEntryMode
	 *            the rEQ_posEntryMode to set
	 */
	public void setREQ_posEntryMode(String rEQ_posEntryMode) {
		REQ_posEntryMode = rEQ_posEntryMode;
	}

	
	/**
	 * @return the REQ_posConditionCode
	 */
	public String getREQ_posConditionCode() {
		return REQ_posConditionCode;
	}

	/**
	 * @param rEQ_posConditionCode
	 *            the rEQ_posConditionCode to set
	 */
	public void setREQ_posConditionCode(String rEQ_posConditionCode) {
		REQ_posConditionCode = rEQ_posConditionCode;
	}


	/**
	 * @return the REQ_terminalID
	 */
	public String getREQ_terminalID() {
		return REQ_terminalID;
	}

	/**
	 * @param rEQ_terminalID
	 *            the rEQ_terminalID to set
	 */
	public void setREQ_terminalID(String rEQ_terminalID) {
		REQ_terminalID = rEQ_terminalID;
	}
	/**
	 * @return the REQ_terminalID
	 */
	public String getREQ_terminalInfo() {
		return REQ_terminalInfo;
	}

	/**
	 * @param rEQ_terminalID
	 *            the rEQ_terminalID to set
	 */
	public void setREQ_terminalInfo(String rEQ_terminalInfo) {
		REQ_terminalInfo = rEQ_terminalInfo;
	}


	/**
	 * @return the REQ_cardAcceptorID
	 */
	public String getREQ_cardAcceptorID() {
		return REQ_cardAcceptorID;
	}

	/**
	 * @param rEQ_terminalID
	 *            the rEQ_cardAcceptorID to set
	 */
	public void setREQ_cardAcceptorID(String rEQ_cardAcceptorID) {
		REQ_cardAcceptorID = rEQ_cardAcceptorID;
	}

	/**
	 * @return the REQ_agentsInformation
	 */
	public String getREQ_agentsInformation() {
		return REQ_agentsInformation;
	}

	/**
	 * @param rEQ_agentsInformation
	 *            the rEQ_agentsInformation to set
	 */
	public void setREQ_agentsInformation(String rEQ_agentsInformation) {
		REQ_agentsInformation = rEQ_agentsInformation;
	}
	

	/**
	 * @return the datetime
	 */
	public String getREQ_Datetime() {
		return REQ_datetime;
	}

	/**
	 * @param datetime
	 *            the datetime to set
	 */
	public void setREQ_datetime(String rEQ_datetime) {
		this.REQ_datetime = rEQ_datetime;
	}

	
	/**
	 * @return the xmlData
	 */
	public Blob getREQ_xmlData() {
		return REQ_xmlData;
	}

	/**
	 * @param xmlData
	 *            the xmlData to set
	 */
	public void setREQ_xmlData(Blob rEQ_xmlData) {
		this.REQ_xmlData = rEQ_xmlData;
	}

	/**
	 * @return the RES_uniqueNo
	 */
	public String getRES_uniqueNo() {
		return RES_uniqueNo;
	}

	/**
	 * @param rES_accountNo
	 *            the rES_accountNo to set
	 */
	public void setRES_uniqueNo(String rES_uniqueNo) {
		RES_uniqueNo = rES_uniqueNo;
	}

	/**
	 * @return the RES_procCode
	 */
	public String getRES_procCode() {
		return RES_procCode;
	}

	/**
	 * @param rES_procCode
	 *            the rES_procCode to set
	 */
	public void setRES_procCode(String rES_procCode) {
		RES_procCode = rES_procCode;
	}

	/**
	 * @return the RES_txnDateTime
	 */
	public String getRES_txnDateTime() {
		return RES_txnDateTime;
	}

	/**
	 * @param rES_txnDateTime
	 *            the rES_txnDateTime to set
	 */
	public void setRES_txnDateTime(String rES_txnDateTime) {
		RES_txnDateTime = rES_txnDateTime;
	}

	/**
	 * @return the RES_rrn
	 */
	public String getRES_rrn() {
		return RES_rrn;
	}

	/**
	 * @param rES_rrn
	 *            the rES_rrn to set
	 */
	public void setRES_rrn(String rES_rrn) {
		RES_rrn = rES_rrn;
	}

	/**
	 * @return the RES_frmBankCode
	 */
	public String getRES_frmBankCode() {
		return RES_frmBankCode;
	}

	/**
	 * @param rES_frmBankCode
	 *            the rES_frmBankCode to set
	 */
	public void setRES_frmBankCode(String rES_frmBankCode) {
		RES_frmBankCode = rES_frmBankCode;
	}

	/**
	 * @return the RES_txnTime
	 */
	public String getRES_txnTime() {
		return RES_txnTime;
	}

	/**
	 * @param rES_txnTime
	 *            the rES_txnTime to set
	 */
	public void setRES_txnTime(String rES_txnTime) {
		RES_txnTime = rES_txnTime;
	}

	/**
	 * @return the RES_txnDate
	 */
	public String getRES_txnDate() {
		return RES_txnDate;
	}

	/**
	 * @param rES_txnDate
	 *            the rES_txnDate to set
	 */
	public void setRES_txnDate(String rES_txnDate) {
		RES_txnDate = rES_txnDate;
	}
	/**
	 * @return the RES_posEntryMode
	 */
	public String getRES_posEntryMode() {
		return RES_posEntryMode;
	}

	/**
	 * @param rES_posEntryMode
	 *            the rES_posEntryMode to set
	 */
	public void setRES_posEntryMode(String rES_posEntryMode) {
		RES_posEntryMode = rES_posEntryMode;
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
	 * @return the RES_posConditionCode
	 */
	public String getRES_posConditionCode() {
		return RES_posConditionCode;
	}

	/**
	 * @param rES_posConditionCode
	 *            the rES_posConditionCode to set
	 */
	public void setRES_posConditionCode(String rES_posConditionCode) {
		RES_posConditionCode = rES_posConditionCode;
	}


	/**
	 * @return the RES_terminalID
	 */
	public String getRES_terminalID() {
		return RES_terminalID;
	}

	/**
	 * @param rES_terminalID
	 *            the rES_terminalID to set
	 */
	public void setRES_terminalID(String rES_terminalID) {
		RES_terminalID = rES_terminalID;
	}


	/**
	 * @return the RES_cardAcceptorID
	 */
	public String getRES_cardAcceptorID() {
		return RES_cardAcceptorID;
	}

	/**
	 * @param rES_terminalID
	 *            the rES_cardAcceptorID to set
	 */
	public void setRES_cardAcceptorID(String rES_cardAcceptorID) {
		RES_cardAcceptorID = rES_cardAcceptorID;
	}

	/**
	 * @return the RES_agentsInformation
	 */
	public String getRES_agentsInformation() {
		return RES_agentsInformation;
	}

	/**
	 * @param rES_agentsInformation
	 *            the rES_agentsInformation to set
	 */
	public void setRES_agentsInformation(String rES_agentsInformation) {
		RES_agentsInformation = rES_agentsInformation;
	}
	
	/**
	 * @return the rES_terminalInfo
	 */
	public String getRES_terminalInfo() {
		return RES_terminalInfo;
	}

	/**
	 * @param rES_terminalInfo
	 *            the rES_terminalInfo to set
	 */
	public void setRES_terminalInfo(String rES_terminalInfo) {
		RES_terminalInfo = rES_terminalInfo;
	}


	/**
	 * @return the RES_datetime
	 */
	public String getRES_datetime() {
		return RES_datetime;
	}

	/**
	 * @param rES_datetime
	 *            the rES_datetime to set
	 */
	public void setRES_datetime(String rES_datetime) {
		this.RES_datetime = rES_datetime;
	}

	
	/**
	 * @return the RES_xmlData
	 */
	public Blob getRES_xmlData() {
		return RES_xmlData;
	}

	/**
	 * @param xmlData
	 *            the xmlData to set
	 */
	public void setRES_xmlData(Blob rES_xmlData) {
		this.RES_xmlData = rES_xmlData;
	}


}
