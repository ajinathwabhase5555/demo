/**
 * 
 */
package com.bomweb.ekyc;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Dattu
 *
 */
public class TransactionInfo {

	private String binUid;
	private String pan;
	private String processingCode;
	private String uniqueNo;
	private String txnDateTime;
	private String localTime;
	private String localDate;
	private String captureDate;
	private String vendorId;
	private String posEntryMode;
	private String posConditionCode;
	private String frmBankCode;
	private String retrivalRefNo;
	private String terminalId;
	private String cardAcceptorId;
	private String agentsInfo;
	private String userType;
	private String HandleId;
	private String terminalInfo;
	/**
	 * @return the binUid
	 */
	public String getBINUID() {
		return binUid;
	}
	/**
	 * @param binUid the binUid to set
	 */
	public void setBINUID(String binUid) {
		this.binUid = binUid;
	}
	/**
	 * @return the terminalInfo
	 */
	@XmlElement(name="TerminalInfo")
	public String getTerminalInfo() {
		return terminalInfo;
	}
	/**
	 * @param terminalInfo the terminalInfo to set
	 */
	public void setTerminalInfo(String terminalInfo) {
		this.terminalInfo = terminalInfo;
	}
	/**
	 * @return the procCode
	 */
	@XmlElement(name="processingCode")
	public String getprocessingCode() {
		return processingCode;
	}
	/**
	 * @param procCode the procCode to set
	 */
	public void setprocessingCode(String processingCode) {
		this.processingCode = processingCode;
	}
	/**
	 * @return the uniqueNo
	 */
	@XmlElement(name="UniqueNo")
	public String getUniqueNo() {
		return uniqueNo;
	}
	/**
	 * @param uniqueNo the uniqueNo to set
	 */
	public void setUniqueNo(String uniqueNo) {
		this.uniqueNo = uniqueNo;
	}
	/**
	 * @return the txnDateTime
	 */
	@XmlElement(name="DateTime")
	public String getDateTime() {
		return txnDateTime;
	}
	/**
	 * @param txnDateTime the txnDateTime to set
	 */
	public void setDateTime(String txnDateTime) {
		this.txnDateTime = txnDateTime;
	}
	/**
	 * @return the localTime
	 */
	@XmlElement(name="LocalTime")
	public String getLocalTime() {
		return localTime;
	}
	/**
	 * @param localTime the localTime to set
	 */
	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}
	/**
	 * @return the localDate
	 */
	@XmlElement(name="LocalDate")
	public String getLocalDate() {
		return localDate;
	}
	/**
	 * @param localDate the localDate to set
	 */
	public void setLocalDate(String localDate) {
		this.localDate = localDate;
	}
	/**
	 * @return the captureDate
	 */
	@XmlElement(name="CaptureDate")
	public String getCaptureDate() {
		return captureDate;
	}
	/**
	 * @param captureDate the captureDate to set
	 */
	public void setCaptureDate(String captureDate) {
		this.captureDate = captureDate;
	}
	/**
	 * @return the vendorId
	 */
	@XmlElement(name="VendorId")
	public String getVendorId() {
		return vendorId;
	}
	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	/**
	 * @return the posEntryMode
	 */
	@XmlElement(name="POSEntryMode")
	public String getPosEntryMode() {
		return posEntryMode;
	}
	/**
	 * @param posEntryMode the posEntryMode to set
	 */
	public void setPosEntryMode(String posEntryMode) {
		this.posEntryMode = posEntryMode;
	}
	/**
	 * @return the posConditionCode
	 */
	@XmlElement(name="POSConditionCode")
	public String getPosConditionCode() {
		return posConditionCode;
	}
	/**
	 * @param posConditionCode the posConditionCode to set
	 */
	public void setPosConditionCode(String posConditionCode) {
		this.posConditionCode = posConditionCode;
	}
	/**
	 * @return the frmBankCode
	 */
	@XmlElement(name="FrmBankCode")
	public String getFrmBankCode() {
		return frmBankCode;
	}
	/**
	 * @param frnBankCode the frnBankCode to set
	 */
	public void setFrmBankCode(String frmBankCode) {
		this.frmBankCode = frmBankCode;
	}
	/**
	 * @return the retrivalRefNo
	 */
	@XmlElement(name="RetrivalRefNo")
	public String getRetrivalRefNo() {
		return retrivalRefNo;
	}
	/**
	 * @param retrivalRefNo the retrivalRefNo to set
	 */
	public void setRetrivalRefNo(String retrivalRefNo) {
		this.retrivalRefNo = retrivalRefNo;
	}
	/**
	 * @return the terminalId
	 */
	@XmlElement(name="TerminalId")
	public String getTerminalId() {
		return terminalId;
	}
	/**
	 * @param terminalId the terminalId to set
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	/**
	 * @return the cardAcceptorId
	 */
	@XmlElement(name="CardAcceptorId")
	public String getCardAcceptorId() {
		return cardAcceptorId;
	}
	/**
	 * @param cardAcceptorId the cardAcceptorId to set
	 */
	public void setCardAcceptorId(String cardAcceptorId) {
		this.cardAcceptorId = cardAcceptorId;
	}
	/**
	 * @return the agentsInfo
	 */
	@XmlElement(name="AgentsInfo")
	public String getAgentsInfo() {
		return agentsInfo;
	}
	/**
	 * @param agentsInfo the agentsInfo to set
	 */
	public void setAgentsInfo(String agentsInfo) {
		this.agentsInfo = agentsInfo;
	}
	/**
	 * @return the userType
	 */
	@XmlElement(name="UserType")
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the handleId
	 */
	@XmlElement(name="HandleID")
	public String getHandleID() {
		return HandleId;
	}
	/**
	 * @param handleId the handleId to set
	 */
	public void setHandleID(String handleId) {
		this.HandleId = handleId;
	}
	

}
