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
@Table(name = "tran_neft_reqrsp")
public class NeftTxn {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEFT_SEQ")
	@SequenceGenerator(name = "NEFT_SEQ", sequenceName = "NEFT_SEQ", allocationSize = 0)
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
	@Column(name = "PAN")
	private String pan;
	@Column(name = "TXNDATETIME")
	private String txnDateTime;
	@Column(name = "MCC")
	private String mcc;
	@Column(name = "POSENTRYMODE")
	private String posEntryMode;
	@Column(name = "POSCODE")
	private String posCode;
	@Column(name = "ACQID")
	private String acqId;
	@Column(name = "RRN")
	private String rrn;
	@Column(name = "TERMINALID")
	private String terminalId;
	@Column(name = "CAID")
	private String caId;
	@Column(name = "AGENTID")
	private String agentId;
	@Column(name = "TXNMODE")
	private String txnMode;
	@Column(name = "AMOUNT")
	private String amount;
	@Column(name = "REMITACCOUNTNO")
	private String remitAccountNo;
	@Column(name = "REMITUIDNO")
	private String remitUidNo;
	@Column(name = "REMITNAME")
	private String remitName;
	@Column(name = "REMITSOLID")
	private String remitSolId;
	@Column(name = "REMITADDRESS")
	private String remitAddress;
	@Column(name = "REMITTERID")
	private String remitterId;
	@Column(name = "REMITMMID")
	private String remitMmid;
	@Column(name = "REMITMOBILENO")
	private String remitMobileNo;
	@Column(name = "BENNAME")
	private String benName;
	@Column(name = "BENACCOUNTNO")
	private String benAccountNo;
	@Column(name = "BENMOBILENO")
	private String benMobileNo;
	@Column(name = "BENIFSC")
	private String benIFSC;
	@Column(name = "BENBANKNAME")
	private String benBankName;
	@Column(name = "BENBRANCHNAME")
	private String benBranchName;

	@Column(name = "RESPONSECODE")
	private String responseCode;
	@Column(name = "RESPONSEDESC")
	private String responseDesc;
	@Column(name = "RSPRRN")
	private String rspRRN;
	@Column(name = "RSPJOURNALNO")
	private String rspJournalNo;
	@Column(name = "RSPAUTHCODE")
	private String rspAuthCode;
	@Column(name = "RSPTXNTYPE")
	private String rspTxnType;
	@Column(name = "RSPGWRRN")
	private String rspGwrrn;
	@Column(name = "RSPAMOUNT")
	private String rspAmount;
	@Column(name = "RSPBENEFICIARYNAME")
	private String rspBeneficiaryName;

	@Transient
	private byte[] neftReq;

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
	 * @return the txnDateTime
	 */
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
	 * @return the acqId
	 */
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
	 * @return the terminalId
	 */
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
	 * @return the agentId
	 */
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
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the remitAccountNo
	 */
	public String getRemitAccountNo() {
		return remitAccountNo;
	}

	/**
	 * @param remitAccountNo
	 *            the remitAccountNo to set
	 */
	public void setRemitAccountNo(String remitAccountNo) {
		this.remitAccountNo = remitAccountNo;
	}

	/**
	 * @return the remitUidNo
	 */
	public String getRemitUidNo() {
		return remitUidNo;
	}

	/**
	 * @param remitUidNo
	 *            the remitUidNo to set
	 */
	public void setRemitUidNo(String remitUidNo) {
		this.remitUidNo = remitUidNo;
	}

	/**
	 * @return the remitName
	 */
	public String getRemitName() {
		return remitName;
	}

	/**
	 * @param remitName
	 *            the remitName to set
	 */
	public void setRemitName(String remitName) {
		this.remitName = remitName;
	}

	/**
	 * @return the remitSolId
	 */
	public String getRemitSolId() {
		return remitSolId;
	}

	/**
	 * @param remitSolId
	 *            the remitSolId to set
	 */
	public void setRemitSolId(String remitSolId) {
		this.remitSolId = remitSolId;
	}

	/**
	 * @return the remitAddress
	 */
	public String getRemitAddress() {
		return remitAddress;
	}

	/**
	 * @param remitAddress
	 *            the remitAddress to set
	 */
	public void setRemitAddress(String remitAddress) {
		this.remitAddress = remitAddress;
	}

	/**
	 * @return the remitterId
	 */
	public String getRemitterId() {
		return remitterId;
	}

	/**
	 * @param remitterId
	 *            the remitterId to set
	 */
	public void setRemitterId(String remitterId) {
		this.remitterId = remitterId;
	}

	/**
	 * @return the remitMmid
	 */
	public String getRemitMmid() {
		return remitMmid;
	}

	/**
	 * @param remitMmid
	 *            the remitMmid to set
	 */
	public void setRemitMmid(String remitMmid) {
		this.remitMmid = remitMmid;
	}

	/**
	 * @return the remitMobileNo
	 */
	public String getRemitMobileNo() {
		return remitMobileNo;
	}

	/**
	 * @param remitMobileNo
	 *            the remitMobileNo to set
	 */
	public void setRemitMobileNo(String remitMobileNo) {
		this.remitMobileNo = remitMobileNo;
	}

	/**
	 * @return the benName
	 */
	public String getBenName() {
		return benName;
	}

	/**
	 * @param benName
	 *            the benName to set
	 */
	public void setBenName(String benName) {
		this.benName = benName;
	}

	/**
	 * @return the benAccountNo
	 */
	public String getBenAccountNo() {
		return benAccountNo;
	}

	/**
	 * @param benAccountNo
	 *            the benAccountNo to set
	 */
	public void setBenAccountNo(String benAccountNo) {
		this.benAccountNo = benAccountNo;
	}

	/**
	 * @return the benMobileNo
	 */
	public String getBenMobileNo() {
		return benMobileNo;
	}

	/**
	 * @param benMobileNo
	 *            the benMobileNo to set
	 */
	public void setBenMobileNo(String benMobileNo) {
		this.benMobileNo = benMobileNo;
	}

	/**
	 * @return the benIFSC
	 */
	public String getBenIFSC() {
		return benIFSC;
	}

	/**
	 * @param benIFSC
	 *            the benIFSC to set
	 */
	public void setBenIFSC(String benIFSC) {
		this.benIFSC = benIFSC;
	}

	/**
	 * @return the benBankName
	 */
	public String getBenBankName() {
		return benBankName;
	}

	/**
	 * @param benBankName
	 *            the benBankName to set
	 */
	public void setBenBankName(String benBankName) {
		this.benBankName = benBankName;
	}

	/**
	 * @return the benBranchName
	 */
	public String getBenBranchName() {
		return benBranchName;
	}

	/**
	 * @param benBranchName
	 *            the benBranchName to set
	 */
	public void setBenBranchName(String benBranchName) {
		this.benBranchName = benBranchName;
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
	 * @return the rspJournalNo
	 */
	public String getRspJournalNo() {
		return rspJournalNo;
	}

	/**
	 * @param rspJournalNo
	 *            the rspJournalNo to set
	 */
	public void setRspJournalNo(String rspJournalNo) {
		this.rspJournalNo = rspJournalNo;
	}

	/**
	 * @return the rspAuthCode
	 */
	public String getRspAuthCode() {
		return rspAuthCode;
	}

	/**
	 * @param rspAuthCode
	 *            the rspAuthCode to set
	 */
	public void setRspAuthCode(String rspAuthCode) {
		this.rspAuthCode = rspAuthCode;
	}

	/**
	 * @return the rspTxnType
	 */
	public String getRspTxnType() {
		return rspTxnType;
	}

	/**
	 * @param rspTxnType
	 *            the rspTxnType to set
	 */
	public void setRspTxnType(String rspTxnType) {
		this.rspTxnType = rspTxnType;
	}

	/**
	 * @return the rspGwrrn
	 */
	public String getRspGwrrn() {
		return rspGwrrn;
	}

	/**
	 * @param rspGwrrn
	 *            the rspGwrrn to set
	 */
	public void setRspGwrrn(String rspGwrrn) {
		this.rspGwrrn = rspGwrrn;
	}

	/**
	 * @return the rspAmount
	 */
	public String getRspAmount() {
		return rspAmount;
	}

	/**
	 * @param rspAmount
	 *            the rspAmount to set
	 */
	public void setRspAmount(String rspAmount) {
		this.rspAmount = rspAmount;
	}

	/**
	 * @return the rspBeneficiaryName
	 */
	public String getRspBeneficiaryName() {
		return rspBeneficiaryName;
	}

	/**
	 * @param rspBeneficiaryName
	 *            the rspBeneficiaryName to set
	 */
	public void setRspBeneficiaryName(String rspBeneficiaryName) {
		this.rspBeneficiaryName = rspBeneficiaryName;
	}

	/**
	 * @return the impsReq
	 */
	public byte[] getNeftReq() {
		return neftReq;
	}

	/**
	 * @param impsReq
	 *            the impsReq to set
	 */
	public void setNeftReq(byte[] neftReq) {
		this.neftReq = neftReq;
	}

}
