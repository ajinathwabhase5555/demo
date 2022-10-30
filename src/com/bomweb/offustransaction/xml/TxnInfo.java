/**
 * 
 */
package com.bomweb.offustransaction.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author SACHIN
 *
 */
@XmlRootElement(name = "com.bomweb.transaction.FIGWebReqSvc")
public class TxnInfo {

	private String funcCode;
	private String pan;
	private String procCode;
	private String txnDateTime;
	private String mcc;
	private String posEntryMode;
	private String posCode;
	private String acqId;
	private String track2Data;
	private String rrn;
	private String terminalId;
	private String caId;
	private String caLocn;
	private String terminalData;
	private String agentId;
	private String serviceChrg;
	private String txnMode;
	private String orgTxnRefId;
	private String narration;
	private String txnHmac;
	private String uniqueNo;
	private String expDate;
	private String setlDate;
	private String posCaptCode;
	private String refSeq;

	/**
	 * @return the funcCode
	 */
	@XmlElement(name = "funcCode")
	public String getFuncCode() {
		return funcCode;
	}

	/**
	 * @param funcCode
	 *            the funcCode to set
	 */
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}

	/**
	 * @return the pan
	 */
	@XmlElement(name = "pan")
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
	 * @return the procCode
	 */
	@XmlElement(name = "procCode")
	public String getProcCode() {
		return procCode;
	}

	/**
	 * @param procCode
	 *            the procCode to set
	 */
	public void setProcCode(String procCode) {
		this.procCode = procCode;
	}

	/**
	 * @return the txnDateTime
	 */
	@XmlElement(name = "txnDateTime")
	public String getTxnDateTime() {
		return txnDateTime;
	}

	/**
	 * @param txnDateTime
	 *            the txnDateTime to set
	 */
	public void setTxnDateTime(String txnDateTime) {
		this.txnDateTime = txnDateTime;
	}

	/**
	 * @return the mcc
	 */
	@XmlElement(name = "mcc")
	public String getMcc() {
		return mcc;
	}

	/**
	 * @param mcc
	 *            the mcc to set
	 */
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	/**
	 * @return the posEntryMode
	 */
	@XmlElement(name = "posEntryMode")
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
	@XmlElement(name = "posCode")
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
	 * @return the acqId
	 */
	@XmlElement(name = "acqId")
	public String getAcqId() {
		return acqId;
	}

	/**
	 * @param acqId
	 *            the acqId to set
	 */
	public void setAcqId(String acqId) {
		this.acqId = acqId;
	}

	/**
	 * @return the track2Data
	 */
	@XmlElement(name = "track2Data")
	public String getTrack2Data() {
		return track2Data;
	}

	/**
	 * @param track2Data
	 *            the track2Data to set
	 */
	public void setTrack2Data(String track2Data) {
		this.track2Data = track2Data;
	}

	/**
	 * @return the rrn
	 */
	@XmlElement(name = "rrn")
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
	 * @return the terminalId
	 */
	@XmlElement(name = "terminalId")
	public String getTerminalId() {
		return terminalId;
	}

	/**
	 * @param terminalId
	 *            the terminalId to set
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * @return the caId
	 */
	@XmlElement(name = "caId")
	public String getCaId() {
		return caId;
	}

	/**
	 * @param caId
	 *            the caId to set
	 */
	public void setCaId(String caId) {
		this.caId = caId;
	}

	/**
	 * @return the caLocn
	 */
	@XmlElement(name = "caLocn")
	public String getCaLocn() {
		return caLocn;
	}

	/**
	 * @param caLocn
	 *            the caLocn to set
	 */
	public void setCaLocn(String caLocn) {
		this.caLocn = caLocn;
	}

	/**
	 * @return the terminalData
	 */
	@XmlElement(name = "terminalData")
	public String getTerminalData() {
		return terminalData;
	}

	/**
	 * @param terminalData
	 *            the terminalData to set
	 */
	public void setTerminalData(String terminalData) {
		this.terminalData = terminalData;
	}

	/**
	 * @return the agentId
	 */
	@XmlElement(name = "agentId")
	public String getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId
	 *            the agentId to set
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the txnMode
	 */
	@XmlElement(name = "txnMode")
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
	 * @return the narration
	 */
	@XmlElement(name = "narration")
	public String getNarration() {
		return narration;
	}

	/**
	 * @param narration
	 *            the narration to set
	 */
	public void setNarration(String narration) {
		this.narration = narration;
	}

	/**
	 * @return the txnHmac
	 */
	@XmlElement(name = "txnHmac")
	public String getTxnHmac() {
		return txnHmac;
	}

	/**
	 * @param txnHmac
	 *            the txnHmac to set
	 */
	public void setTxnHmac(String txnHmac) {
		this.txnHmac = txnHmac;
	}

	/**
	 * @return the uniqueNo
	 */
	@XmlElement(name = "uniqueNo")
	public String getUniqueNo() {
		return uniqueNo;
	}

	/**
	 * @param uniqueNo
	 *            the uniqueNo to set
	 */
	public void setUniqueNo(String uniqueNo) {
		this.uniqueNo = uniqueNo;
	}

	/**
	 * @return the serviceChrg
	 */
	@XmlElement(name = "serviceChrg")
	public String getServiceChrg() {
		return serviceChrg;
	}

	/**
	 * @param serviceChrg the serviceChrg to set
	 */
	public void setServiceChrg(String serviceChrg) {
		this.serviceChrg = serviceChrg;
	}

	/**
	 * @return the orgTxnRefId
	 */
	@XmlElement(name = "orgTxnRefId")
	public String getOrgTxnRefId() {
		return orgTxnRefId;
	}

	/**
	 * @param orgTxnRefId the orgTxnRefId to set
	 */
	public void setOrgTxnRefId(String orgTxnRefId) {
		this.orgTxnRefId = orgTxnRefId;
	}

	/**
	 * @return the expDate
	 */
	@XmlElement(name = "expDate")
	public String getExpDate() {
		return expDate;
	}

	/**
	 * @param expDate the expDate to set
	 */
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	/**
	 * @return the setlDate
	 */
	@XmlElement(name = "setlDate")
	public String getSetlDate() {
		return setlDate;
	}

	/**
	 * @param setlDate the setlDate to set
	 */
	public void setSetlDate(String setlDate) {
		this.setlDate = setlDate;
	}

	/**
	 * @return the posCaptCode
	 */
	@XmlElement(name = "posCaptCode")
	public String getPosCaptCode() {
		return posCaptCode;
	}

	/**
	 * @param posCaptCode the posCaptCode to set
	 */
	public void setPosCaptCode(String posCaptCode) {
		this.posCaptCode = posCaptCode;
	}

	/**
	 * @return the refSeq
	 */
	@XmlElement(name = "refSeq")
	public String getRefSeq() {
		return refSeq;
	}

	/**
	 * @param refSeq the refSeq to set
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
	}

	
}
